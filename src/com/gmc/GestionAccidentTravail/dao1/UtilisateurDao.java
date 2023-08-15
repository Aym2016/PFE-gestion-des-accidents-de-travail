package com.gmc.GestionAccidentTravail.dao1;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.gmc.GestionAccidentTravail.entity.DossierAccident;
import com.gmc.GestionAccidentTravail.entity.Historique;
import com.gmc.GestionAccidentTravail.entity.Utilisateur;
import  com.gmc.GestionAccidentTravail.Hibernate.HibernateUtil;;

public class UtilisateurDao {
	Session sesion=HibernateUtil.currentSession();/* private EntityManager em;


	 public EntityManager getEm() {
	 	if(em==null){
	 		return em=Persistence.createEntityManagerFactory("tunisair2").createEntityManager();
	 	}
	 	return em;
	 }

	 public void setEm(EntityManager em) {
	 	this.em = em;
	 }*/
	 public Utilisateur ajouter(Utilisateur d){
	 	sesion.getTransaction().begin();
	 	sesion.save(d);
	    sesion.getTransaction().commit();
	 return d;	
	 }
	 public void supprimer(Utilisateur d){
		 Session sesion=HibernateUtil.currentSession(); 
		sesion.getTransaction().begin();
	 	sesion.delete(d);
	 	sesion.getTransaction().commit();	
	 	sesion.close();
	 }
	 public Utilisateur modifier(Utilisateur d){
		Session sesion=HibernateUtil.currentSession(); 
		sesion.getTransaction().begin();
	 	sesion.merge(d);
        sesion.getTransaction().commit();	
        sesion.close();
	 return d;
	 }
	
	 
	 @SuppressWarnings("unchecked")
	 public List<Utilisateur> afficher(){
		List<Utilisateur> result=null;
		 SessionFactory factory = new Configuration()
					.configure("hibernate.cfg.xml")
					.addAnnotatedClass(Utilisateur.class)
					.buildSessionFactory();
		 Session session = factory.getCurrentSession();
			
			try {			
				
				// start a transaction
				session.beginTransaction();
				
				// query students
			result = session.createQuery("from Utilisateur").getResultList();
				session.getTransaction().commit();
				
				System.out.println("Done!");
			}
			finally {
				factory.close();
			}
	  return result;	
	 }
	 
	 
	 /* public List<Utilisateur> afficher(){
		 
	 	try{
	 	return(List<Utilisateur>) sesion.createQuery("select d from Utilisateur d").getResultList();
	 } 
	 	catch(Exception e)
	 	{return null;}
	 }*/

	/* public Utilisateur chercherParId(String id){
		 	try{
		 		return	 (Utilisateur)sesion.createQuery("select d from Utilisateur d where d.identifiant=:param").setParameter("param", id).getSingleResult();
		 	//return(List<Utilisateur>) getEm().createQuery("select d from Utilisateur d").getResultList();
		 } 
		 	catch(Exception e)
		 	{return null;}
		 }*/
	 public Utilisateur connexion(String id,String pwd ) {
		 SessionFactory sessionFactory = new Configuration()
					.configure("hibernate.cfg.xml")
					.addAnnotatedClass(Utilisateur.class)
					.buildSessionFactory();	
		 Utilisateur u = null;
			Session session = null;
			Transaction transaction = null;
			try {
				session = sessionFactory.openSession();
				transaction = session.beginTransaction();
				org.hibernate.query.Query query = session.createQuery("from Utilisateur where Identifiant = :id and passwd=:pwd ");
				query.setParameter("id",id);
				query.setParameter("pwd",pwd);
				u = (Utilisateur) query.uniqueResult();
				System.out.println(u);
				transaction.commit();
			} catch (Exception e) {
				u= null;
				if (transaction != null) {
					transaction.rollback();
				}
			} finally {
				session.close();
			}
			return u;
			
		}
	 public Utilisateur chercherParId(String id) {
		 SessionFactory sessionFactory = new Configuration()
					.configure("hibernate.cfg.xml")
					.addAnnotatedClass(Utilisateur.class)
					.buildSessionFactory();	
		 Utilisateur u = null;
			Session session = null;
			Transaction transaction = null;
			try {
				session = sessionFactory.openSession();
				transaction = session.beginTransaction();
				org.hibernate.query.Query query = session.createQuery("from Utilisateur where Identifiant = :id ");
				query.setParameter("id",id);
				u = (Utilisateur) query.uniqueResult();
				System.out.println(u);
				transaction.commit();
			} catch (Exception e) {
				u= null;
				if (transaction != null) {
					transaction.rollback();
				}
			} finally {
				session.close();
			}
			return u;
			
		}

	 @SuppressWarnings({ "rawtypes", "unchecked" })
		public List<Utilisateur> chercherB(String keyword) {
		 SessionFactory sessionFactory = new Configuration()
					.configure("hibernate.cfg.xml")
					.addAnnotatedClass(Utilisateur.class)
					.buildSessionFactory();	
		 List<Utilisateur> listh = null;
			Session session = null;
			Transaction transaction = null;
			try {
				session = sessionFactory.openSession();
				transaction = session.beginTransaction();
				org.hibernate.query.Query query = session.createQuery("from Utilisateur where id like CONCAT('%',:keyword,'%')");
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
	
	 
	 
	/*public Utilisateur connexion(String login, String pwd ){
	 	Utilisateur ut=null;
	 	try{
	 		 ut=(Utilisateur) sesion.createQuery("select d from Utilisateur d where d.Identifiant=:par and d.passwd=:para").setParameter("par",login ).setParameter("para", pwd).getSingleResult();
	 System.out.println(ut);
	   return ut;
	 	}	catch(Exception e)
	 				{return null;}
	 	}*/
	 }
