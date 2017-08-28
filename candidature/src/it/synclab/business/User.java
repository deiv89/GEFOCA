package it.synclab.business;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "USERS")
public class User {
	
	@Id
	@SequenceGenerator(name="idSeq", sequenceName="SEQ_USERS" , allocationSize=1)
	@GeneratedValue(generator="idSeq", strategy=GenerationType.SEQUENCE)
	@Column(name = "ID")
	private int idUser;
	
	@Column(name = "USERNAME")
	private String userName;
	
	@Column(name = "PASSWORD")
	private String passWord;
	
	@Column(name = "TS_REGISTRATION")
	private Date tsRegistration;
	

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
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
