package com.flightsearch.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flightsearch.entity.Flight;
@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {


}
