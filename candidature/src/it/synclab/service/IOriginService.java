package it.synclab.service;

import java.sql.SQLException;

import it.synclab.business.Origin;

public interface IOriginService {

	
	public Origin create(Origin origin) throws ClassNotFoundException, SQLException;

	public Origin read(int idOrigin) throws ClassNotFoundException, SQLException;

	public void update(Origin origin) throws ClassNotFoundException, SQLException;
	
	public void updateIdOriginCandidate(int idCandidate, int idOrigin) throws ClassNotFoundException, SQLException;

	public void delete(int idOrigin) throws ClassNotFoundException, SQLException;

}
