package it.synclab.business;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "MOVEMENTS")
public class Movement {
	
	@Id
	@SequenceGenerator(name="idSeq", sequenceName="SEQ_MOVEMENTS")
	@GeneratedValue(generator="idSeq", strategy=GenerationType.SEQUENCE)
	@Column(name = "ID")
	private int idMovement;
	
	@ManyToOne
	@JoinColumn(name="ID_USER")
	private User idUser;
	
	@Column(name = "ACTION")
	private String userName;
	
	@Column(name = "DESCRIPTION")
	private String passWord;
	
	@Column(name = "TS_OPERATION")
	private Date tsRegistration;

	
	
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public Date getTsRegistration() {
		return tsRegistration;
	}

	public void setTsRegistration(Date tsRegistration) {
		this.tsRegistration = tsRegistration;
	}
	
	
}
