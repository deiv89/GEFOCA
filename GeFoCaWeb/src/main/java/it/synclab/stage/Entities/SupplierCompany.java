package it.synclab.stage.Entities;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@SuppressWarnings("serial")
@Entity
public class SupplierCompany extends Supplier {	
	@Column(length=11)
	private int pIva;
	@Column(length=11)
	private int fiscalCode;
	@Column(length=50)
	private String denomination;	
	private double capital;
	@Column(length=50)
	private String description;
	@ManyToOne(cascade=CascadeType.ALL)
	private SupplierOffice operativeOffice ;
	@ManyToOne(cascade=CascadeType.ALL)
	private SupplierOffice headquaters ;	
	//private List<Candidate> candidates=new ArrayList<>();
	@OneToMany(mappedBy="supplier",cascade=CascadeType.ALL)
	private List<SupplierOffice>offices=new ArrayList<>();
	@OneToMany(mappedBy="supplier",cascade=CascadeType.ALL)
	private List<Referent> referents=new ArrayList<>();		
	public SupplierCompany() {
		super();
	}
	public SupplierCompany(int pIva, int fiscalCode, String denomination, double capital,
			String description) {
		super();
		this.pIva = pIva;
		this.fiscalCode = fiscalCode;
		this.denomination = denomination;
		this.capital = capital;
		this.description = description;
	}
	public SupplierOffice getOperativeOffice() {
		return operativeOffice;
	}
	public void setOperativeOffice(SupplierOffice operativeOffice) {
		this.operativeOffice = operativeOffice;
	}
	public double getCapital() {
		return capital;
	}
	public void setCapital(double capital) {
		this.capital = capital;
	}
	public int getpIva() {
		return pIva;
	}
	public void setpIva(int pIva) {
		this.pIva = pIva;
	}
	public int getFiscalCode() {
		return fiscalCode;
	}
	public void setFiscalCode(int fiscalCode) {
		this.fiscalCode = fiscalCode;
	}
	public String getDenomination() {
		return denomination;
	}
	public void setDenomination(String denomination) {
		this.denomination = denomination;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public SupplierOffice getHeadquaters() {
		return headquaters;
	}
	public void setHeadquaters(SupplierOffice headquaters) {
		this.headquaters = headquaters;
	}
	public List<SupplierOffice> getOffices() {
		return offices;
	}
	public void setOffices(List<SupplierOffice> offices) {
		this.offices = offices;
	}
	public List<Referent> getReferents() {
		return referents;
	}
	public void setReferents(List<Referent> referents) {
		this.referents = referents;
	}
	@Override
	public String toString() {
		String infoCompany;
		infoCompany=denomination+"\n"+
		            "Sede Legale :"+headquaters.getAddress().toString()+"\n"+
				    "Sede Amministrativo: "+operativeOffice.getAddress().toString()+"\n"+
		            "Registro Imprese di "+headquaters.getAddress().getCity()+" e C.F "+fiscalCode+"\n" +
				    "P.IVA "+this.getpIva()+"\n"+
		            "Capitale sociale € "+this.capital+" i.v"+"\n"+
				    description;
		return infoCompany;
	}		
}
