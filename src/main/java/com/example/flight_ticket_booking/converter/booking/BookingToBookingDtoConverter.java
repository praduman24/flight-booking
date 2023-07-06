package com.example.flight_ticket_booking.converter.booking;

import com.example.flight_ticket_booking.converter.EntityToDtoConverter;
import com.example.flight_ticket_booking.dto.booking.BookingDto;
import com.example.flight_ticket_booking.entity.booking.Booking;

public class BookingToBookingDtoConverter implements EntityToDtoConverter<Booking,BookingDto> {

    @Override
    public BookingDto convert(Booking obj) {
        return null;
    }
}
