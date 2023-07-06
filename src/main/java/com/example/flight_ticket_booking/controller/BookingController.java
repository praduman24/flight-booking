package com.example.flight_ticket_booking.controller;

import com.example.flight_ticket_booking.dto.BaseResponse;
import com.example.flight_ticket_booking.dto.GenericResponse;
import com.example.flight_ticket_booking.dto.booking.BookingDto;
import com.example.flight_ticket_booking.service.booking.BookingService;
import com.example.flight_ticket_booking.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/booking")
public class BookingController {

    @Autowired
     private BookingService bookingService;

    @PostMapping("create")
    public ResponseEntity<BaseResponse> createBookings(@RequestBody BookingDto bookingDto){
         BaseResponse response = new BaseResponse();
         try{
             response = bookingService.createBooking(bookingDto);
         }catch(Exception ex){
             response.setMessage(Constants.FAILURE);
             response.setStatus(false);
         }
         return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("get")
    public ResponseEntity<GenericResponse<BookingDto>> getAllTheBookings(){
        GenericResponse<BookingDto> response = new GenericResponse<>();
        try{
            response.setDtoList(bookingService.listOfAllTheBooking());
            response.setStatus(true);
            response.setMessage(Constants.SUCCESS);
        }catch(Exception ex){
            response.setMessage(Constants.FAILURE);
            response.setStatus(false);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
