package com.example.flight_ticket_booking.converter.flight;

import com.example.flight_ticket_booking.converter.EntityToDtoConverter;
import com.example.flight_ticket_booking.dto.flight.FlightDto;
import com.example.flight_ticket_booking.entity.flight.Flight;

public class FlightToFlightDtoConverter implements EntityToDtoConverter<Flight, FlightDto> {
    @Override
    public FlightDto convert(Flight flight) {
        FlightDto flightDto = new FlightDto();
        flightDto.setId(flight.getId());
        flightDto.setName(flight.getName());
        flightDto.setActive(flight.getActive());
        flightDto.setFlightTime(flight.getFlightTime());
        return flightDto;
    }
}
