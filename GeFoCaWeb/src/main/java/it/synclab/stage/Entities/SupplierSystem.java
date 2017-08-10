package it.synclab.stage.Entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@SuppressWarnings("serial")
@Entity
public class SupplierSystem implements Serializable {
	   @Id
	   private Long id;
       private Supplier supplier;
	public SupplierSystem() {
	}
	public SupplierSystem(Supplier supplier) {
		this.supplier = supplier;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Supplier getSupplier() {
		return supplier;
	}
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
    
}
