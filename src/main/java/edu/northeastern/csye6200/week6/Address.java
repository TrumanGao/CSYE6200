package edu.northeastern.csye6200.week6;

public class Address {
	private String streetNo;
	private String streetName;
	private int zipCode;
	private String city;
	private String country;

	public Address(String streetNo, String streetName, int zipCode, String city, String country) {
		this.streetNo = streetNo;
		this.streetName = streetName;
		this.zipCode = zipCode;
		this.city = city;
		this.country = country;
	}

	public String getStreetNo() {
		return streetNo;
	}

	public void setStreetNo(String streetNo) {
		this.streetNo = streetNo;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
}
