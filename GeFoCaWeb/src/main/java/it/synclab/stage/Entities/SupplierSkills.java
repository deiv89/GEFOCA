package it.synclab.stage.Entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@SuppressWarnings("serial")
@Entity
public class SupplierSkills implements Serializable {
	@Id
	private Long id;

	public SupplierSkills() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
