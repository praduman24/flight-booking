package com.example.flight_ticket_booking.service.token;

import com.example.flight_ticket_booking.dto.BaseResponse;
import com.example.flight_ticket_booking.dto.user.UserDto;
import com.example.flight_ticket_booking.entity.tokens.Tokens;
import com.example.flight_ticket_booking.entity.user.User;
import com.example.flight_ticket_booking.repository.token.TokenRepository;
import com.example.flight_ticket_booking.utils.Constants;
import com.example.flight_ticket_booking.utils.UserRoles;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class TokenServiceImpl implements TokenService{

    @Autowired
    private TokenRepository tokenRepository;

    @Override
    public BaseResponse saveAuthToken(UserDto user, String token) {
        BaseResponse response = new BaseResponse();
        StringBuffer buffer = new StringBuffer();
        buffer.append(user.getId());
        buffer.append("$");
        buffer.append(user.getEmail());
        buffer.append("$");
        buffer.append(user.getRole());

        Tokens tokens = new Tokens();
        tokens.setToken(token);
        tokens.setUser(buffer.toString());
        tokens.setCreatedBy(1L);
        tokens.setCreatedOn(System.currentTimeMillis());
        tokens.setModifiedOn(System.currentTimeMillis());
        tokens.setModifiedBy(1L);

        tokenRepository.save(tokens);

        response.setMessage(Constants.SUCCESS);
        response.setStatus(true);
        return response;
    }

    @Override
    public User findUserByToken(String token) {
        Tokens tokens = tokenRepository.findByToken(token);
        String[] values = tokens.getUser().split("\\$");
        User user = new User();
        user.setId(Long.parseLong(values[0]));
        user.setEmail(values[1]);
        user.setRole(UserRoles.valueOf(values[2]));
        return user;
    }
}
