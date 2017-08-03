package it.synclab.service;

import java.sql.SQLException;
import java.util.ArrayList;

import it.synclab.business.Origin;

public class OriginCollectionService implements IOriginService {

	private ArrayList<Origin> originList = new ArrayList<Origin>();

	public ArrayList<Origin> getSkillsList() {

		return originList;

	}

	private static OriginCollectionService instance = new OriginCollectionService();

	private OriginCollectionService() {

	}

	public static OriginCollectionService getInstance() {
		if (instance == null)
			instance = new OriginCollectionService();
		return instance;
	}

	@Override
	public Origin create(Origin origin) {
		originList.add(origin);
		return origin;
	}

	@Override
	public Origin read(int idCandidate) {
		Origin origin = new Origin();
		for (int i = 0; i < originList.size(); i++) {
			if (originList.get(i).getIdOrigin() == idCandidate) {
				origin.setDescription(originList.get(i).getDescription());
				origin.setAddress(originList.get(i).getAddress());
				origin.setPhone(originList.get(i).getPhone());
				origin.setIdOrigin(idCandidate);
			}
		}
		return origin;
	}

	@Override
	public void update(Origin origin) {
		int index = 0;
		for (int i = 0; i < originList.size(); i++) {
			if (originList.get(i).getIdOrigin() == origin.getIdOrigin())
				index = i;
		}
		originList.set(index, origin);
	}

	@Override
	public void delete(int idCandidate) {
		for (int i = 0; i < originList.size(); i++) {
			if (originList.get(i).getIdOrigin() == idCandidate)
				originList.remove(i);
		}
	}

	public void create(Origin origin, String surname) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateIdOriginCandidate(int idCandidate, int idOrigin) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
	}


	

}
