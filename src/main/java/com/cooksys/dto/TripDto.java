package com.cooksys.dto;

import java.util.ArrayList;
import java.util.List;

public class TripDto {

	private List<String> origins = new ArrayList<>();
	
	private List<String> destinations = new ArrayList<>();

	private List<Long> flightTimes = new ArrayList<>();

	private List<Long> layoverTimes = new ArrayList<>();
	
	private String username;

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

	public List<Long> getFlightTimes() {
		return flightTimes;
	}

	public void setFlightTimes(List<Long> flightTimes) {
		this.flightTimes = flightTimes;
	}

	public List<Long> getLayoverTimes() {
		return layoverTimes;
	}

	public void setLayoverTimes(List<Long> layoverTimes) {
		this.layoverTimes = layoverTimes;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
}
