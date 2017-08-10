package it.synclab.stage.utilities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.tomcat.jni.Address;

import it.synclab.stage.Entities.City;
import it.synclab.stage.Entities.Country;
import it.synclab.stage.Entities.Province;
import it.synclab.stage.Entities.Region;
import it.synclab.stage.Entities.Supplier;
import it.synclab.stage.Entities.SupplierCompany;
import it.synclab.stage.Entities.SupplierPerson;
import it.synclab.stage.Entities.SupplierPiVa;

public class TestCreatianDB {

	public static void main1(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("GeFoCaWeb_PU");
		 EntityManager	em=emf.createEntityManager();
		  em.getTransaction().begin();
		  Supplier supplier = new Supplier();
		     supplier.setEmail("augustetak@yahoo.fr");
		     supplier.setEvalutation(5);
		     supplier.setFax(32);
		     em.persist(supplier);
		     em.getTransaction().commit();

	}
	public static void main(String[] args) {
		EntityManager em =EntityManagerUtil.getEntityManager();
		em.getTransaction().begin();
		it.synclab.stage.Entities.Address a1=new it.synclab.stage.Entities.Address("Via", "Lancetti", "40/B");				
		Country country =new Country("Itlia", 39, "IT");
					
			em.persist(country);
			//a1.setCity(city);			
		
		
		Region region =new Region("Lombardia");
		region.setCountry(country);
		Province province =new Province("MIlano", "MI");
		province.setRegion(region);
		City city=new City(20136, "Milan", "MI");
		city.setProvince(province);
		
		
		
		Supplier supplier = new Supplier();
		Supplier supplierA = new SupplierCompany();
		Supplier supplierF = new SupplierPerson();
		Supplier supplierP = new SupplierPiVa();

	}

}
