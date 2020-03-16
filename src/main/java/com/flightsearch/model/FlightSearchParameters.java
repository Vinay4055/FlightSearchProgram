package com.flightsearch.model;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
@Component
public class FlightSearchParameters implements Serializable {

	private static final long serialVersionUID = -4353403758520419153L;
	@Getter
	@Setter
	@NotNull
	private String departureLocation;
	@Getter
	@Setter
	@NotNull
	private String arrivalLocation;

	
	
	@Getter
	@Setter
	@NotNull
	private String flightClass;

	@Getter
	@Setter
	@NotNull
	private String outputPreference;
	@Getter
	@Setter
	private String date;

	private Date flightDate;


	public Date getFlightDate() {
		
		try {
			
			if(this.date!=null)
			return new SimpleDateFormat("yyyy-MM-dd").parse(this.date);
			else
				return null;
			
		} 
		catch (ParseException e) {
			
			e.printStackTrace();
		}
		return null;
		
	}


	public void setFlightDate(Date flightDate) {
		this.flightDate = flightDate;
	}
	
	

}
