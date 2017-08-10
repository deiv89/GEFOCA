package it.synclab.stage.Entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@SuppressWarnings("serial")
@Entity
public class SupplierOffice implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idOffice;
	@Column(length=1)
	private String typeOffice;
	@ManyToOne(cascade=CascadeType.ALL)
	private Supplier supplier;	
	@Embedded
	private Address address;
	private Date registrationDate;
	private Date lastChange;
	@ManyToOne(cascade=CascadeType.ALL)
	private Users modifier;	
	@OneToMany(mappedBy="office",cascade=CascadeType.ALL)
	private List<Referent> referents=new ArrayList<>();
	public SupplierOffice() {
		super();
	}
	public SupplierOffice(String typeOffice, Date registrationDate, Date lastChange) {
		super();
		this.typeOffice = typeOffice;
		this.registrationDate = registrationDate;
		this.lastChange = lastChange;
	}
	public Long getIdOffice() {
		return idOffice;
	}
	public void setIdOffice(Long idOffice) {
		this.idOffice = idOffice;
	}
	public String getTypeOffice() {
		return typeOffice;
	}
	public void setTypeOffice(String typeOffice) {
		this.typeOffice = typeOffice;
	}
	public Supplier getSupplier() {
		return supplier;
	}
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
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
	public Users getModifier() {
		return modifier;
	}
	public void setModifier(Users modifier) {
		this.modifier = modifier;
	}
	public List<Referent> getReferents() {
		return referents;
	}
	public void setReferents(List<Referent> referents) {
		this.referents = referents;
	}
}
