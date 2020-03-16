package com.flightsearch.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.flightsearch.entity.Flight;
import com.flightsearch.model.FlightSearchParameters;
import com.flightsearch.repository.FlightRepository;
@Service
public interface FlightService {
public List<Flight> findFlights(FlightSearchParameters searchParameters,FlightRepository flightRepository);
}
