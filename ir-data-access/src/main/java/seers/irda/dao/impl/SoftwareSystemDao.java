package seers.irda.dao.impl;

import org.hibernate.Session;

import seers.irda.dao.GenericDaoImpl;
import seers.irda.entity.SoftwareSystem;

public class SoftwareSystemDao extends GenericDaoImpl<SoftwareSystem, Integer> {

	public SoftwareSystemDao() {
		super();
	}

	public SoftwareSystemDao(Session session) {
		super(session);
	}

	public SoftwareSystem getSystem(String name) {
		String[] paramNames = { "name" };
		Object[] params = { name };
		return executeQueryUniqueObject("From SoftwareSystem s where s.name = :name", paramNames, params);
	}

}
