package seers.irda.dao.impl;

import org.hibernate.Session;

import seers.irda.dao.GenericDaoImpl;
import seers.irda.entity.IrDocument;
import seers.irda.entity.Revision;

public class IrDocumentDao extends GenericDaoImpl<IrDocument, Integer> {

	public IrDocumentDao() {
		super();
	}

	public IrDocumentDao(Session session) {
		super(session);
	}

	public IrDocument getIrDocument(String docName, Revision revision) {
		String[] paramNames = { "doc_name", "revision" };
		Object[] params = { docName, revision };
		return executeQueryUniqueObject("from IrDocument i where i.name = :doc_name and i.revision = :revision",
				paramNames, params);
	}

}
