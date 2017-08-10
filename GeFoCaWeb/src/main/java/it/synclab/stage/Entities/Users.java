package it.synclab.stage.Entities;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Users {
 @Id
 @GeneratedValue(strategy=GenerationType.AUTO)
 private Long id;
 @Column(length=50)
 private String username;
 @Column(length=50)
 private String password;
 @Embedded
 private Person person; 
 @Embedded
 private Address address;
 //private List<? extends Supplier>listPermisionModification =new ArrayList<>();
public Users(String username, String password) {
	super();
	this.username = username;
	this.password = password;
}
public Users() {
	super();
}
public Address getAddress() {
	return address;
}
public void setAddress(Address address) {
	this.address = address;
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public Person getPerson() {
	return person;
}
public void setPerson(Person person) {
	this.person = person;
}
}
