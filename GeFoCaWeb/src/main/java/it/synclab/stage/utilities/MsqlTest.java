package it.synclab.stage.utilities;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import it.synclab.stage.Entities.City;
import it.synclab.stage.Entities.Country;
import it.synclab.stage.Entities.Province;
import it.synclab.stage.Entities.Region;

public class MsqlTest {

	public MsqlTest() {
		super();
		
	}

	public static void main(String[] args) {
		SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		it.synclab.stage.Entities.Address a1=new it.synclab.stage.Entities.Address("Via", "Lancetti", "40/B");				
		Country country =new Country("Itlia", 39, "IT");
		
		Region region =new Region("Lombardia");
		region.setCountry(country);
		Province province =new Province("MIlano", "MI");
		province.setRegion(region);
		City city=new City(20136, "Milan", "MI");
		city.setProvince(province);
		session.save(country);
		session.getTransaction().commit();
		session.close();
		
		System.out.println("yessss");

	}

}
