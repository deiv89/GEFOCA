package it.synclab.stage.Entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@SuppressWarnings("serial")
@Entity
public class Region implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)	
	private Long id;
	@Column(length=30)
	private String nameRegion;
	@ManyToOne(cascade=CascadeType.ALL)
	private Country Country;
	@OneToMany(mappedBy="region",cascade=CascadeType.ALL)
	private List<Province> provinces=new ArrayList<>();
	public Region() {
	}
	public Region(String nameRegion) {
		this.nameRegion = nameRegion;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNameRegion() {
		return nameRegion;
	}
	public void setNameRegion(String nameRegion) {
		this.nameRegion = nameRegion;
	}
	public Country getCountry() {
		return Country;
	}
	public void setCountry(Country country) {
		Country = country;
	}
	public List<Province> getProvinces() {
		return provinces;
	}
	public void setProvinces(List<Province> provinces) {
		this.provinces = provinces;
	}
	

}
