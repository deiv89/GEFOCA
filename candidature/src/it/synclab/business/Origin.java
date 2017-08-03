package it.synclab.business;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "ORIGIN")
public class Origin {
	                              //aggiunto allocationSize in quanto venivano generati id negativi su db
	@Id
	@SequenceGenerator(name="idSeq", sequenceName="SEQ_ORIGIN", allocationSize=1)  
	@GeneratedValue(generator="idSeq", strategy=GenerationType.SEQUENCE)
	@Column(name = "ID_ORIGIN")
	private int idOrigin;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	@Column(name = "ADDRESS")
	private String address;
	
	@Column(name = "PHONE")
	private String phone;
	
	
	public int getIdOrigin() {
		return idOrigin;
	}
	public void setIdOrigin(int idOrigin) {
		this.idOrigin = idOrigin;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	

}
