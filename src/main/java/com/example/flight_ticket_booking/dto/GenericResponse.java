package com.example.flight_ticket_booking.dto;

import java.util.List;

public class GenericResponse<T> extends BaseResponse {
    private List<T> dtoList;
    private T dto;

    // Getters And Setters
    public List<T> getDtoList() {
        return dtoList;
    }

    public void setDtoList(List<T> dtoList) {
        this.dtoList = dtoList;
    }

    public T getDto() {
        return dto;
    }

    public void setDto(T dto) {
        this.dto = dto;
    }

}