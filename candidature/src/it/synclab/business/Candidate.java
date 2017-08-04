package it.synclab.business;

import java.util.List;

import javax.persistence.*;
//X commit di test ciauuuu
//ulteriore commento per Augustin
//test augustin
//ultima prova
@Entity
@Table(name = "CANDIDATE")
public class Candidate {
	
	@Id
	@SequenceGenerator(name="idSeq", sequenceName="SEQ_CANDIDATE")
	@GeneratedValue(generator="idSeq", strategy=GenerationType.SEQUENCE)
	@Column(name = "ID_CANDIDATE")
	private int idCandidate;

	@Column(name = "NAME")
	private String name;
	
	@Column(name = "SURNAME")
	private String surname;
	
	@Column(name = "DATE_OF_BIRTH")
	private String dateOfBirth;
	
	@Column(name = "QUALIFICATION")
	private String qualification;

	@Column(name = "ID_ORIGIN")	
	private int idOrigin;
	
	/*@ManyToOne()
	@JoinColumn(name = "ID_ORIGIN")	
	private Origin origin;*/
	
	@Transient
	private List<Candidate_Skills> skills;
	
	@OneToMany()
	@JoinColumn(name = "ID_CANDIDATE")	
	private List<Candidate_Skills> skillRels;
	
	@OneToMany()
	@JoinColumn(name = "ID_CANDIDATE")	
	private List<Candidate_Languages> spokenLanguages;

	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public int getIdCandidate() {
		return idCandidate;
	}

	public void setIdCandidate(int idCandidate) {
		this.idCandidate = idCandidate;
	}

	public int getIdOrigin() {
		return idOrigin;
	}

	public void setIdOrigin(int idOrigin) {
		this.idOrigin = idOrigin;
	}

	public List<Candidate_Skills> getSkills() {
		return skills;
	}

	public void setSkills(List<Candidate_Skills> skills) {
		this.skills = skills;
	}

	public List<Candidate_Skills> getSkillRels() {
		return skillRels;
	}

	public void setSkillRels(List<Candidate_Skills> skillRels) {
		this.skillRels = skillRels;
	}

	public List<Candidate_Languages> getSpokenLanguages() {
		return spokenLanguages;
	}

	public void setSpokenLanguages(List<Candidate_Languages> spokenLanguages) {
		this.spokenLanguages = spokenLanguages;
	}

}
