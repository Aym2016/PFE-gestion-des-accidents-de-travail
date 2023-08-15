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


public class HistoriqueDao {
	/*private EntityManager em;


	 public EntityManager getEm() {
	 	if(em==null){
	 		return em=Persistence.createEntityManagerFactory("gestionaccident").createEntityManager();
	 	}
	 	return em;
	 }

	 public void setEm(EntityManager em) {
	 	this.em = em;
	 }*/
	 public void ajouter( Historique h){
		 Session sesion=HibernateUtil.currentSession();
		 sesion.getTransaction().begin();
	 	sesion.save(h);
	 	sesion.getTransaction().commit();
	    sesion.close();
	 }
	 public void supprimer(Historique h){
		Session sesion=HibernateUtil.currentSession();
		sesion.getTransaction().begin();
	 	sesion.delete(h);
	 	sesion.getTransaction().commit();	
	    sesion.close();
	 }
	 public Historique modifier(Historique h){
		 Session sesion=HibernateUtil.currentSession();
		sesion.getTransaction().begin();
	 	sesion.merge(h);
	 	sesion.getTransaction().commit();	
	    sesion.close();
	 	return h;
	 }
	 @SuppressWarnings("unchecked")
	 public List<Historique> afficher(){
		List<Historique> result=null;
		 SessionFactory factory = new Configuration()
					.configure("hibernate.cfg.xml")
					.addAnnotatedClass(Employe.class)
					.buildSessionFactory();
		 Session session = factory.getCurrentSession();
			
			try {			
				
				// start a transaction
				session.beginTransaction();
				
				// query students
			result = session.createQuery("from Historique").getResultList();
				session.getTransaction().commit();
				
				System.out.println("Done!");
			}
			finally {
				factory.close();
			}
	  return result;	
	 }
	 
	 
	 /* @SuppressWarnings("unchecked")
	 public List<Historique> afficher(){
	 	try{
	 	return(List<Historique>) sesion.createQuery("select h from Historique h").getResultList();
	 } 
	 	catch(Exception e)
	 	{return null;}
	 }*/
	/* public Historique chercherParId(int id){
		 	try{
		 		return	(Historique) sesion.createQuery("select h from Historique h where h.idh=:param").setParameter("param", id).getSingleResult();
		 			 } 
		 	catch(Exception e)
		 	{return null;}}*/
	 public Historique chercherParId(int id) {
		 SessionFactory sessionFactory = new Configuration()
					.configure("hibernate.cfg.xml")
					.addAnnotatedClass(Historique.class)
					.buildSessionFactory();	
		 Historique h = null;
			Session session = null;
			Transaction transaction = null;
			try {
				session = sessionFactory.openSession();
				transaction = session.beginTransaction();
				org.hibernate.query.Query query = session.createQuery("from Historique where id = :id");
				query.setParameter("id",id);
				h = (Historique) query.uniqueResult();
				System.out.println(h);
				transaction.commit();
			} catch (Exception e) {
				h= null;
				if (transaction != null) {
					transaction.rollback();
				}
			} finally {
				session.close();
			}
			return h;
			
		}
	 @SuppressWarnings({ "rawtypes", "unchecked" })
		public List<Historique> chercherB(int keyword) {
		 SessionFactory sessionFactory = new Configuration()
					.configure("hibernate.cfg.xml")
					.addAnnotatedClass(Historique.class)
					.buildSessionFactory();	
		 List<Historique> listh = null;
			Session session = null;
			Transaction transaction = null;
			try {
				session = sessionFactory.openSession();
				transaction = session.beginTransaction();
				org.hibernate.query.Query query = session.createQuery("from Historique where id like CONCAT('%',:keyword,'%')");
				query.setParameter("keyword",  keyword );
				listh = query.list();
				
				
				transaction.commit();
				
			} catch (Exception e) {
				listh = null;
				if (transaction != null) {
					transaction.rollback();
				}
			} finally {
				session.close();
			}
			
			return listh;
			
		}

	
	 }
