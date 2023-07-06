package com.example.flight_ticket_booking.converter;

public interface EntityToDtoConverter<T1, T2> {

    /**
     * This method is used to convert.
     * @param  obj obj.
     * @return T2.
     */
    T2 convert(T1 obj);
}
