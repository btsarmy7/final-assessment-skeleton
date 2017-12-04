package com.cooksys.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Trip {

	@Id
	@GeneratedValue
	private Integer id;
	
	@ElementCollection
	private List<String> origins = new ArrayList<>();
	
	@ElementCollection
	private List<String> destinations = new ArrayList<>();

	@ElementCollection
	private List<Double> flightTimes = new ArrayList<>();

	@ElementCollection
	private List<Double> layoverTimes = new ArrayList<>();
	
	@ManyToOne
	private User user;

	public Trip() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<String> getOrigins() {
		return origins;
	}

	public void setOrigins(ArrayList<String> origins) {
		this.origins = origins;
	}


	public List<String> getDestinations() {
		return destinations;
	}

	public void setDestinations(ArrayList<String> destinations) {
		this.destinations = destinations;
	}

	public List<Double> getFlightTimes() {
		return flightTimes;
	}

	public void setFlightTimes(ArrayList<Double> flightTimes) {
		this.flightTimes = flightTimes;
	}

	public List<Double> getLayoverTimes() {
		return layoverTimes;
	}

	public void setLayoverTimes(ArrayList<Double> layoverTimes) {
		this.layoverTimes = layoverTimes;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
