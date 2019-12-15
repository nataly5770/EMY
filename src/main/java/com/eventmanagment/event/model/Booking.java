package com.eventmanagment.event.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;


@Entity
@Data
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Venue venue;
    @OneToOne
    private User user;
    private LocalDate date;
    private BigDecimal guestAmount;
}
