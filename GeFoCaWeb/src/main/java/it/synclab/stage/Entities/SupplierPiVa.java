package it.synclab.stage.Entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
@SuppressWarnings("serial")
@Entity
public class SupplierPiVa extends Supplier {
	@Column(name="CF",length=16)
	private String codeFiscal;
	@Column(length=11)
	private int pIva;	
	@Embedded
	private Person person;
	@Embedded
    private Address address;
	public SupplierPiVa() {
	}
	public SupplierPiVa(String codeSupplier, int evalutation, Date registrationDate, Date lastChange, String website,
			long phone, long fax, String email, String codeFiscal, int pIva) {
		super(codeSupplier, evalutation, registrationDate, lastChange, website, phone, fax, email);
		this.codeFiscal = codeFiscal;
		this.pIva = pIva;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getCodeFiscal() {
		return codeFiscal;
	}
	public void setCodeFiscal(String codeFiscal) {
		this.codeFiscal = codeFiscal;
	}
	public int getpIva() {
		return pIva;
	}
	public void setpIva(int pIva) {
		this.pIva = pIva;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}

}
