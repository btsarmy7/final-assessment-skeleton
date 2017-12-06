package com.cooksys.component;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.stereotype.Component;

import com.cooksys.pojo.*;


@Component
public class FlightGenerator {

	public ArrayList<Flight> generateNewFlights() {

		ArrayList<Flight> result = new ArrayList<>();

		for (int i = 0; i < 5; i++) {

			int departureCityIdx = ThreadLocalRandom.current().nextInt(0, Cities.values().length - 1);

			int landCityIdx = ThreadLocalRandom.current().nextInt(0, Cities.values().length - 1);

			while (landCityIdx == departureCityIdx)
				landCityIdx = ThreadLocalRandom.current().nextInt(0, Cities.values().length - 1);

			String origin = Cities.values()[departureCityIdx].getName();
			String destination = Cities.values()[landCityIdx].getName();
			int flightTime = ThreadLocalRandom.current().nextInt(1, 5);
			int offset = ThreadLocalRandom.current().nextInt(0, 10);

			Flight f = new Flight(origin, destination, flightTime, offset);

			result.add(f);
		}
		return result;
	}

	//Get combination of flights from origin to destination 
	public ArrayList<ArrayList<Flight>> generateNewTrips(String originCity, String destinationCity,  ArrayList<Flight> flightList) {

		if(originCity == null || destinationCity == null)
			return null;

		ArrayList<ArrayList<Flight>> result = new ArrayList<>(); 

		for( int i = 0; i < flightList.size(); i++ ) {

			Flight flight1 = flightList.get(i);

			if(flight1.getOrigin().equals(originCity)) {

				if(flight1.getDestination().equals(destinationCity)) {
					ArrayList<Flight> trip = new ArrayList<>();
					trip.add(flight1);
					result.add(trip);
				} else {
					for( int j = 0; j < flightList.size(); j++ ) {
						if( j != i ) {
							Flight flight2 = flightList.get(j);

							if(flight2.getOffset() > flight1.getOffset()
									&& flight2.getOrigin().equals(flight1.getDestination())) {
								if(flight2.getDestination().equals(destinationCity)) {
									ArrayList<Flight> trip = new ArrayList<>();
									trip.add(flight1);
									trip.add(flight2);
									result.add(trip);
								} else {
									for( int k = 0; k < flightList.size(); k++ ) {
										if( k != i & k != j ) {
											Flight flight3 = flightList.get(k);
											if(flight3.getOffset() > flight2.getOffset()
													&& flight3.getOrigin().equals(flight2.getDestination())
													&& !flight2.getOrigin().equals(flight1.getOrigin())) {
												if(flight3.getDestination().equals(destinationCity)) {
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
