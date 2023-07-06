package com.example.flight_ticket_booking.entity.booking;


import com.example.flight_ticket_booking.entity.BaseEntity;
import com.example.flight_ticket_booking.entity.flight.Flight;
import com.example.flight_ticket_booking.entity.user.User;
import jakarta.persistence.*;

@Entity
public class Booking extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(referencedColumnName = "id")
    @ManyToOne
    private Flight flight;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private User user;

    private Long bookingTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
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
        final StringBuilder sb = new StringBuilder("Booking{");
        sb.append("id=").append(id);
        sb.append(", flight=").append(flight);
        sb.append(", user=").append(user);
        sb.append(", bookingTime=").append(bookingTime);
        sb.append('}');
        return sb.toString();
    }
}
