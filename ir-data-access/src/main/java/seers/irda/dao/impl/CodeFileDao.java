package seers.irda.dao.impl;

import org.hibernate.Session;

import seers.irda.dao.GenericDaoImpl;
import seers.irda.entity.CodeFile;
import seers.irda.entity.SoftwareSystem;

public class CodeFileDao extends GenericDaoImpl<CodeFile, Integer> {

	public CodeFileDao(Session session) {
		super(session);
	}

	public CodeFile getCodeFile(String path, SoftwareSystem system) {
		String[] paramNames = { "path", "sys" };
		Object[] params = { path, system };
		return executeQueryUniqueObject("from CodeFile r where r.filePath = :path and r.softwareSystem = :sys",
				paramNames, params);

	}

}
