package seers.irda.dao.impl;

import org.hibernate.Session;

import seers.irda.dao.GenericDaoImpl;
import seers.irda.entity.Revision;
import seers.irda.entity.SoftwareSystem;

public class RevisionDao extends GenericDaoImpl<Revision, Integer> {

	public RevisionDao() {
		super();
	}

	public RevisionDao(Session session) {
		super(session);
	}

	public Revision getRevision(String commitId, SoftwareSystem system) {
		String[] paramNames = { "commitId", "sys" };
		Object[] params = { commitId, system };
		return executeQueryUniqueObject("from Revision r where r.commitId = :commitId and r.softwareSystem = :sys",
				paramNames, params);
	}

	public Revision getRevisionShortCommitId(String commitId, SoftwareSystem system) {
		String[] paramNames = { "commitId", "sys" };
		Object[] params = { commitId.substring(0, 7) + "%", system };
		return executeQueryUniqueObject("from Revision r where r.commitId like :commitId and r.softwareSystem = :sys",
				paramNames, params);
	}

}
