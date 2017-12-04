package com.cooksys.dto;

import java.util.ArrayList;
import java.util.List;

public class TripDto {

	private String username;
	
	private List<String> origins = new ArrayList<>();
	
	private List<String> destinations = new ArrayList<>();

	private List<Double> flightTimes = new ArrayList<>();

	private List<Double> layoverTimes = new ArrayList<>();
	

	public TripDto() {
		
	}

	public List<String> getOrigins() {
		return origins;
	}

	public void setOrigins(List<String> origins) {
		this.origins = origins;
	}

	public List<String> getDestinations() {
		return destinations;
	}

	public void setDestinations(List<String> destinations) {
		this.destinations = destinations;
	}

	public List<Double> getFlightTimes() {
		return flightTimes;
	}

	public void setFlightTimes(List<Double> flightTimes) {
		this.flightTimes = flightTimes;
	}

	public List<Double> getLayoverTimes() {
		return layoverTimes;
	}

	public void setLayoverTimes(List<Double> layoverTimes) {
		this.layoverTimes = layoverTimes;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
}
