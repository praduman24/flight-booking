package com.example.flight_ticket_booking.service.user;

import com.example.flight_ticket_booking.converter.DtoToEntityConverter;
import com.example.flight_ticket_booking.converter.EntityToDtoConverter;
import com.example.flight_ticket_booking.converter.user.UserDtoToUserConverter;
import com.example.flight_ticket_booking.converter.user.UserToUserDtoConverter;
import com.example.flight_ticket_booking.dto.BaseResponse;
import com.example.flight_ticket_booking.dto.GenericResponse;
import com.example.flight_ticket_booking.dto.user.UserDto;
import com.example.flight_ticket_booking.entity.user.User;
import com.example.flight_ticket_booking.repository.user.UserRepository;
import com.example.flight_ticket_booking.utils.Constants;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private static final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);
    private static DtoToEntityConverter<UserDto,User> dtoToEntityConverter = new UserDtoToUserConverter();

    private static EntityToDtoConverter<User,UserDto> entityToDtoConverter = new UserToUserDtoConverter();
    @Autowired
    private UserRepository userRepository;

    @Override
    public BaseResponse saveUser(UserDto userDto) {
       BaseResponse response = new BaseResponse();
       Optional<User> user = userRepository.findByEmail(userDto.getEmail());
        if (user.isPresent()) {
            LOG.error("{} is already in the DB. \n", userDto.getEmail());
            response.setStatus(false);
            response.setMessage(Constants.USER_IS_ALREADY_PRESENT);
            return response;
        }
        String salt = BCrypt.gensalt();
        String password = BCrypt.hashpw(userDto.getPassword(), salt);
        userDto.setPassword(password);
        User userObj = dtoToEntityConverter.convert(userDto);
        userObj.setCreatedBy(1L);
        userObj.setCreatedOn(System.currentTimeMillis());

        userRepository.save(userObj);

        LOG.info("{}, added as new User in the DB. \n", userDto.getName());
        response.setStatus(true);
        response.setMessage(Constants.SUCCESS);
        return response;
    }

    @Override
    public BaseResponse updateUser(UserDto userDto) {
        BaseResponse response = new BaseResponse();
        Optional<User> user = userRepository.findById(userDto.getId());
        if (!user.isPresent()) {
            LOG.error("{} is not present in the DB. \n", userDto.getEmail());
            response.setStatus(false);
            response.setMessage(Constants.USER_IS_NOT_PRESENT);
            return response;
        }
        if(!BCrypt.checkpw(userDto.getPassword(),user.get().getPassword())){
            String salt = BCrypt.gensalt();
            String password = BCrypt.hashpw(userDto.getPassword(), salt);
            userDto.setPassword(password);
        }
        User userObj = dtoToEntityConverter.convert(userDto);
        userObj.setModifiedBy(1L);
        userObj.setModifiedOn(System.currentTimeMillis());

        userRepository.save(userObj);

        LOG.info("{}, updated user in the DB. \n", userDto.getName());
        response.setStatus(true);
        response.setMessage(Constants.SUCCESS);
        return response;
    }

    @Override
    public List<UserDto> getAllUser() {
        return userRepository.findAll().stream().map(entityToDtoConverter::convert).collect(Collectors.toList());
    }

    @Override
    public GenericResponse<UserDto> getUserById(Long id) {
        GenericResponse response = new GenericResponse();
        Optional<User> user = userRepository.findById(id);
        if (!user.isPresent()) {
            LOG.error("user is not present in the DB. with the given id {} \n", id);
            response.setStatus(false);
            response.setMessage(Constants.USER_IS_NOT_PRESENT_BY_ID);
            return response;
        }
        response.setDto(entityToDtoConverter.convert(user.get()));
        response.setStatus(true);
        response.setMessage(Constants.SUCCESS);
        return response;
    }

    @Override
    public BaseResponse deleteUser(Long id) {
        GenericResponse response = new GenericResponse();
        Optional<User> user = userRepository.findById(id);
        if (!user.isPresent()) {
            LOG.error("user is not present in the DB. with the given id {} \n", id);
            response.setStatus(false);
            response.setMessage(Constants.USER_IS_NOT_PRESENT_BY_ID);
            return response;
        }
        user.get().setModifiedBy(1L);
        user.get().setModifiedOn(System.currentTimeMillis());
        user.get().setActive(false);
        userRepository.save(user.get());
        response.setStatus(true);
        response.setMessage(Constants.SUCCESS);
        return response;
    }

    @Override
    public UserDto findByEmail(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isPresent()) {
            return entityToDtoConverter.convert(user.get());
        }
        return null;
    }
}
