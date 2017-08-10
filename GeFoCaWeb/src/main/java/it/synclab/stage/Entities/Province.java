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
public class Province implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(name="NAME_PROVINCE",length=30)
	private String nameProvince;
	 @Column(length=2)
     private String abbreviation;
	@ManyToOne(cascade=CascadeType.ALL)
	private Region region;
	@OneToMany(mappedBy="province",cascade=CascadeType.ALL)
	private List<City>cities=new ArrayList<>();
	public Province() {
		super();
	}	
	public Province(String nameProvince, String abbreviation) {
		this.nameProvince = nameProvince;
		this.abbreviation = abbreviation;
	}
	public String getAbbreviation() {
		return abbreviation;
	}
	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long idProvince) {
		this.id = idProvince;
	}
	public String getNameProvince() {
		return nameProvince;
	}
	public void setNameProvince(String nameProvince) {
		this.nameProvince = nameProvince;
	}
	public Region getRegion() {
		return region;
	}
	public void setRegion(Region region) {
		this.region = region;
	}
	public List<City> getCities() {
		return cities;
	}
	public void setCities(List<City> cities) {
		this.cities = cities;
	}

}
