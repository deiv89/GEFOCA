package it.synclab.business;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "SCOPE")
public class Scope {
	
	@Id
	@Column(name = "ID_SCOPE")
	private int idScope;
	
	@Column(name = "SCOPE_NAME")
	private String scopeName;
	
	@OneToMany(mappedBy = "idScope", cascade = CascadeType.ALL)
	private List<Skills> skills = new ArrayList<>();

	
	public int getIdScope() {
		return idScope;
	}

	public void setIdScope(int idScope) {
		this.idScope = idScope;
	}

	public String getScopeName() {
		return scopeName;
	}

	public void setScopeName(String scopeName) {
		this.scopeName = scopeName;
	}

	/*public List<Skills> getSkills() {
		return skills;
	}

	public void setSkills(List<Skills> skills) {
		this.skills = skills;
	}*/
	
	
	
	
}
