package it.synclab.stage.Entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Embeddable
public class Address implements Serializable {	
	@ManyToOne(cascade=CascadeType.ALL)	
	private City city;
	@Column(length=50)
	private String street;
	@Column(length=50)
	private String streetName;
	private String civicCode;
	public Address() {
		super();
	}
	public Address(String street, String treetName, String civicCode) {
		super();
		this.street = street;
		streetName = treetName;
		this.civicCode = civicCode;
	}	
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String treetName) {
		streetName = treetName;
	}
	public String getCivicCode() {
		return civicCode;
	}
	public void setCivicCode(String civicCode) {
		this.civicCode = civicCode;
	}
	@Override
	public String toString() {
		String address=street+" "+streetName+", "+civicCode+"-"+city.getZipCode()+"  "+city.getNameCity()+"("+city.getProvince().getAbbreviation().toUpperCase()+")";
		return  address;
	}
}
