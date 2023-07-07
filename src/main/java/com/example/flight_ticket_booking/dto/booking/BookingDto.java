package com.example.flight_ticket_booking.dto.booking;

import jakarta.validation.constraints.NotNull;

public class BookingDto {

    private Long id;
    @NotNull(message = "flight cant be null")
    private Long flight;
    @NotNull(message = "user cant be null")
    private Long user;
    @NotNull(message = "booking Timing cant be null")
    private Long bookingTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFlight() {
        return flight;
    }

    public void setFlight(Long flight) {
        this.flight = flight;
    }

    public Long getUser() {
        return user;
    }

    public void setUser(Long user) {
        this.user = user;
    }

    public Long getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(Long bookingTime) {
        this.bookingTime = bookingTime;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("BookingDto{");
        sb.append("id=").append(id);
        sb.append(", flight=").append(flight);
        sb.append(", user=").append(user);
        sb.append(", bookingTime=").append(bookingTime);
        sb.append('}');
        return sb.toString();
    }
}
