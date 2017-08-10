package it.synclab.stage.Entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;

@SuppressWarnings("serial")
@Embeddable
public class Person implements Serializable {
	
	private String firtName;
	private String surName;
	private Date birthdate;	
    private String fiscalCode;
    private String email;
    private int cellPhone;
    private int homePhone;
	public Person() {
		super();
	}
	public Person(String firtName, String surName, Date birthdate, String fiscalCode, String email, int cellPhone,
			int homePhone) {
		this.firtName = firtName;
		this.surName = surName;
		this.birthdate = birthdate;
		this.fiscalCode = fiscalCode;
		this.email = email;
		this.cellPhone = cellPhone;
		this.homePhone = homePhone;
	}
	public String getFirtName() {
		return firtName;
	}
	public void setFirtName(String firtName) {
		this.firtName = firtName;
	}
	public String getSurName() {
		return surName;
	}
	public void setSurName(String surName) {
		this.surName = surName;
	}
	public Date getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	public String getFiscalCode() {
		return fiscalCode;
	}
	public void setFiscalCode(String fiscalCode) {
		this.fiscalCode = fiscalCode;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getCellPhone() {
		return cellPhone;
	}
	public void setCellPhone(int cellPhone) {
		this.cellPhone = cellPhone;
	}
	public int getHomePhone() {
		return homePhone;
	}
	public void setHomePhone(int homePhone) {
		this.homePhone = homePhone;
	}    
}
