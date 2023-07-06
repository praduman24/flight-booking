package com.example.flight_ticket_booking;

import com.example.flight_ticket_booking.dto.user.UserDto;
import com.example.flight_ticket_booking.repository.user.UserRepository;
import com.example.flight_ticket_booking.service.user.UserService;
import com.example.flight_ticket_booking.utils.UserRoles;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FlightTicketBookingApplication {

    public static void main(String[] args) {
        SpringApplication.run(FlightTicketBookingApplication.class, args);
    }

    @Bean
    public CommandLineRunner demoData(UserService service) {
        return args -> {
            service.saveUser(createDemoAdmin());
        };
    }

    private UserDto createDemoAdmin(){
        UserDto user = new UserDto();
        user.setEmail("admin@gmail.com");
        user.setPassword("123456");
        user.setActive(true);
        user.setName("admin");
        user.setRole(UserRoles.ADMIN);
        user.setMobile("1234567890");
        user.setCity("Palo Alto");
        user.setAddress("Palo Alto");
        return user;
    }
}
