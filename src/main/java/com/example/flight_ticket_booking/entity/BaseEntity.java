package com.example.flight_ticket_booking.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import java.util.Calendar;


@MappedSuperclass
public class BaseEntity{

    @Column(name = "created_on", nullable = false)
    private Long createdOn = Calendar.getInstance().getTimeInMillis();

    @Column(name = "modified_on")
    private Long modifiedOn;

    @Column(name = "created_by")
    private Long createdBy = 0l;

    @Column(name = "modified_by")
    private Long modifiedBy;

    // Getters And Setters
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


    //    toString
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("BaseEntity{");
        sb.append("createdOn=").append(createdOn);
        sb.append(", modifiedOn=").append(modifiedOn);
        sb.append(", createdBy=").append(createdBy);
        sb.append(", modifiedBy=").append(modifiedBy);
        sb.append('}');
        return sb.toString();
    }

}
