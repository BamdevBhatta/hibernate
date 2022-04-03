package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;




@Entity
@Table(name="Address")
public class Address{
	@Id
	@GeneratedValue
	private int id;
	private String country;
	private String city;
	private String state;

	public Address() {

	}

	public Address(String country, String city, String state) {
		this.country = country;
		this.city = city;
		this.state = state;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	
	public void setCity(String city) {
		this.city = city;
	}

	
	public String getState() {
		return state;
	}

	
	public void setState(String state) {
		this.state = state;
	}

}
