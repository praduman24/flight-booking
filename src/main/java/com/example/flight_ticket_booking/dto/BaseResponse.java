package com.example.flight_ticket_booking.dto;


public class BaseResponse {

    private Boolean status;
    private String message;

    public BaseResponse(Boolean status, String message) {
        this.status = status;
        this.message = message;
    }

    public BaseResponse() {
    }

    //    Getters And Setters
    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    // toString
    @Override
    public String toString() {
        String sb = "BaseResponse{" + "status=" + status +
                ", message='" + message + '\'' +
                '}';
        return sb;
    }

}
