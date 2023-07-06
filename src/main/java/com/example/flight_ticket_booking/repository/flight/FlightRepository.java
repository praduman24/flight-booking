package com.example.flight_ticket_booking.repository.flight;

import com.example.flight_ticket_booking.entity.flight.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

public interface FlightRepository extends JpaRepository<Flight,Long> {

    Optional<Flight> findByNameAndIsActive(String name,Boolean active);

    List<Flight> findAllByFlightTimeBetweenAndIsActiveTrue(LocalTime startTime, LocalTime endTime);

    List<Flight> findAllByIsActiveFalse();
    List<Flight> findAllByIsActiveTrue();

}

