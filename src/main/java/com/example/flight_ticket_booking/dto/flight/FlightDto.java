package com.example.flight_ticket_booking.dto.flight;

import com.example.flight_ticket_booking.dto.BaseDto;

import java.time.LocalTime;

public class FlightDto extends BaseDto {

    private Long id;
    private String name;
    private Boolean isActive;
    private LocalTime flightTime; // "02:00:00"

    public LocalTime getFlightTime() {
        return flightTime;
    }

    public void setFlightTime(LocalTime flightTime) {
        this.flightTime = flightTime;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("FlightDto{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", isActive=").append(isActive);
        sb.append(", startTime=").append(flightTime);
        sb.append('}');
        return sb.toString();
    }
}
