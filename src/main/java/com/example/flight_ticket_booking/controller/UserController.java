package com.example.flight_ticket_booking.controller;

import com.example.flight_ticket_booking.dto.BaseResponse;
import com.example.flight_ticket_booking.dto.GenericResponse;
import com.example.flight_ticket_booking.dto.user.UserDto;
import com.example.flight_ticket_booking.service.user.UserService;
import com.example.flight_ticket_booking.utils.Constants;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/user/")
public class UserController {

    @Autowired
    private UserService userService;

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("get-all")
    public ResponseEntity<GenericResponse<UserDto>> getAllUser() {
        GenericResponse<UserDto> response = new GenericResponse<>();
        try {
            response.setDtoList(userService.getAllUser());
        } catch (Exception ex) {
            response.setStatus(false);
            response.setMessage(Constants.FAILURE);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("get")
    public ResponseEntity<GenericResponse<UserDto>> getUserById(@RequestParam(name = "id") Long id) {
        GenericResponse<UserDto> response = new GenericResponse<>();
        try {
            response = userService.getUserById(id);
        } catch (Exception ex) {
            response.setStatus(false);
            response.setMessage(Constants.FAILURE);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("save")
    public ResponseEntity<BaseResponse> saveUser(@Valid @RequestBody UserDto userDto) {
        BaseResponse response = new BaseResponse();
        try {
            response = userService.saveUser(userDto);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception ex) {
            response.setStatus(false);
            response.setMessage(Constants.FAILURE);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

    @PostMapping("update")
    public ResponseEntity<BaseResponse> updateUser(@Valid @RequestBody UserDto userDto) {
        BaseResponse response = new BaseResponse();
        try {
            response = userService.saveUser(userDto);
        } catch (Exception ex) {
            response.setStatus(false);
            response.setMessage(Constants.FAILURE);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @DeleteMapping("delete")
    public ResponseEntity<BaseResponse> deleteUser(@PathVariable("id") Long id) {
        BaseResponse response = new BaseResponse();
        try {
            response = userService.deleteUser(id);
        } catch (Exception ex) {
            response.setStatus(false);
            response.setMessage(Constants.FAILURE);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}
