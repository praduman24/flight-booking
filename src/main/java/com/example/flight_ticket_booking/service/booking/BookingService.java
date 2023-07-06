package com.example.flight_ticket_booking.service.booking;

import com.example.flight_ticket_booking.dto.BaseResponse;
import com.example.flight_ticket_booking.dto.booking.BookingDto;

import java.util.List;

public interface BookingService {

      BaseResponse createBooking(BookingDto bookingDto);

      List<BookingDto> listOfAllTheBooking();

}
