package com.flightsearch.entity;

import java.time.LocalTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "flight")

public class Flight {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "native")
	@Column(name = "id", unique = true, nullable = false)
	@Getter
	@Setter
	private long id;

	@Column(name = "number", nullable = false)
	@Getter
	@Setter
	private String flightNumber;

	@Column(name = "departure_location", nullable = false)
	@Getter
	@Setter
	private String departureLocation;

	@Column(name = "arrival_location", nullable = false)
	@Getter
	@Setter
	private String arrivalLocation;

	@Column(name = "valid_till", nullable = false)
	@Getter
	@Setter
	@Temporal(TemporalType.DATE)
	private Date validTill;

	@Column(name = "time", nullable = false)
	@Getter
	@Setter
	private String flightTime;

	@Column(name = "duration", nullable = false)
	@Getter
	@Setter
	private Double flightDuration;

	@Column(name = "fare", nullable = false)
	@Getter
	@Setter
	private Double fare;

	@Column(name = "seat_availability", nullable = false)
	@Getter
	@Setter
	private String seatAvailable;

	@Column(name = "class", nullable = false)
	@Getter
	@Setter
	private String flightClass;
	@Transient
	private LocalTime flightLocalTime;
	
	public LocalTime getFlightLocalTime() {
		String flightTime = this.flightTime;
		String hours = "" + flightTime.charAt(0) + flightTime.charAt(1);
		String minutes = "" + flightTime.charAt(2) + flightTime.charAt(3);
		return LocalTime.of(Integer.parseInt(hours), Integer.parseInt(minutes));

	}

	public void setFlightLocalTime(LocalTime flightLocalTime) {
		this.flightLocalTime = flightLocalTime;
	}
}
