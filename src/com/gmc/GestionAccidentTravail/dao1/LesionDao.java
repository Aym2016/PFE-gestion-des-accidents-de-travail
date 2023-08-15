package com.gmc.GestionAccidentTravail.dao1;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.gmc.GestionAccidentTravail.Hibernate.HibernateUtil;
import com.gmc.GestionAccidentTravail.entity.DossierAccident;
import com.gmc.GestionAccidentTravail.entity.Lesion;


public class LesionDao {
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
	 public Lesion ajouter( Lesion le){
		 Session sesion=HibernateUtil.currentSession();
		sesion.getTransaction().begin();
	 	sesion.save(le);
	 	sesion.getTransaction().commit();
	 	sesion.close();
	 return le;	
	 }
	 public void supprimer(Lesion le){
		 Session sesion=HibernateUtil.currentSession();
		sesion.getTransaction().begin();
	 	sesion.delete(le);
	 	sesion.getTransaction().commit();
	 	sesion.close();
	    
	 }
	 public Lesion modifier(Lesion le){
		 Session sesion=HibernateUtil.currentSession();
		sesion.getTransaction().begin();
	 	sesion.merge(le);
	 	sesion.getTransaction().commit();	
	 	sesion.close();
	 return le;
	 }
	 @SuppressWarnings("unchecked")
	 public List<Lesion> afficher(){
		List<Lesion> result=null;
		 SessionFactory factory = new Configuration()
					.configure("hibernate.cfg.xml")
					.addAnnotatedClass(Lesion.class)
					.buildSessionFactory();
		 Session session = factory.getCurrentSession();
			
			try {			
				
				// start a transaction
				session.beginTransaction();
				
				// query students
			result = session.createQuery("from Lesion").getResultList();
				session.getTransaction().commit();
				
				System.out.println("Done!");
			}
			finally {
				factory.close();
			}
	  return result;	
	 }
	 public Lesion chercherParId(String id) {
		 SessionFactory sessionFactory = new Configuration()
					.configure("hibernate.cfg.xml")
					.addAnnotatedClass(Lesion.class)
					.buildSessionFactory();		
		 Lesion l = null;
			Session session = null;
			Transaction transaction = null;
			try {
				session = sessionFactory.openSession();
				transaction = session.beginTransaction();
				org.hibernate.query.Query query = session.createQuery("from Lesion where RefLes = :id");
				query.setParameter("id", id);
				l= (Lesion) query.uniqueResult();
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
	 public void AjouterLesion(String id1,String id2,String id3) {
		 SessionFactory sessionFactory = new Configuration()
					.configure("hibernate.cfg.xml")
					.addAnnotatedClass(Lesion.class)
					.buildSessionFactory();		
		Lesion l=null;
			Session session = null;
			Transaction transaction = null;
			try {
				session = sessionFactory.openSession();
				transaction = session.beginTransaction();
				org.hibernate.query.Query query = session.createQuery(" insert into Lesion(RefLes,natureL,DossierLesion) values(:id1,:id2,:id3)");
				query.setParameter("id1", id1);
				query.setParameter("id2", id2);
				query.setParameter("id3", id3);
				
				transaction.commit();
			} catch (Exception e) {
				l= null;
				if (transaction != null) {
					transaction.rollback();
				}
			} finally {
				session.close();
			}
			
		}
	 public void AjouterLesion1(String id1,String id2,String id3) 
	 {
		 Configuration cfg = new Configuration();
			cfg.configure("hibernate.cfg.xml"); 
            Transaction transaction=null;
			SessionFactory factory = cfg.buildSessionFactory();
			Session session = factory.openSession();		
			transaction = session.beginTransaction();
	Query qry = session.createQuery(" insert into Lesion(RefLes,natureL,DossierLesion) values(:id1,:id2,:id3)");
		        qry.setParameter("id1",id1);
		        qry.setParameter("id2",id1);
		        qry.setParameter("id3",id3);
		        session.save(qry);
		        int res = qry.executeUpdate();
                 transaction.commit();
		        System.out.println("Command successfully executed....");
		        System.out.println("Numer of records effected...,"+res);

			session.close();
			factory.close();
	 
	 
	 
	 
	 
	 }
	 
	 @SuppressWarnings({ "rawtypes", "unchecked" })
		public List<Lesion> chercherB(String keyword) {
		 SessionFactory sessionFactory = new Configuration()
					.configure("hibernate.cfg.xml")
					.addAnnotatedClass(Lesion.class)
					.buildSessionFactory();	
		 List<Lesion> list = null;
			Session session = null;
			Transaction transaction = null;
			try {
				session = sessionFactory.openSession();
				transaction = session.beginTransaction();
				org.hibernate.query.Query query = session.createQuery("from Lesion where RefLes like CONCAT('%',:keyword,'%')");
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
	 
	 /*@SuppressWarnings("unchecked")
	 public List<Lesion> afficher(){
	 	try{
	 	return(List<Lesion>) sesion.createQuery("select le from Lesion le").getResultList();
	 } 
	 	catch(Exception e)
	 	{return null;}
	 }
	 public Lesion chercherParId(String RefLes){
		 	try{
		 		return	(Lesion) sesion.createQuery("select le from Lesion le where le.idl=:param").setParameter("param", RefLes).getSingleResult();
		 			 } 
		 	catch(Exception e)
		 	{return null;}}*/

	
	 }
