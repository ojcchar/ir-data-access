package seers.irda.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public abstract class GenericDao<T, Id extends Serializable> {

	private static SessionFactory sessionFactory;
	private static String resourceFile = StandardServiceRegistryBuilder.DEFAULT_CFG_RESOURCE_NAME;
	private Session currentSession;
	private static StandardServiceRegistry registry;

	public GenericDao() {
	}

	public GenericDao(Session currentSession) {
		this.currentSession = currentSession;
	}

	protected static synchronized SessionFactory getSessionFactory() {

		if (sessionFactory != null) {
			return sessionFactory;
		}

		registry = new StandardServiceRegistryBuilder().configure(getResourceFile()).build();
		try {
			sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
			return sessionFactory;
		} catch (Exception e) {
			close();
			throw e;
		}
	}

	public static void close() {
		if (registry != null) {
			StandardServiceRegistryBuilder.destroy(registry);
		}
	}

	public static Session openSession() {
		return getSessionFactory().openSession();
	}

	public Session openCurrentSession() {
		currentSession = openSession();
		return currentSession;
	}

	public void closeCurrentSession() {
		currentSession.close();
	}

	public Session getCurrentSession() {
		return currentSession;
	}

	public void setCurrentSession(Session currentSession) {
		this.currentSession = currentSession;
	}

	public abstract void persist(T entity);

	public abstract void update(T entity);

	public abstract T findById(Class<T> type, Id id);

	public abstract void delete(T entity);

	public abstract List<T> findAll();

	public abstract void deleteAll();

	public static String getResourceFile() {
		return resourceFile;
	}

	public static void setResourceFile(String resourceFile) {
		GenericDao.resourceFile = resourceFile;
	}

}