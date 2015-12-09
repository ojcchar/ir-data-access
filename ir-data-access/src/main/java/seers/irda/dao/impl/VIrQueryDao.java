package seers.irda.dao.impl;

import java.util.List;

import org.hibernate.Session;

import seers.irda.dao.GenericDaoImpl;
import seers.irda.entity.SoftwareSystem;
import seers.irda.entity.VIrQuery;
import seers.irda.entity.VIrQueryId;

public class VIrQueryDao extends GenericDaoImpl<VIrQuery, VIrQueryId> {

	public VIrQueryDao() {
		super();
	}

	public VIrQueryDao(Session session) {
		super(session);
	}

	public List<VIrQuery> getQueries(SoftwareSystem system) {
		String[] paramNames = { "system_id" };
		VIrQueryId id = new VIrQueryId();
		id.setSystemId(system.getId());
		Object[] params = { system.getId() };
		return executeQuery("from VIrQuery i where i.id.systemId = :system_id", paramNames, params);
	}

}
