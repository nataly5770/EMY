package com.eventmanagment.event.repositories;


import com.eventmanagment.event.model.Venue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VenueRepository extends JpaRepository<Venue, Long> {
    /*Venue findAllById(Long Id);*/


}
