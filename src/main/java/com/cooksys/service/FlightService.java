package com.cooksys.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.cooksys.pojo.Flight;
import com.cooksys.component.FlightGenerator;
import com.cooksys.dto.TripDto;
import com.cooksys.entity.Trip;
import com.cooksys.entity.User;
import com.cooksys.exception.FlightBookingException;
import com.cooksys.mapper.TripMapper;
import com.cooksys.repository.TripRepository;
import com.cooksys.repository.UserRepository;

@Service
public class FlightService {

	@Autowired
	private FlightGenerator generator;

	private ArrayList<Flight> flightList = new ArrayList<>();

	private ArrayList<ArrayList<Flight>> tripList = new ArrayList<>();

	private String origin;

	private String destination;

	private TripMapper tripMapper;

	private TripRepository tripRepository;

	private UserRepository userRepository;

	public FlightService(FlightGenerator generator, UserRepository userRepository, TripRepository tripJpaRepository,
			TripMapper tripMapper) {

		this.generator = generator;
		this.tripMapper = tripMapper;
		this.userRepository = userRepository;
		this.tripRepository = tripRepository;

	}

	public ArrayList<Flight> getDailyFlightList() {
		return flightList;
	}

	// The fixedDelay parameter determines how often a new day is generated as
	// expressed in milliseconds
	@Scheduled(fixedDelay = 10000)
	private void refreshFlights() {
		flightList = generator.generateNewFlightList();
		refreshTrips();
	}

	private void refreshTrips() {
		tripList = generator.generateNewTrips(origin, destination, flightList);
	}

	// get a list of trips for each day
	public ArrayList<ArrayList<Flight>> getTripList(String origin, String destination) {

		this.origin = origin;
		this.destination = destination;
		refreshTrips();
		return tripList;
	}

	// get a list of trips a user has booked
	public List<TripDto> getBookedTrips(String username) throws FlightBookingException {

		// check if user is logged in
		if (username == null) {
			throw new FlightBookingException();
		}

		User user = userRepository.findByCredentialsUsername(username);

		if (user != null && user.getTrips() != null && !user.getTrips().isEmpty()) {
			return tripMapper.toTripDto(user.getTrips());
		} else {
			return null;
		}
	}

	public void bookTrip(Trip trip, String username) throws FlightBookingException {
		if (username == null || trip == null) {
			throw new FlightBookingException();
		}

		User user = userRepository.findByCredentialsUsername(username);
		trip.setUser(user);
		tripRepository.save(trip);
	}

}
