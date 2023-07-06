package com.example.flight_ticket_booking.dto.login;

import com.example.flight_ticket_booking.dto.GenericResponse;
import com.example.flight_ticket_booking.dto.user.UserDto;


public class LoginResponse extends GenericResponse<UserDto> {

    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
