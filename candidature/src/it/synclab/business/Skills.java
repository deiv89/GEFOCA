package it.synclab.business;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "SKILLS_MATRIX")
public class Skills {
	
	@Transient
	private int idCandidate;
	
	@Id
	@Column(name = "ID_SKILL")
	private int idSkill;
	
	@Column(name = "SKILL_NAME")
	private String parameterName;
	
	@Transient
	private int valuationLevel;
	
	@Column(name = "SKILL_CATEGORY")
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
