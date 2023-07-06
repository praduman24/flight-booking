package com.example.flight_ticket_booking.controller;

import com.example.flight_ticket_booking.dto.login.LoginRequest;
import com.example.flight_ticket_booking.dto.login.LoginResponse;
import com.example.flight_ticket_booking.service.authentication.AuthenticationService;
import com.example.flight_ticket_booking.utils.Constants;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("login")
    public ResponseEntity<LoginResponse> userLogin(@Valid @RequestBody LoginRequest loginRequest){
         LoginResponse response = new LoginResponse();
         try{
             response = authenticationService.loginUser(loginRequest);
         }catch (Exception ex){
             response.setStatus(false);
             response.setMessage(Constants.FAILURE);
         }
         return new ResponseEntity<>(response, HttpStatus.OK);
    }


}
