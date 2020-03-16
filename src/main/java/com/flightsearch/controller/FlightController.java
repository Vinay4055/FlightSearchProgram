package com.flightsearch.controller;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.flightsearch.model.Flight;
import com.flightsearch.model.FlightSearchParameters;
import com.flightsearch.repository.FlightRepository;
import com.flightsearch.service.FlightService;

@Controller
@RequestMapping("/flight")
public class FlightController {
	@Autowired
	private FlightSearchParameters flightSearchParameter;
	@Autowired
	private FlightRepository flightRepository;
	@Autowired
	private FlightService flightService;
	@Autowired 
	private Flight flight;

	@GetMapping("/")
	public String home(Model map) {
		map.addAttribute("flightSearchParameter", flightSearchParameter);
		Set<String> arrivalLocation = new TreeSet<>();
		Set<String> departureLocation = new TreeSet<>();
		flightRepository.findAll().stream().forEach(flight -> {
			departureLocation.add(flight.getDepartureLocation());
			arrivalLocation.add(flight.getArrivalLocation());
		});
		map.addAttribute("arrivalLocation", arrivalLocation);
		map.addAttribute("departureLocation", departureLocation);
		return "index";

	}
	@PostMapping("/search")
	public String searchFlights(@ModelAttribute FlightSearchParameters flightSearchParameter,Model map) {
		List<Flight> searchedFlights=flight.convertFlightEntityToModel(flightService.findFlights(flightSearchParameter, flightRepository));
		map.addAttribute("searchedFlights",searchedFlights);
		return "result";
	}

}
