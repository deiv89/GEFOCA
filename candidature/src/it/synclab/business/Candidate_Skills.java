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
@Table(name = "CANDIDATE_SKILLS")
public class Candidate_Skills {
	
	//@Transient
	
	/*@SequenceGenerator(name = "idSeq", sequenceName = "SEQ_SKILLS")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idSeq")*/
	@Id
	@Column(name = "ID_SKILL")
	private int idSkill;
	
	@Column(name = "ID_CANDIDATE")
	private int idCandidate;
	
	@Transient
	private String parameterName;
	
	@Column(name = "SKILL_LEVEL")
	private int valuationLevel;
	
	@Transient
	private String categorySkill;
	
	
	public int getIdCandidate() {
		return idCandidate;
	}
	public void setIdCandidate(int idCandidate) {
		this.idCandidate = idCandidate;
	}
	public String getParameterName() {
		return parameterName;
	}
	public void setParameterName(String parameterName) {
		this.parameterName = parameterName;
	}
	public int getValuationLevel() {
		return valuationLevel;
	}
	public void setValuationLevel(int valuationLevel) {
		this.valuationLevel = valuationLevel;
	}
	public int getIdSkill() {
		return idSkill;
	}
	public void setIdSkill(int idSkill) {
		this.idSkill = idSkill;
	}
	public String getCategorySkill() {
		return categorySkill;
	}
	public void setCategorySkill(String categorySkill) {
		this.categorySkill = categorySkill;
	}
	
}
