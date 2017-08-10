package it.synclab.stage.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

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
@Transactional
public class SupplierDAOImpl implements ISupplierDAO {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Supplier addSupplier(Supplier supplier) {
		   entityManager.persist(supplier);
		return supplier;
	}

	@Override
	public void deleteSupplier(Supplier supplier) throws SupplierNotFoundException {
		Object sup = entityManager.find(Supplier.class, supplier.getId());
		if(sup == null) throw new SupplierNotFoundException("Sorry Supplier not found");
		entityManager.remove(sup);		
	}

	@Override
	public Supplier updateSupplier(Supplier supplier) {
		entityManager.merge(supplier);
		return supplier;
	}

	@Override
	public List<Supplier> findAllSupplier() {
		Query query =entityManager.createQuery("select s from Supplier s");
		return query.getResultList();
	}

	@Override
	public Supplier findSupplierByWorld(String codeSupplier) {
		Query query =entityManager.createQuery("select s from Supplier where s.codeSupplier like :code");
		  query.setParameter("code", "%"+codeSupplier+"%");
		return (Supplier) query;
	}

	@Override
	public Supplier findSupplierByKey(long idSupplier) throws SupplierNotFoundException {
		Object sup = entityManager.find(Supplier.class, idSupplier);
		if(sup == null) throw new SupplierNotFoundException("Sorry Supplier not found");
		return (Supplier) sup;
	}

	@Override
	public List<SupplierOffice> findSupplierOfficeList(long idSupplier) {
		Query query =entityManager.createQuery("select s from SupplierOffice where s.id = :code");
		query.setParameter("code", idSupplier);
		return query.getResultList();
	}

	@Override
	public List<Referent> findAllReferentsSupplier(long idSupplier) {
		Query query =entityManager.createQuery("select r from Referent where r.supplier.id = :idSupplier");
		query.setParameter("idSupplier", idSupplier);
		return query.getResultList();
	}

	@Override
	public void addSystemToSuplier(Supplier supplier, long idSystem) {		
		
	}

	@Override
	public void addSkillToSuplier(Supplier supplier, long idSystem, long idSkill) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<SupplierSystem> findALLSystemAboutSupplier(Supplier supplier) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SupplierSystem> findALLSkillsPerSystemForSupplier(Supplier supplier, long idSystem) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashMap<SupplierSystem, List<SupplierSkills>> mapSystemSkill() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createOffice(Supplier supplier, City city, Address address, String typeOfOffice) throws OfficeAlreadyExistException {
		 SupplierOffice office =new SupplierOffice();
		 office.setTypeOffice(typeOfOffice);
		 address.setCity(city);
		 office.setAddress(address);
		 office.setRegistrationDate(new Date());
		 office.setLastChange(new Date());
		 office.setSupplier(supplier);
		 Query query =entityManager.createQuery("select s from SupplierOffice where s.supplier=:sup and s.address=:addr");
		 query.setParameter("sup", supplier.getId());
		 query.setParameter("addr", address);
		 if(query !=null)throw new OfficeAlreadyExistException("Sorry Office Already");
		// entityManager.persist(office);
		 
		
	}

	@Override
	public void deleteOffice(long idOffice) throws OfficeNotFoundException {
		Object office = entityManager.find(SupplierOffice.class, idOffice);
		if(office == null) throw new OfficeNotFoundException("Sorry Office not found");
		entityManager.remove(office);		
	}

	@Override
	public void updateOffice(SupplierOffice office) {
		entityManager.merge(office);		
	}

}
