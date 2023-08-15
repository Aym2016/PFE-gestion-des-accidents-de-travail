package com.gmc.GestionAccidentTravail.dao1;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.gmc.GestionAccidentTravail.Hibernate.HibernateUtil;
import com.gmc.GestionAccidentTravail.entity.BordereauEnvoi;
import com.gmc.GestionAccidentTravail.entity.Employe;
import com.gmc.GestionAccidentTravail.entity.Historique;
import com.gmc.GestionAccidentTravail.entity.Mandat;


public class MandatDao {
	//SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
	Session sesion=HibernateUtil.currentSession();
	Mandat md;
	
	/* private EntityManager em;


	 public EntityManager getEm() {
	 	if(em==null){
	 		return em=Persistence.createEntityManagerFactory("gestionaccident").createEntityManager();
	 	}
	 	return em;
	 }

	 public void setEm(EntityManager em) {
	 	this.em = em;
	 }*/
	 public  Mandat ajouter( Mandat md){
		 Session sesion=HibernateUtil.currentSession();
		sesion.getTransaction().begin();
	 	sesion.save(md);
	 	sesion.getTransaction().commit();
	 	sesion.close();
	 	return md;
	 }
	 public void supprimer( Mandat md){
		 Session sesion=HibernateUtil.currentSession(); 
	 	sesion.getTransaction().begin();
        sesion.delete(md);
	 	sesion.getTransaction().commit();	
	 	sesion.close();
	 }
	 public void modifier(Mandat md){
		 Session sesion=HibernateUtil.currentSession();
		sesion.getTransaction().begin();
	 	sesion.merge(md);
	 	sesion.getTransaction().commit();	
	 	sesion.close();
	  
	 }
	 @SuppressWarnings("unchecked")
	 public List<Mandat> afficher(){
		List<Mandat> result=null;
		
		 SessionFactory factory = new Configuration()
					.configure("hibernate.cfg.xml")
					.addAnnotatedClass(Mandat.class)
					.buildSessionFactory();
		 Session session = factory.getCurrentSession();
			
			try {			
				
				// start a transaction
				session.beginTransaction();
				
				// query students
			 result= session.createQuery("from Mandat").getResultList();
				session.getTransaction().commit();
				
				System.out.println("Done!");
			}
			finally {
				factory.close();
			}
	  return result;	
	 }
	/* @SuppressWarnings("unchecked")
	 public List<Mandat> afficher(){
		 List<Mandat> results = null;
			//Session session = null;
			Transaction transaction = null;
			try {
				
				transaction = sesion.beginTransaction();
				org.hibernate.query.Query query = sesion.createQuery("from mandat");
				results = query.getResultList();
				transaction.commit();
			} catch (Exception e) {
				results = null;
				if (transaction != null) {
					transaction.rollback();
				}
			} finally {
				sesion.close();
			}
			return results;
		 /*try{
	 	return(List<Mandat>) sesion.createQuery("select md from Mandat md").getResultList();
	 } 
	 	catch(Exception e)
	 	{return null;}*/
	 /*}*/
	/* public Mandat chercherParId(String IdMand){
		 	try{
		 		return	(Mandat) sesion.createQuery("select md from Mandat md where md.idm=:param").setParameter("param", IdMand).getSingleResult();
		 			 } 
		 	catch(Exception e)
		 	{return null;}}*/
	 @SuppressWarnings({ "rawtypes"})
		public Mandat chercherParId(String id) {
		 SessionFactory sessionFactory = new Configuration()
					.configure("hibernate.cfg.xml")
					.addAnnotatedClass(Mandat.class)
					.buildSessionFactory();
		 
		 Mandat md = null;
		 
			Session session=null;
			Transaction transaction = null;
			try {
				 session = sessionFactory.openSession();
				transaction = session.beginTransaction();
				org.hibernate.query.Query query = session.createQuery("from Mandat where IdMand = :id");
				query.setParameter("id", id);
				md = (Mandat) query.uniqueResult();
				transaction.commit();
			} catch (Exception e) {
				md= null;
				if (transaction != null) {
					transaction.rollback();
				}
			} finally {
				session.close();
			}
			return md;
		}
	 @SuppressWarnings({ "rawtypes", "unchecked" })
		public List<Mandat> chercherB(String keyword) {
		 SessionFactory sessionFactory = new Configuration()
					.configure("hibernate.cfg.xml")
					.addAnnotatedClass(Mandat.class)
					.buildSessionFactory();	
		 List<Mandat> list = null;
			Session session = null;
			Transaction transaction = null;
			try {
				session = sessionFactory.openSession();
				transaction = session.beginTransaction();
				org.hibernate.query.Query query = session.createQuery("from Mandat where IdMand like CONCAT('%',:keyword,'%')");
				query.setParameter("keyword",keyword );
				list = query.list();
				System.out.println("la liste des mandat"+list);
				
				transaction.commit();
				
			} catch (Exception e) {
				list = null;
				if (transaction != null) {
					transaction.rollback();
				}
			} finally {
				session.close();
			}
			
			return list;
			
		}
	
	 }
