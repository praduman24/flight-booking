package com.example.flight_ticket_booking.dto;

import java.util.Calendar;


public class BaseDto {

    private Long createdOn = Calendar.getInstance().getTimeInMillis();
    private Long modifiedOn;
    private Long createdBy = 1l;
    private Long modifiedBy;

    private String createdByName;
    private String modifiedByName;

    //    Getters And Setters
    public Long getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Long createdOn) {
        this.createdOn = createdOn;
    }

    public Long getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(Long modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Long getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(Long modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public String getCreatedByName() {
        return createdByName;
    }

    public void setCreatedByName(String createdByName) {
        this.createdByName = createdByName;
    }

    public String getModifiedByName() {
        return modifiedByName;
    }

    public void setModifiedByName(String modifiedByName) {
        this.modifiedByName = modifiedByName;
    }

    //  toString
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("BaseDto{");
        sb.append("createdOn=").append(createdOn);
        sb.append(", modifiedOn=").append(modifiedOn);
        sb.append(", createdBy=").append(createdBy);
        sb.append(", modifiedBy=").append(modifiedBy);
        sb.append(", createdByName='").append(createdByName).append('\'');
        sb.append(", modifiedByName='").append(modifiedByName).append('\'');
        sb.append('}');
        return sb.toString();
    }

}
