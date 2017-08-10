package it.synclab.stage.Entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Supplier implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(length=50)
	private String codeSupplier;
	@Column(length=1)
	private int evalutation;
	private Date registrationDate;
	private Date lastChange;
	@Column(length=50)
	private String website;
	@ManyToOne
	private Users modifier;	
	@Column(length=20)
	private long phone;
	@Column(length=20)
	private long fax;
	@Column(length=50)
	private String email;
	public Supplier() {
	}
	public Supplier(String codeSupplier, int evalutation, Date registrationDate, Date lastChange, String website,
			long phone, long fax, String email) {
		this.codeSupplier = codeSupplier;
		this.evalutation = evalutation;
		this.registrationDate = registrationDate;
		this.lastChange = lastChange;
		this.website = website;
		this.phone = phone;
		this.fax = fax;
		this.email = email;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCodeSupplier() {
		return codeSupplier;
	}
	public void setCodeSupplier(String codeSupplier) {
		this.codeSupplier = codeSupplier;
	}
	public int getEvalutation() {
		return evalutation;
	}
	public void setEvalutation(int evalutation) {
		this.evalutation = evalutation;
	}
	public Date getRegistrationDate() {
		return registrationDate;
	}
	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}
	public Date getLastChange() {
		return lastChange;
	}
	public void setLastChange(Date lastChange) {
		this.lastChange = lastChange;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public Users getModifier() {
		return modifier;
	}
	public void setModifier(Users modifier) {
		this.modifier = modifier;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public long getFax() {
		return fax;
	}
	public void setFax(long fax) {
		this.fax = fax;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
