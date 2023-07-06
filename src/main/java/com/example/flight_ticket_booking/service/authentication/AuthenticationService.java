package com.example.flight_ticket_booking.service.authentication;

import com.example.flight_ticket_booking.dto.login.LoginRequest;
import com.example.flight_ticket_booking.dto.login.LoginResponse;

public interface AuthenticationService {

    LoginResponse loginUser(LoginRequest loginRequest);

    Long getLoginedClient();

}
