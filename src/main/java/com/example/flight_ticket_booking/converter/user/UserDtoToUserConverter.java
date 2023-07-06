package com.example.flight_ticket_booking.converter.user;

import com.example.flight_ticket_booking.converter.DtoToEntityConverter;
import com.example.flight_ticket_booking.dto.user.UserDto;
import com.example.flight_ticket_booking.entity.user.User;

public class UserDtoToUserConverter implements DtoToEntityConverter<UserDto,User> {
    @Override
    public User convert(UserDto userDto) {
        User user = new User();
        user.setActive(userDto.isActive());
        user.setAddress(userDto.getAddress());
        user.setCity(userDto.getCity());
        user.setEmail(userDto.getEmail());
        user.setId(userDto.getId());
        user.setMobile(userDto.getMobile());
        user.setName(userDto.getName());
        user.setPassword(userDto.getPassword());
        user.setRole(userDto.getRole());
        return user;
    }
}
