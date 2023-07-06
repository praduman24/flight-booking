package com.example.flight_ticket_booking.repository.token;

import com.example.flight_ticket_booking.entity.tokens.Tokens;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepository extends JpaRepository<Tokens,Long> {

    Tokens findByToken(String token);
}
