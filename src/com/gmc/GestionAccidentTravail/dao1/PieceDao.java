package com.gmc.GestionAccidentTravail.dao1;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.gmc.GestionAccidentTravail.Hibernate.HibernateUtil;
import com.gmc.GestionAccidentTravail.entity.DossierAccident;
import com.gmc.GestionAccidentTravail.entity.Lesion;
import com.gmc.GestionAccidentTravail.entity.Piece;


public class PieceDao {
	Session sesion=HibernateUtil.currentSession();/*private EntityManager em;


	 public EntityManager getEm() {
	 	if(em==null){
	 		return em=Persistence.createEntityManagerFactory("gestionaccident").createEntityManager();
	 	}
	 	return em;
	 }

	 public void setEm(EntityManager em) {
	 	this.em = em;
	 }*/
	 public void ajouter( Piece p){
			Session sesion=HibernateUtil.currentSession();
		 sesion.getTransaction().begin();
	 	sesion.save(p);
	 	sesion.getTransaction().commit();
	 	sesion.close();
	  
	 }
	 public void supprimer(Piece p){
		 Session sesion=HibernateUtil.currentSession(); 
		sesion.getTransaction().begin();
	 	sesion.delete(p);
	 	sesion.getTransaction().commit();
	 	sesion.close();
	 }
	 public Piece modifier(Piece p){
	 	sesion.getTransaction().begin();
	 	sesion.merge(p);
	 	sesion.getTransaction().commit();	
        return p;    	 
	 }
	 @SuppressWarnings("unchecked")
	 public List<Piece> afficher(){
		List<Piece> result=null;
		 SessionFactory factory = new Configuration()
					.configure("hibernate.cfg.xml")
					.addAnnotatedClass(Piece.class)
					.buildSessionFactory();
		 Session session = factory.getCurrentSession();
			
			try {			
				
				// start a transaction
				session.beginTransaction();
				
				// query students
			result = session.createQuery("from Piece").getResultList();
				session.getTransaction().commit();
				
				System.out.println("Done!");
			}
			finally {
				factory.close();
			}
	  return result;	
	 }
	 public Piece chercherParId(String id) {
		 SessionFactory sessionFactory = new Configuration()
					.configure("hibernate.cfg.xml")
					.addAnnotatedClass(Piece.class)
					.buildSessionFactory();		
		 Piece l = null;
			Session session = null;
			Transaction transaction = null;
			try {
				session = sessionFactory.openSession();
				transaction = session.beginTransaction();
				org.hibernate.query.Query query = session.createQuery("from Piece where RefPiece = :id");
				query.setParameter("id", id);
				l= (Piece) query.uniqueResult();
				transaction.commit();
			} catch (Exception e) {
				l= null;
				if (transaction != null) {
					transaction.rollback();
				}
			} finally {
				session.close();
			}
			return l;
		}
	 @SuppressWarnings({ "rawtypes", "unchecked" })
		public List<Piece> chercherB(String keyword) {
		 SessionFactory sessionFactory = new Configuration()
					.configure("hibernate.cfg.xml")
					.addAnnotatedClass(Piece.class)
					.buildSessionFactory();	
		 List<Piece> list = null;
			Session session = null;
			Transaction transaction = null;
			try {
				session = sessionFactory.openSession();
				transaction = session.beginTransaction();
				org.hibernate.query.Query query = session.createQuery("from Piece where RefPiece like CONCAT('%',:keyword,'%')");
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
	 public List<Piece> afficher(){
	 	try{
	 	return(List<Piece>) sesion.createQuery("select p from Piece p").getResultList();
	 } 
	 	catch(Exception e)
	 	{return null;}
	 }
	 public Piece chercherParId(String RefP){
		 	try{
		 		return	(Piece) sesion.createQuery("select  from Piece p where p.RefPiece=:param").setParameter("param", RefP).getSingleResult();
		 			 } 
		 	catch(Exception e)
		 	{return null;}}*/

	
	 }
