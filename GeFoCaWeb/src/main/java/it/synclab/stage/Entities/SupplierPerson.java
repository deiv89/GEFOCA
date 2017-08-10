package it.synclab.stage.Entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
public class SupplierPerson extends Supplier {
	@Column(name="TYPE_CONTRACT",length=20)
	private String contractType;	
	@Embedded
	Person person;
	@Embedded
    private Address address;
	@Column(name="hirind_date")
	private Date hiringDate;
	public SupplierPerson() {
		super();
	}	
	public SupplierPerson(String codeSupplier, int evalutation, Date registrationDate, Date lastChange, String website,
			long phone, long fax, String email, String contractType, Date hiringDate) {
		super(codeSupplier, evalutation, registrationDate, lastChange, website, phone, fax, email);
		this.contractType = contractType;
		this.hiringDate = hiringDate;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getContractType() {
		return contractType;
	}
	public void setContractType(String contractType) {
		this.contractType = contractType;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public Date getHiringDate() {
		return hiringDate;
	}
	public void setHiringDate(Date hiringDate) {
		this.hiringDate = hiringDate;
	}
}
