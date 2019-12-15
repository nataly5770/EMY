package com.eventmanagment.event.repositories;


import com.eventmanagment.event.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Id;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Id> {
    /*Booking findBookingByData(String data);*/
}
