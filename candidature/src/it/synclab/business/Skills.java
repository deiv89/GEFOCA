package it.synclab.business;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "SKILLS")
public class Skills {
	
	@Transient
	private int idCandidate;
	
	@Id
	@Column(name = "ID_SKILL")
	private int idSkill;
	
	@ManyToOne
	@JoinColumn(name="ID_SCOPE")
	private Scope idScope;
	
	/*@Column(name = "ID_SCOPE")
	private int idScope;*/
	
	@Column(name = "SKILL_NAME")
	private String parameterName;
	
	@Transient
	private int valuationLevel;
	
	@Transient
	private String scopeName;
	
	
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
	public Scope getIdScope() {
		return idScope;
	}
	public void setIdScope(Scope idScope) {
		this.idScope = idScope;
	}
	public String getScopeName() {
		return scopeName;
	}
	public void setScopeName(String scopeName) {
		this.scopeName = scopeName;
	}
	
	
}
