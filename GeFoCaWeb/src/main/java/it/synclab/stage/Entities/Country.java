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
import javax.persistence.OneToMany;


@Entity
public class Country implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(length=30)
	private String nameCountry;
	@Column(name="CODE",length=3)
	private int codeCountry;
	@Column(name="ABBREVIATION",length=5)
	private String abbreviationCountry;
	@OneToMany(mappedBy="Country")
	private List<Region> regions =new ArrayList<Region>();
	public Country() {
	}
	public Country(String nameCountry, int codeCountry, String abbreviationCountry) {
		this.nameCountry = nameCountry;
		this.codeCountry = codeCountry;
		this.abbreviationCountry = abbreviationCountry;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNameCountry() {
		return nameCountry;
	}
	public void setNameCountry(String nameCountry) {
		this.nameCountry = nameCountry;
	}
	public int getCodeCountry() {
		return codeCountry;
	}
	public void setCodeCountry(int codeCountry) {
		this.codeCountry = codeCountry;
	}
	public String getAbbreviationCountry() {
		return abbreviationCountry;
	}
	public void setAbbreviationCountry(String abbreviationCountry) {
		this.abbreviationCountry = abbreviationCountry;
	}
	public List<Region> getRegions() {
		return regions;
	}
	public void setRegions(List<Region> regions) {
		this.regions = regions;
	}

}
