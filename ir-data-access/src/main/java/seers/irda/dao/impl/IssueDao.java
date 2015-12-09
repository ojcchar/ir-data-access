package seers.irda.dao.impl;

import java.util.List;

import org.hibernate.Session;

import seers.irda.dao.GenericDaoImpl;
import seers.irda.entity.Issue;
import seers.irda.entity.SoftwareSystem;

public class IssueDao extends GenericDaoImpl<Issue, Integer> {

	public IssueDao() {
		super();
	}

	public IssueDao(Session session) {
		super(session);
	}

	public Long getNumIssues(SoftwareSystem system) {
		String[] paramNames = { "sys" };
		Object[] params = { system };
		return executeQueryUniqueLong("select count(id) from Issue i where i.softwareSystem = :sys", paramNames,
				params);
	}

	public List<Issue> getIssues(SoftwareSystem system, int firstResult, int maxResults) {
		String[] paramNames = { "sys" };
		Object[] params = { system };
		return executeQuery("from Issue i where i.softwareSystem = :sys", paramNames, params, firstResult, maxResults);
	}

	public List<Issue> getIssues(SoftwareSystem system) {
		String[] paramNames = { "sys" };
		Object[] params = { system };
		return executeQuery("from Issue i where i.softwareSystem = :sys", paramNames, params);
	}

	public Issue getIssue(String issueId, SoftwareSystem system) {
		String[] paramNames = { "issue_id", "sys" };
		Object[] params = { issueId, system };
		return executeQueryUniqueObject("from Issue i where i.issueId = :issue_id and i.softwareSystem = :sys",
				paramNames, params);
	}

}
