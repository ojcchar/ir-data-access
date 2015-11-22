package seers.irda.dao.impl;

import org.hibernate.Session;

import seers.irda.dao.GenericDaoImpl;
import seers.irda.entity.ChangeSet;
import seers.irda.entity.ChangeSetId;

public class ChangeSetDao extends GenericDaoImpl<ChangeSet, ChangeSetId> {

	public ChangeSetDao(Session session) {
		super(session);
	}

	public ChangeSet getChangeSet(ChangeSetId id) {
		return findById(ChangeSet.class, id);
	}

}
