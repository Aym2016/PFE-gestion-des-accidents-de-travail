
package com.gmc.GestionAccidentTravail.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
public class HibernateUtil {
	/*private static final SessionFactory sessionFactory;

	static {
		try {
			StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
			Metadata metaData = new MetadataSources(standardRegistry).getMetadataBuilder().build();
			sessionFactory = metaData.getSessionFactoryBuilder().build();
		} catch (Throwable th) {
			throw new ExceptionInInitializerError(th);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;

	}*/
	private static Session session;
public static Session currentSession() throws HibernateException {
// Ouvre une nouvelle Session, si il y en a aucune
if ((session == null) || !session.isOpen() ){
SessionFactory sessionFactory =
new Configuration().configure().buildSessionFactory();
session = sessionFactory.getCurrentSession();
}
return session;
}
public static void closeSession() throws HibernateException {
if (session != null && session.isOpen())
session.close(); } }