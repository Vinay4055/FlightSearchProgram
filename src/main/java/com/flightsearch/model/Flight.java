package com.flightsearch.model;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class Flight {

	private String flightNumber;
	private LocalTime flightLocalTime;
	private Double flightDuration;
	private Double fare;
	private String flightClass;

	public List<Flight> convertFlightEntityToModel(List<com.flightsearch.entity.Flight> source) {
		List<Flight> convertedList = new ArrayList<>();
		ModelMapper modelMapper = new ModelMapper();
		for (int i = 0; i < source.size(); i++) {
			com.flightsearch.entity.Flight flightEntity = source.get(i);
			Flight flightModel = modelMapper.map(flightEntity, com.flightsearch.model.Flight.class);
			convertedList.add(flightModel);

		}
		return convertedList;
	}
}
