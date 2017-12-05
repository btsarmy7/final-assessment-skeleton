package com.cooksys.component;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.stereotype.Component;

import com.cooksys.pojo.Cities;
import com.cooksys.pojo.Flight;

@Component
public class FlightGenerator {

	public ArrayList<Flight> generateNewFlightList() {

		ArrayList<Flight> result = new ArrayList<>();

		for (int i = 0; i < 5; i++) {

			int originIndex = ThreadLocalRandom.current().nextInt(0, 4);

			int destinationIndex = ThreadLocalRandom.current().nextInt(0, 4);

			while (destinationIndex == originIndex)
				destinationIndex = ThreadLocalRandom.current().nextInt(0, 4);

			String origin = Cities.values()[originIndex].getName();
			String destination = Cities.values()[destinationIndex].getName();
			int flightTime = ThreadLocalRandom.current().nextInt(1, 4);
			int offset = ThreadLocalRandom.current().nextInt(0, 10);

			Flight f = new Flight(origin, destination, flightTime, offset);

			result.add(f);
		}
		return result;
	}

	public ArrayList<ArrayList<Flight>> generateNewTrips(String originCity, String destinationCity,
			ArrayList<Flight> flightList) {

		if (originCity == null || destinationCity == null)
			return null;

		ArrayList<ArrayList<Flight>> result = new ArrayList<>();

		// look through list of flights
		for (int i = 0; i < flightList.size(); i++) {

			Flight flight1 = flightList.get(i);

			if (flight1.getOrigin().equals(originCity)) { // check if flight starts from originCity

				if (flight1.getDestination().equals(destinationCity)) {  // check if flight ends in the destinationCity
					ArrayList<Flight> trip = new ArrayList<>(); // add flight to new list which will eventually contain all the possible combinations of flights
					trip.add(flight1);
					result.add(trip);
				} else {
					for (int j = 0; j < flightList.size(); j++) { // look through rest of the flights to find other combinations
						if (j != i) {
							Flight flight2 = flightList.get(j);

							if (flight2.getOffset() > flight1.getOffset() // if flight2 takes off after flight1
									&& flight2.getOrigin().equals(flight1.getDestination())) { // and flight1 ends where flight2 takes off (a possible transfer) 
								if (flight2.getDestination().equals(destinationCity)) { // if only one transfer is needed to reach destination, add to list
									ArrayList<Flight> trip = new ArrayList<>();
									trip.add(flight1);
									trip.add(flight2);
									result.add(trip);
								} else {
									for (int k = 0; k < flightList.size(); k++) { // look through remaining flights
										if (k != i & k != j) {
											Flight flight3 = flightList.get(k);
											if (flight3.getOffset() > flight2.getOffset()
													&& flight3.getOrigin().equals(flight2.getDestination()) // second transfer
													&& !flight2.getOrigin().equals(flight1.getOrigin())) {
												if (flight3.getDestination().equals(destinationCity)) {
													ArrayList<Flight> trip = new ArrayList<>();
													trip.add(flight1);
													trip.add(flight2);
													trip.add(flight3);
													result.add(trip);
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return result;

	}

}
