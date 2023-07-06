package com.example.flight_ticket_booking.service.user;

import com.example.flight_ticket_booking.dto.BaseResponse;
import com.example.flight_ticket_booking.dto.GenericResponse;
import com.example.flight_ticket_booking.dto.user.UserDto;

import java.util.List;

public interface UserService {

    BaseResponse saveUser(UserDto userDto);

    BaseResponse updateUser(UserDto userDto);

    List<UserDto> getAllUser();

    GenericResponse<UserDto> getUserById(Long id);

    BaseResponse deleteUser(Long id);

    UserDto findByEmail(String email);
}
