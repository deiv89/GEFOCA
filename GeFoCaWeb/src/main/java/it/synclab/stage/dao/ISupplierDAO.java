package it.synclab.stage.dao;

import java.util.HashMap;
import java.util.List;

import it.synclab.stage.Entities.Address;
import it.synclab.stage.Entities.City;
import it.synclab.stage.Entities.Referent;
import it.synclab.stage.Entities.Supplier;
import it.synclab.stage.Entities.SupplierOffice;
import it.synclab.stage.Entities.SupplierSkills;
import it.synclab.stage.Entities.SupplierSystem;
import it.synclab.stage.exceptions.OfficeAlreadyExistException;
import it.synclab.stage.exceptions.OfficeNotFoundException;
import it.synclab.stage.exceptions.SupplierNotFoundException;

public interface ISupplierDAO{
	public Supplier addSupplier(Supplier supplier);
	public void deleteSupplier(Supplier supplier) throws SupplierNotFoundException;
	public Supplier updateSupplier(Supplier supplier);
	public List<Supplier> findAllSupplier();
	public Supplier findSupplierByWorld(String codeSupplier);
	public Supplier findSupplierByKey(long idSupplier) throws SupplierNotFoundException;
	public List<SupplierOffice> findSupplierOfficeList(long idSupplier);
	public List<Referent> findAllReferentsSupplier(long idSupplier);
	public void addSystemToSuplier(Supplier supplier,long idSystem);//idsystem is suppose coming from project candidate which should be implement
	public void addSkillToSuplier(Supplier supplier,long idSystem,long idSkill);
	public List<SupplierSystem>  findALLSystemAboutSupplier(Supplier supplier);//list all of systems on which supplier operates
	public List<SupplierSystem>  findALLSkillsPerSystemForSupplier(Supplier supplier,long idSystem);
	public HashMap<SupplierSystem, List<SupplierSkills>>mapSystemSkill();
	/*public List<Candidate> findAllCadndidateForSupplier(T supplier);
	public Candidate addCandidate(Candidate candidate);
	public void deleteCandidate(Candidate candidate);
	public Candidate updateCandidate(Candidate candidate);
	public Candidate findCandidate(Candidate candidate);*/
	public void createOffice(Supplier supplier,City city,Address address,String typeOfOffice) throws OfficeAlreadyExistException;
	public void deleteOffice(long idOffice) throws OfficeNotFoundException;
	public void updateOffice(SupplierOffice office);
	
}
