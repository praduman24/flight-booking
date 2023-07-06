package com.example.flight_ticket_booking.converter.user;

import com.example.flight_ticket_booking.converter.EntityToDtoConverter;
import com.example.flight_ticket_booking.dto.user.UserDto;
import com.example.flight_ticket_booking.entity.user.User;

public class UserToUserDtoConverter implements EntityToDtoConverter<User,UserDto> {
    @Override
    public UserDto convert(User user) {
        UserDto userDto = new UserDto();
        userDto.setActive(user.isActive());
        userDto.setAddress(user.getAddress());
        userDto.setCity(user.getCity());
        userDto.setEmail(user.getEmail());
        userDto.setMobile(user.getMobile());
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setPassword(user.getPassword());
        userDto.setRole(user.getRole());
        return userDto;
    }
}
