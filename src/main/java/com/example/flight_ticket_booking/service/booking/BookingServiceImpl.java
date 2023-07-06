package com.example.flight_ticket_booking.service.booking;

import com.example.flight_ticket_booking.converter.DtoToEntityConverter;
import com.example.flight_ticket_booking.converter.EntityToDtoConverter;
import com.example.flight_ticket_booking.converter.booking.BookingDtoToBookingConverter;
import com.example.flight_ticket_booking.converter.booking.BookingToBookingDtoConverter;
import com.example.flight_ticket_booking.dto.BaseResponse;
import com.example.flight_ticket_booking.dto.booking.BookingDto;
import com.example.flight_ticket_booking.entity.booking.Booking;
import com.example.flight_ticket_booking.repository.booking.BookingRepository;
import com.example.flight_ticket_booking.service.authentication.AuthenticationService;
import com.example.flight_ticket_booking.utils.Constants;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class BookingServiceImpl implements BookingService{

    private final DtoToEntityConverter<BookingDto, Booking> dtoToEntityConverter = new BookingDtoToBookingConverter();

    private final EntityToDtoConverter<Booking,BookingDto> entityToDtoConverter = new BookingToBookingDtoConverter();

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private AuthenticationService authenticationService;

    @Override
    public BaseResponse createBooking(BookingDto bookingDto) {
        BaseResponse response = new BaseResponse();
        bookingRepository.save(dtoToEntityConverter.convert(bookingDto));
        response.setStatus(true);
        response.setMessage(Constants.SUCCESS);
        return response;
    }

    @Override
    public List<BookingDto> listOfAllTheBooking() {
        Long cid = authenticationService.getLoginedClient();
        return bookingRepository.getAllBooking(cid).stream().map(entityToDtoConverter::convert).collect(Collectors.toList());
    }
}
