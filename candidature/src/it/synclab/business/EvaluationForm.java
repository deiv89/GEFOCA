package it.synclab.business;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "EVALUATION_FORM")
public class EvaluationForm {

	@Id
	@Column(name = "ID_CANDIDATE")
	private int idCandidate;
	
	@Column(name = "INTERVIEWER_NAME")
	private String interviewerName;
	
	@Column(name = "PRESENCE_LEVEL")
	private int levelPresence;
	
	@Column(name = "COMUNICATION_LEVEL")
	private int levelComunication;
	
	@Column(name = "DYNAMICITY_LEVEL")
	private int levelDynamicity;
	
	@Column(name = "TRANSFER")
	private String transfer;
	
	@Column(name = "MOTIVATION")
	private String motivazioni;
	
	@Column(name = "EXPERIENCES")
	private String experience;
	
	@Column(name = "CURRENT_PAY")
	private double currentPay;
	
	@Column(name = "REMUNERATION_REQUIRED")
	private double renumeration_required;
	
	@Column(name = "AVAILABILITY")
	private String availability;
	
	@Transient
	@ManyToOne(fetch = FetchType.EAGER)
	private ArrayList<Candidate_Languages> spokenLanguages;
	
	
	public String getInterviewerName() {
		return interviewerName;
	}
	public void setInterviewerName(String interviewerName) {
		this.interviewerName = interviewerName;
	}
	public int getLevelPresence() {
		return levelPresence;
	}
	public void setLevelPresence(int levelPresence) {
		this.levelPresence = levelPresence;
	}
	public int getLevelComunication() {
		return levelComunication;
	}
	public void setLevelComunication(int levelComunication) {
		this.levelComunication = levelComunication;
	}
	public int getLevelDynamicity() {
		return levelDynamicity;
	}
	public void setLevelDynamicity(int levelDynamicity) {
		this.levelDynamicity = levelDynamicity;
	}
	public String getTransfer() {
		return transfer;
	}
	public void setTransfer(String transfer) {
		this.transfer = transfer;
	}
	public String getMotivazioni() {
		return motivazioni;
	}
	public void setMotivazioni(String motivazioni) {
		this.motivazioni = motivazioni;
	}
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	
	public int getIdCandidate() {
		return idCandidate;
	}
	public void setIdCandidate(int idCandidate) {
		this.idCandidate = idCandidate;
	}
	public double getCurrentPay() {
		return currentPay;
	}
	public void setCurrentPay(double currentPay) {
		this.currentPay = currentPay;
	}
	public double getRenumeration_required() {
		return renumeration_required;
	}
	public void setRenumeration_required(double renumeration_required) {
		this.renumeration_required = renumeration_required;
	}
	public String getAvailability() {
		return availability;
	}
	public void setAvailability(String availability) {
		this.availability = availability;
	}
	public ArrayList<Candidate_Languages> getSpokenLanguages() {
		return spokenLanguages;
	}
	public void setSpokenLanguages(ArrayList<Candidate_Languages> spokenLanguages) {
		this.spokenLanguages = spokenLanguages;
	}
	
	
}
