package com.gmc.GestionAccidentTravail.dao1;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


import com.gmc.GestionAccidentTravail.Hibernate.HibernateUtil;
import com.gmc.GestionAccidentTravail.entity.BordereauEnvoi;
import com.gmc.GestionAccidentTravail.entity.DossierAccident;
import com.gmc.GestionAccidentTravail.entity.Employe;
import com.gmc.GestionAccidentTravail.entity.Lesion;


public class BordereauEnvoiDao {
	//SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
	//Session sesion=HibernateUtil.currentSession();
	 public EntityManager em;


	/* public EntityManager getEm() {
	 	if(em==null){
	 		return em=Persistence.createEntityManagerFactory("gestionaccident").createEntityManager();
	 	}
	 	return em;
	 }

	 public void setEm(EntityManager em) {
	 	this.em = em;
	 }*/
	 public BordereauEnvoi ajouter(BordereauEnvoi be){
		 Session sesion=HibernateUtil.currentSession();
		 sesion.getTransaction().begin();
	 	sesion.save(be);
	 	sesion.getTransaction().commit();
	 	sesion.close();
	 return be;	
	 }
	 public void supprimer(BordereauEnvoi be){
		 Session sesion=HibernateUtil.currentSession();
		sesion.getTransaction().begin();
	 	sesion.delete(be);
	 	sesion.getTransaction().commit();	
	 	sesion.close();
	 }
	 public BordereauEnvoi modifier(BordereauEnvoi be){
		 Session sesion=HibernateUtil.currentSession(); 
		sesion.getTransaction().begin();
	    sesion.merge(be);
	 	sesion.getTransaction().commit();
	 	sesion.close();
	  return be;
	 }

/*query = session.createSQLQuery("select e.emp_id, emp_name, emp_salary,address_line1, city, 
	zipcode from Employee e, Address a where a.emp_id=e.emp_id");
rows = query.list();
for(Object[] row : rows){
	Employee emp = new Employee();
	emp.setId(Long.parseLong(row[0].toString()));
	emp.setName(row[1].toString());
	emp.setSalary(Double.parseDouble(row[2].toString()));
	Address address = new Address();
	address.setAddressLine1(row[3].toString());
	address.setCity(row[4].toString());
	address.setZipcode(row[5].toString());
	emp.setAddress(address);
	System.out.println(emp);
}*/

	/* @SuppressWarnings("unchecked")
	 public List<BordereauEnvoi> afficher(){*/
	 /*@SuppressWarnings({ "rawtypes", "unchecked" })
		public List<BordereauEnvoi> afficher() {
			List<BordereauEnvoi> BorderereauEnvoiList = null;
			Session session = null;
			Transaction transaction = null;
			try {
				session = sessionFactory.openSession();
				transaction = session.beginTransaction();
				org.hibernate.query.Query query = session.createQuery("from Product");
				products = query.list();
				transaction.commit();
			} catch (Exception e) {
				products = null;
				if (transaction != null) {
					transaction.rollback();
				}
			} finally {
				session.close();
			}
			return products;
		}*//*public List<BordereauEnvoi> afficher(){
		 	try{
			 	return(List<BordereauEnvoi>) sesion.createQuery("select be from BordereauEnvoi be").getResultList();
			 } 
			 	catch(Exception e)
			 	{return null;}
			 }	*/	 
		/*@SuppressWarnings({ "rawtypes", "unchecked" })
		public List<BordereauEnvoi> afficher() {
			List<BordereauEnvoi> results ;
			Session sesion = null;
			Transaction transaction = null;
			try {
				//sesion = sessionFactory.openSession();
				transaction = sesion.beginTransaction();
				org.hibernate.query.Query query = sesion.createQuery("select be from BordereauEnvoi be");
				results = query.list();
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
		}*/@SuppressWarnings("unchecked")
		 public List<BordereauEnvoi> afficher(){
			List<BordereauEnvoi> result=null;
			 SessionFactory factory = new Configuration()
						.configure("hibernate.cfg.xml")
						.addAnnotatedClass(BordereauEnvoi.class)
						.buildSessionFactory();
			 Session session = factory.getCurrentSession();
				
				try {			
					
					// start a transaction
					session.beginTransaction();
					
					// query students
				result = session.createQuery("from BordereauEnvoi").getResultList();
					session.getTransaction().commit();
					
					System.out.println("Done!");
				}
				finally {
					factory.close();
				}
		  return result;	
		 }
		 
