package com.flightsearch.serviceimpl;

import static com.flightsearch.common.Common.returnFalse;
import static com.flightsearch.common.Common.returnTrue;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.flightsearch.entity.Flight;
import com.flightsearch.model.FlightSearchParameters;
import com.flightsearch.repository.FlightRepository;
import com.flightsearch.service.FlightService;

@Service
public class FlightServiceImpl implements FlightService {

	FlightSearchParameters searchParameters;

	@Override
	public List<Flight> findFlights(FlightSearchParameters searchParameters, FlightRepository flightRepository) {
		List<Flight> result = new ArrayList<>();

		this.searchParameters = searchParameters;

		List<Flight> flight = flightRepository.findAll();

		flight.stream().filter(this::filterRecords).forEach(a -> result.add(a));

		return sortResult(result, searchParameters.getOutputPreference());

	}

	public List<Flight> sortResult(List<Flight> result, String sortType) {
		switch (searchParameters.getOutputPreference()) {
		case "fareSort":
			result.sort((Flight flight1, Flight flight2) -> {
				if (flight1.getFare() > flight2.getFare())
					return 1;
				else
					return -1;

			}

			);
			break;
		case "fareAndFlightDurationSort":
			result.sort((Flight flight1, Flight flight2) -> {
				int comp = (int) (flight1.getFare() - flight2.getFare());

				if (comp != 0) {
					return comp;
				}
				return (int) (String.valueOf(flight1.getFlightDuration())
						.compareTo(String.valueOf(flight2.getFlightDuration())));

			});
			break;
		default:
			System.out.println("Invalid Choice");
			break;

		}
		return result;
	}

	public boolean filterRecords(Object t) {
		com.flightsearch.entity.Flight flight = (com.flightsearch.entity.Flight) t;

		if (checkArrivalCode(searchParameters.getArrivalLocation(), flight.getArrivalLocation())
				&& checkDepartureCode(searchParameters.getDepartureLocation(), flight.getDepartureLocation())) {

			if (checkFlightAccordingToDateOfBoarding(searchParameters.getFlightDate(), flight.getValidTill())
					|| checkFlightForTheCurrentDay(searchParameters.getFlightDate())) {
				if (checkFlightForTheCurrentDay(searchParameters.getFlightDate())
						&& checkFlightAccordingToCurrentLocalTime(flight.getFlightLocalTime())) {
					if (checkSeatAvailability(flight.getSeatAvailable())
							&& checkAvailableFlightClass(searchParameters.getFlightClass(), flight.getFlightClass())) {
						return returnTrue();
					} else {
						return returnFalse();
					}
				} else if (checkFlightAccordingToDateOfBoarding(searchParameters.getFlightDate(),
						flight.getValidTill())) {
					if (checkSeatAvailability(flight.getSeatAvailable())
							&& checkAvailableFlightClass(searchParameters.getFlightClass(), flight.getFlightClass())) {
						return returnTrue();
					} else {
						return returnFalse();
					}

				} else {
					return returnFalse();
				}
			} else {
				return returnFalse();
			}

		} else {
			return returnFalse();
		}

	}

	public boolean checkArrivalCode(String boardingCodeSearchParameter, String boardingCode) {

		return (boardingCodeSearchParameter.equalsIgnoreCase(boardingCode)) ? returnTrue() : returnFalse();
	}

	public boolean checkDepartureCode(String destinationCodeSearchParameter, String destinationCode) {

		return (destinationCodeSearchParameter.equalsIgnoreCase(destinationCode)) ? returnTrue() : returnFalse();
	}

	public boolean checkFlightAccordingToDateOfBoarding(Date dateSearchParameter, Date date) {

		return (dateSearchParameter.before(date)) ? returnTrue() : returnFalse();

	}

	public boolean checkFlightForTheCurrentDay(Date dateSearchParameter) {
		LocalDate todayDate = LocalDate.now();
		return (dateSearchParameter.equals(todayDate)) ? returnTrue() : returnFalse();

	}

	public boolean checkFlightAccordingToCurrentLocalTime(LocalTime flightTime) {
		LocalTime currentTime = LocalTime.now();
		return (currentTime.isBefore(flightTime)) ? returnTrue() : returnFalse();
	}

	public boolean checkAvailableFlightClass(String flightClassSearchParameter, String flightClass) {
		return (flightClassSearchParameter.equalsIgnoreCase(flightClass) || flightClass.equalsIgnoreCase("EB"))
				? returnTrue()
				: returnFalse();
	}

	public boolean checkSeatAvailability(String seatAvailability) {
		return seatAvailability.equalsIgnoreCase("Y") ? returnTrue() : returnFalse();
	}

}
