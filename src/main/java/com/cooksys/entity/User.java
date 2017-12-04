
package com.cooksys.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.cooksys.entity.embeddable.Credentials;

@Entity
@Table(name = "Usertable")
public class User {

	@Id
	@GeneratedValue
	private Integer id;
	
	@OneToMany(mappedBy = "user")
	private List<Trip> trips = new ArrayList<>();

	@Column(nullable = false)
	@Embedded
	private Credentials credentials;
	

	public User() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Credentials getCredentials() {
		return credentials;
	}

	public void setCredentials(Credentials credentials) {
		this.credentials = credentials;
	}

	public List<Trip> getTrips() {
		return trips;
	}

	public void setTrips(ArrayList<Trip> trips) {
		this.trips = trips;
	}
}
