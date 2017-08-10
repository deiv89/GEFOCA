package it.synclab.stage.Entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class Referent implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Embedded
	private Person person;
	@Embedded
    private Address address;
	@ManyToOne(cascade=CascadeType.ALL)
	private Supplier supplier;
	@ManyToOne(cascade=CascadeType.ALL)
	private SupplierOffice office;
	private Date registrationDate;
	private Date lastModification;
	@ManyToOne(cascade=CascadeType.ALL)
	private Users Modifier;
	public Referent(Date registrationDate, Date lastModification) {
		this.registrationDate = registrationDate;
		this.lastModification = lastModification;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Referent() {
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public Supplier getSupplier() {
		return supplier;
	}
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	public SupplierOffice getOffice() {
		return office;
	}
	public void setOffice(SupplierOffice office) {
		this.office = office;
	}
	public Date getRegistrationDate() {
		return registrationDate;
	}
	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}
	public Date getLastModification() {
		return lastModification;
	}
	public void setLastModification(Date lastModification) {
		this.lastModification = lastModification;
	}
	public Users getModifier() {
		return Modifier;
	}
	public void setModifier(Users modifier) {
		Modifier = modifier;
	}
	

}
