package com.example.flight_ticket_booking.converter.flight;

import com.example.flight_ticket_booking.converter.DtoToEntityConverter;
import com.example.flight_ticket_booking.dto.flight.FlightDto;
import com.example.flight_ticket_booking.entity.flight.Flight;

public class FlightDtoToFlightConverter implements DtoToEntityConverter<FlightDto, Flight> {

    @Override
    public Flight convert(FlightDto flightDto) {
        Flight flight = new Flight();
        flight.setId(flightDto.getId());
        flight.setName(flightDto.getName());
        flight.setActive(flightDto.getActive());
        flight.setFlightTime(flightDto.getFlightTime());
        return flight;
    }
}
