package it.synclab.business;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "LANGUAGES")
public class Language {
	
	
	//@SequenceGenerator(name = "idSeq", sequenceName = "LANG_SEQ")
	//@GeneratedValue(strategy = GenerationType.AUTO, generator = "idSeq")
	@Id
	@Column(name = "ID_LANGUAGE")
	private int idLanguage;
	
	@Column(name = "LANGUAGE_NAME")
	private String languageName;
	
	//@Column(name = "ID_CANDIDATE")
	@Transient
	private int idCandidate;
	
	//@Column(name = "LANGUAGE_LEVEL")
	@Transient
	private int languageLevel;
	
	
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
