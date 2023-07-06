package com.example.flight_ticket_booking.converter.booking;

import com.example.flight_ticket_booking.converter.DtoToEntityConverter;
import com.example.flight_ticket_booking.dto.booking.BookingDto;
import com.example.flight_ticket_booking.entity.booking.Booking;
import com.example.flight_ticket_booking.entity.flight.Flight;
import com.example.flight_ticket_booking.entity.user.User;

public class BookingDtoToBookingConverter implements DtoToEntityConverter<BookingDto, Booking> {

    @Override
    public Booking convert(BookingDto bookingDto) {
        Booking booking = new Booking();
        booking.setId(bookingDto.getId());
        booking.setFlight(new Flight(bookingDto.getId()));
        booking.setBookingTime(bookingDto.getBookingTime());
        booking.setUser(new User(bookingDto.getUser()));
        return null;
    }
}
