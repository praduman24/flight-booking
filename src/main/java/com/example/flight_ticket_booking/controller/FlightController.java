package com.example.flight_ticket_booking.controller;

import com.example.flight_ticket_booking.dto.BaseResponse;
import com.example.flight_ticket_booking.dto.GenericResponse;
import com.example.flight_ticket_booking.dto.flight.FlightDto;
import com.example.flight_ticket_booking.dto.flight.FlightFetchRequest;
import com.example.flight_ticket_booking.service.flight.FlightService;
import com.example.flight_ticket_booking.utils.Constants;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;

@CrossOrigin
@RestController
@RequestMapping("/api/flight/")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("get-all")
    public ResponseEntity<GenericResponse<FlightDto>> getAllFlight(@RequestParam(name = "startTime", required = false) LocalTime startTime,
                                                                   @RequestParam(name = "endTime", required = false) LocalTime endTime,
                                                                   @RequestParam(name = "active", required = false, defaultValue = "true") Boolean active
    ) {
        FlightFetchRequest ff = createFlightFetchRequest(startTime, endTime, active);
        GenericResponse<FlightDto> response = new GenericResponse<>();
        try {
            response.setDtoList(flightService.getAllFlight(ff));
        } catch (Exception ex) {
            response.setStatus(false);
            response.setMessage(Constants.FAILURE);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping("save")
    public ResponseEntity<BaseResponse> saveFlight(@Valid @RequestBody FlightDto flightDto) {
        BaseResponse response = new BaseResponse();
        try {
            response = flightService.saveFlight(flightDto);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception ex) {
            response.setStatus(false);
            response.setMessage(Constants.FAILURE);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping("update")
    public ResponseEntity<BaseResponse> updateFlight(@Valid @RequestBody FlightDto flightDto) {
        BaseResponse response = new BaseResponse();
        try {
            response = flightService.updateFlight(flightDto);
        } catch (Exception ex) {
            response.setStatus(false);
            response.setMessage(Constants.FAILURE);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @DeleteMapping("delete")
    public ResponseEntity<BaseResponse> deleteFlight(@RequestParam("id") Long id) {
        BaseResponse response = new BaseResponse();
        try {
            response = flightService.deleteFlight(id);
        } catch (Exception ex) {
            response.setStatus(false);
            response.setMessage(Constants.FAILURE);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    private FlightFetchRequest createFlightFetchRequest(LocalTime startTime, LocalTime endTime, Boolean active){
        FlightFetchRequest flightFetchRequest = new FlightFetchRequest();
        flightFetchRequest.setStartTime(startTime);
        flightFetchRequest.setEndTime(endTime);
        flightFetchRequest.setActive(active);
        return flightFetchRequest;
    }

}
