
package com.cooksys.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.cooksys.entity.embeddable.CredentialsEmbeddable;

@Entity
public class UserEntity {

	@Id
	@GeneratedValue
	private Integer id;

	@Column(nullable = false)
	@Embedded
	private CredentialsEmbeddable credentials;
	
	@OneToMany(mappedBy = "user")
	private List<Trip> trips = new ArrayList<>();

	public UserEntity() { }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public CredentialsEmbeddable getCredentials() {
		return credentials;
	}

	public void setCredentials(CredentialsEmbeddable credentials) {
		this.credentials = credentials;
	}

	public List<Trip> getTrips() {
		return trips;
	}

	public void setTrips(ArrayList<Trip> trips) {
		this.trips = trips;
	}
}
