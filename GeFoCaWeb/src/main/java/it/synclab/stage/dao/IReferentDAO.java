package it.synclab.stage.dao;

import it.synclab.stage.Entities.Person;
import it.synclab.stage.Entities.Referent;

public interface IReferentDAO {
	public Referent addRerefent(Person person,long idSupplier,long idOffice);
	public void transfertRerefent(long idReferent,long idOffice);
	public void deleteReferent(Referent referent);
	public void updateReferent(Referent referent);
	public void newReferent(Referent referent);
}
