package com.example.flight_ticket_booking.service.token;

import com.example.flight_ticket_booking.dto.BaseResponse;
import com.example.flight_ticket_booking.dto.user.UserDto;
import com.example.flight_ticket_booking.entity.user.User;

public interface TokenService {

    BaseResponse saveAuthToken(UserDto user, String token);

    User findUserByToken(String token);
}
