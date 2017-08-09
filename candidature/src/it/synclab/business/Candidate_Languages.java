package it.synclab.business;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "CANDIDATE_LANGUAGES")
public class Candidate_Languages {
	
	
	@Id
	@Column(name = "ID_LANGUAGE")
	private int idLanguage;
	
	//@Column(name = "LANGUAGE_NAME")
	@Transient
	private String languageName;
	
	@Column(name = "ID_CANDIDATE")
	private int idCandidate;
	
	@Column(name = "LANGUAGE_LEVEL")
	private int languageLevel;
	
	/*@ManyToOne
	@JoinColumn(name = "ID_CANDIDATE", insertable=false, updatable=false)	   //, insertable=false, updatable=false
	private Candidate candidate;*/
	
	
	public int getIdLanguage() {
		return idLanguage;
	}
	public void setIdLanguage(int idLanguage) {
		this.idLanguage = idLanguage;
	}
	public int getIdCandidate() {
		return idCandidate;
	}
	public void setIdCandidate(int idCandidate) {
		this.idCandidate = idCandidate;
	}
	public String getLanguageName() {
		return languageName;
	}
	public void setLanguageName(String languageName) {
		this.languageName = languageName;
	}
	public int getLanguageLevel() {
		return languageLevel;
	}
	public void setLanguageLevel(int languageLevel) {
		this.languageLevel = languageLevel;
	}
	
}
