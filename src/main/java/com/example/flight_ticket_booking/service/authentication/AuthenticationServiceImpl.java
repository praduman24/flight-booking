package com.example.flight_ticket_booking.service.authentication;

import com.example.flight_ticket_booking.dto.login.LoginRequest;
import com.example.flight_ticket_booking.dto.login.LoginResponse;
import com.example.flight_ticket_booking.dto.user.UserDto;
import com.example.flight_ticket_booking.entity.user.User;
import com.example.flight_ticket_booking.service.token.TokenService;
import com.example.flight_ticket_booking.service.user.UserService;
import com.example.flight_ticket_booking.utils.Constants;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private UserService userService;

    @Autowired
    private TokenService tokenService;

    @Override
    public LoginResponse loginUser(LoginRequest loginRequest) {
        LoginResponse loginResponse = new LoginResponse();
        UserDto user = userService.findByEmail(loginRequest.getEmail());
        if (user == null) {
            loginResponse.setStatus(false);
            loginResponse.setMessage(Constants.WRONG_EMAIL);
            return loginResponse;
        }

        if (!BCrypt.checkpw(loginRequest.getPassword(), user.getPassword())) {
            loginResponse.setStatus(false);
            loginResponse.setMessage(Constants.WRONG_PASSWORD);
            return loginResponse;
        }

        String token = "FT" + System.currentTimeMillis() + Math.random();

        tokenService.saveAuthToken(user, token);

        loginResponse.setMessage(Constants.SUCCESS);
        loginResponse.setStatus(true);
        loginResponse.setToken(token);
        loginResponse.setDto(user);
        return loginResponse;

    }

    @Override
    public Long getLoginedClient() {
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getCredentials();
        return user.getId();
    }


}
