package com.example.flight_ticket_booking.repository.booking;

import com.example.flight_ticket_booking.entity.booking.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking,Long> {

    @Query("Select bk from Booking bk where bk.user.id = :cid")
    List<Booking> getAllBooking(Long cid);

    @Query("select count(b) from Booking b where b.user.id = :id and b.flight.id = :flightId")
    Long countAllUserByFlight(Long id,Long flightId);
}
