package seers.irda.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class GenericDaoImpl<T, PK extends Serializable> extends GenericDao<T, PK> {

	public GenericDaoImpl() {
		super();
		openCurrentSession();
	}

	public GenericDaoImpl(Session currentSession) {
		super(currentSession);
	}

	public void persist(T entity) {
		getCurrentSession().persist(entity);
	}

	public void save(T entity) {
		getCurrentSession().save(entity);
	}

	public void update(T entity) {
		getCurrentSession().update(entity);
	}

	public T findById(Class<T> type, PK id) {
		return getCurrentSession().get(type, id);
	}

	public void delete(T entity) {
		getCurrentSession().delete(entity);
	}

	public List<T> findAll() {
		String query = "from T";
		return executeQuery(query);
	}

	public void deleteAll() {
		List<T> entityList = findAll();
		for (T entity : entityList) {
			delete(entity);
		}
	}

	public void merge(T entity) {
		getCurrentSession().merge(entity);
	}

	public void saveUpdate(T entity) {
		getCurrentSession().saveOrUpdate(entity);
	}

	@SuppressWarnings("unchecked")
	public List<T> executeQuery(String query) {
		Query q = getQuery(query, null, null);
		return (List<T>) q.list();
	}

	@SuppressWarnings("unchecked")
	public List<T> executeQuery(String query, String[] paramNames, Object[] params) {
		Query q = getQuery(query, paramNames, params);
		return (List<T>) q.list();
	}

	@SuppressWarnings("unchecked")
	public List<T> executeQuery(String query, String[] paramNames, Object[] params, int firstResult, int maxResults) {
		Query q = getQuery(query, paramNames, params);
		q.setFirstResult(firstResult);
		q.setMaxResults(maxResults);
		return (List<T>) q.list();
	}

	@SuppressWarnings("unchecked")
	public T executeQueryUniqueObject(String query, String[] paramNames, Object[] params) {
		return (T) getQuery(query, paramNames, params).uniqueResult();
	}

	protected Query getQuery(String query, String[] paramNames, Object[] params) {
		Query q = getCurrentSession().createQuery(query);
		if (paramNames != null && params != null) {
			for (int i = 0; i < params.length; i++) {
				Object param = params[i];
				q.setParameter(paramNames[i], param);
			}
		}
		return q;
	}

	public Object executeQueryUnique(String query, String[] paramNames, Object[] params) {
		return getQuery(query, paramNames, params).uniqueResult();
	}

	public Long executeQueryUniqueLong(String query, String[] paramNames, Object[] params) {
		return (Long) executeQueryUnique(query, paramNames, params);
	}
}