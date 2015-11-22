package seers.irda.dao.impl;

import org.hibernate.Session;

import seers.irda.dao.GenericDaoImpl;
import seers.irda.entity.IssueRevision;
import seers.irda.entity.IssueRevisionId;

public class IssueRevisionDao extends GenericDaoImpl<IssueRevision, IssueRevisionId> {

	public IssueRevisionDao() {
		super();
	}

	public IssueRevisionDao(Session session) {
		super(session);
	}

	public IssueRevision getIssueRevision(IssueRevisionId id) {
		String[] paramNames = { "id" };
		Object[] params = { id };
		return executeQueryUniqueObject("from IssueRevision r where r.id = :id", paramNames, params);
	}

}
