package com.example.flight_ticket_booking.dto.flight;

import java.time.LocalTime;

public class FlightFetchRequest {

    private LocalTime startTime;

    private LocalTime endTime;
    private Boolean isActive;

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("FlightFetchRequest{");
        sb.append("startTime=").append(startTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", isActive=").append(isActive);
        sb.append('}');
        return sb.toString();
    }
}
