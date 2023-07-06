package com.example.flight_ticket_booking.service.flight;

import com.example.flight_ticket_booking.dto.BaseResponse;
import com.example.flight_ticket_booking.dto.flight.FlightDto;
import com.example.flight_ticket_booking.dto.flight.FlightFetchRequest;

import java.util.List;

public interface FlightService {

    BaseResponse saveFlight(FlightDto flightDto);

    BaseResponse deleteFlight(Long id);

    BaseResponse updateFlight(FlightDto flightDto);

    List<FlightDto> getAllFlight(FlightFetchRequest flightFetchRequest);


}

