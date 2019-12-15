package com.eventmanagment.event.model;


import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
public class Venue {

    public interface Type {
        String MARRIAGE = "MARRIAGE",
                FAMILY_EVENT = "FAMILY_EVENT";
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String type;
    public BigDecimal maxAmount;
    public BigDecimal price;
    public String address;
}
