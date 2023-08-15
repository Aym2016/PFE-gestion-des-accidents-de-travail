package com.gmc.GestionAccidentTravail.dao1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.gmc.GestionAccidentTravail.Hibernate.HibernateUtil;
import com.gmc.GestionAccidentTravail.entity.BordereauEnvoi;
import com.gmc.GestionAccidentTravail.entity.DossierAccident;
import com.gmc.GestionAccidentTravail.entity.Employe;
import com.gmc.GestionAccidentTravail.entity.Historique;


public class DossierAccidentDao {

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
	 public  void ajouter( DossierAccident da){
		 Session sesion=HibernateUtil.currentSession();
		sesion.getTransaction().begin();
	 	sesion.save(da);
	 	sesion.getTransaction().commit();
	 	sesion.close();
	 
	 }
	 public void supprimer(DossierAccident da){
		 Session sesion=HibernateUtil.currentSession();
		 sesion.getTransaction().begin();
	 	sesion.delete(da);
	 	sesion.getTransaction().commit();
	 	sesion.close();
	 }
	 public DossierAccident modifier(DossierAccident da){
		 Session sesion=HibernateUtil.currentSession(); 
		sesion.getTransaction().begin();
	 	sesion.merge(da);
	 	sesion.getTransaction().commit();	
	 	sesion.close();
	    return da;
	 }
	 @SuppressWarnings("unchecked")
	 public List<DossierAccident> afficher(){
		List<DossierAccident> result=null;
		 SessionFactory factory = new Configuration()
					.configure("hibernate.cfg.xml")
					.addAnnotatedClass(DossierAccident.class)
					.buildSessionFactory();
		 Session session = factory.getCurrentSession();
			
			try {			
				
				// start a transaction
				session.beginTransaction();
				
				// query students
			result = session.createQuery("from DossierAccident").getResultList();
				session.getTransaction().commit();
				
				System.out.println("Done!");
			}
			finally {
				factory.close();
			}
	  return result;	
	 }
	 
	 public DossierAccident chercherParId(String id) {
		 SessionFactory sessionFactory = new Configuration()
					.configure("hibernate.cfg.xml")
					.addAnnotatedClass(DossierAccident.class)
					.buildSessionFactory();		
		 DossierAccident da = null;
			Session session = null;
			Transaction transaction = null;
			try {
				session = sessionFactory.openSession();
				transaction = session.beginTransaction();
				org.hibernate.query.Query query = session.createQuery("from DossierAccident where IdAcc = :id");
				query.setParameter("id", id);
				da= (DossierAccident) query.uniqueResult();
				transaction.commit();
			} catch (Exception e) {
				da= null;
				if (transaction != null) {
					transaction.rollback();
				}
			} finally {
				session.close();
			}
			return da;
		}
	 @SuppressWarnings({ "rawtypes", "unchecked" })
		public List<DossierAccident> chercherB(String keyword) {
		 SessionFactory sessionFactory = new Configuration()
					.configure("hibernate.cfg.xml")
					.addAnnotatedClass(DossierAccident.class)
					.buildSessionFactory();	
		 List<DossierAccident> list = null;
			Session session = null;
			Transaction transaction = null;
			try {
				session = sessionFactory.openSession();
				transaction = session.beginTransaction();
				org.hibernate.query.Query query = session.createQuery("from DossierAccident where IdAcc like CONCAT('%',:keyword,'%')");
				query.setParameter("keyword",  keyword );
				list = query.list();
				
				
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
	 	 
	 
	/* @SuppressWarnings("unchecked")
	 public List<DossierAccident> afficher(){
		 List<DossierAccident> results = null;
			//Session session = null;
			Transaction transaction = null;
			try {
				
				transaction = sesion.beginTransaction();
				org.hibernate.query.Query query = sesion.createQuery("from accident");
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
		/* try{
	 	return(List<DossierAccident>) sesion.createQuery("select da from accident da ").getResultList();
	 } 
	 	catch(Exception e)
	 	{return null;}*/
	/* }*/
	 /*public DossierAccident chercherParId(String  idAcc){
		 	try{
		 		return	(DossierAccident) sesion.createQuery("select da from accident da where da.idAcc=:param").setParameter("param", idAcc).getSingleResult();
		 			 } 
		 	catch(Exception e)
		 	{return null;}}*/

	
	 }