		 public BordereauEnvoi chercherParId(String id) {
			 List<BordereauEnvoi> result=null;
			 SessionFactory sessionFactory = new Configuration()
						.configure("hibernate.cfg.xml")
						.addAnnotatedClass(BordereauEnvoi.class)
						.buildSessionFactory();
			 BordereauEnvoi da = null;
				Session session = null;
				Transaction transaction = null;
				try {
					session = sessionFactory.openSession();
					transaction = session.beginTransaction();
					org.hibernate.query.Query query = session.createQuery("from BordereauEnvoi where RefBord = :id");
					query.setParameter("id", id);
					da= (BordereauEnvoi) query.uniqueResult();
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
			public List<BordereauEnvoi> chercherB(String keyword) {
				List<BordereauEnvoi> listBor = null;
				SessionFactory sessionFactory = new Configuration()
						.configure("hibernate.cfg.xml")
						.addAnnotatedClass(BordereauEnvoi.class)
						.buildSessionFactory();
				Session session = null;
				Transaction transaction = null;
				try {
					session = sessionFactory.openSession();
					transaction = session.beginTransaction();
					org.hibernate.query.Query query = session.createQuery("from BordereauEnvoi  where RefBord like CONCAT('%',:keyword,'%')");
					query.setParameter("keyword",  keyword );
					listBor = query.list();
					
					
					transaction.commit();
					
				} catch (Exception e) {
					listBor = null;
					if (transaction != null) {
						transaction.rollback();
					}
				} finally {
					session.close();
				}
				
				return listBor;
				
			}
		 
		 
		 
		 
		 
		 /*
				Configuration cfg=new Configuration();
				cfg.configure("hibernate.cfg.xml");
				SessionFactory factory=cfg.buildSessionFactory();
				Session session=factory.openSession();
				results= (List<BordereauEnvoi>) session.createQuery("from BordereauEnvoi be");
				
				return results;*/
				
				
				
				//Session session = null;
				/*Transaction transaction = null;
				try {
					
					transaction = sesion.beginTransaction();
					org.hibernate.query.Query query = sesion.createQuery("from bordereauenvoi be ");
					results = query.getResultList();
					System.out.println (results);
					transaction.commit();
				} catch (Exception e) {
					results = null;
					if (transaction != null) {
						transaction.rollback();
					}
				} finally {
					sesion.close();
				}
				return results;*/
	
		/*public List<BordereauEnvoi> getListBordereauEnvoi() {
			 return this.afficher();
		 }
		
		 try {
				List<BordereauEnvoi> results = sesion
						.createQuery("from  BordereauEnvoi").list();			
				return results;
					
			} catch (RuntimeException re) {
				throw re;
			
			}

	 }*/
	 
		/* try{
	 	return(List<BordereauEnvoi>) sesion.createQuery("select be from BordereauEnvoi be",BordereauEnvoi.class).getResultList();
	 			//getResultList();
	 } 
	 	catch(Exception e)
	 	{return null;}*/

	 
	 
	/* public BordereauEnvoi chercherParId(String refBord){
		 	try{
		 		return	(BordereauEnvoi) sesion.createQuery("select be from bordereau be where be.RefBord=:param").setParameter("param", refBord).getSingleResult();
		 			 } 
		 	catch(Exception e)
		 	{return null;}
		 	}*/

	
	 }
