package it.synclab.business;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "MOVEMENTS")
public class Movement {
	
	@Id
	@SequenceGenerator(name="idSeq", sequenceName="SEQ_MOVEMENTS", allocationSize=1)
	@GeneratedValue(generator="idSeq", strategy=GenerationType.SEQUENCE)
	@Column(name = "ID")
	private int idMovement;
	
	@ManyToOne
	@JoinColumn(name="ID_USER")
	private User idUser;
	
	@Column(name = "ACTION")
	private String action;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	@Column(name = "TS_OPERATION")
	private Date tsOperation;
	

	public int getIdMovement() {
		return idMovement;
	}

	public void setIdMovement(int idMovement) {
		this.idMovement = idMovement;
	}

	public User getIdUser() {
		return idUser;
	}

	public void setIdUser(User idUser) {
		this.idUser = idUser;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getTsOperation() {
		return tsOperation;
	}

	public void setTsOperation(Date tsOperation) {
		this.tsOperation = tsOperation;
	}
	
}
