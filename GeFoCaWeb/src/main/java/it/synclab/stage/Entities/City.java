package it.synclab.stage.Entities;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class City implements Serializable{
	   @Id
	   @GeneratedValue(strategy=GenerationType.AUTO)
      private Long id;
	   @Column(length=5)
      private int zipCode;
	   @Column(name="CITY_NAME",length=30)
      private String nameCity;
	   @Column(length=2)
      private String abbreviation;
	   @ManyToOne(cascade=CascadeType.ALL)
      private Province province;	   
      //private List<Address> addresses= new ArrayList<>();
	public City() {
		super();
	}
	public City(int zipCode, String nameCity, String codeCity) {
		super();
		this.zipCode = zipCode;
		this.nameCity = nameCity;
		abbreviation = codeCity;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long idCity) {
		this.id = idCity;
	}
	public int getZipCode() {
		return zipCode;
	}
	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}
	public String getNameCity() {
		return nameCity;
	}
	public void setNameCity(String nameCity) {
		this.nameCity = nameCity;
	}
	public String getAbbreviation() {
		return abbreviation;
	}
	public void setAbbreviation(String codeCity) {
		abbreviation = codeCity;
	}	
	public Province getProvince() {
		return province;
	}
	public void setProvince(Province province) {
		this.province = province;
	}
}
