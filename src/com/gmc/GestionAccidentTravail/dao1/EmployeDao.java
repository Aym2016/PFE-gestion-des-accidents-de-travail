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
import com.gmc.GestionAccidentTravail.entity.Lesion;


public class EmployeDao {
	//SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
	//Session sesion=HibernateUtil.currentSession();
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
	 public void ajouter( Employe emp){
		 Session sesion=HibernateUtil.currentSession();
		 sesion.getTransaction().begin();
	 	sesion.save(emp);
	 	sesion.getTransaction().commit();
	 	sesion.close();
	 	
	 }
/*	public void supprimer(int matriculeEmp) {
	 SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employe.class)
				.buildSessionFactory();

// create session

	 Session session = factory.getCurrentSession();

try {								


// now get a new session and start transaction
session = factory.getCurrentSession();
session.beginTransaction();

// retrieve student based on the id: primary key
System.out.println("\nGetting student with id: " + matriculeEmp);

 Employe e=null;
e = session.get(Employe.class,matriculeEmp);

// delete the student
// System.out.println("Deleting student: " + myStudent);
// session.delete(myStudent);

// delete student id=2
System.out.println("Deleting student id="+matriculeEmp);

org.hibernate.query.Query query=session.createQuery("delete from Student where MatriculeEmp= :id");
query.executeUpdate();
query.setParameter("id", matriculeEmp);
// commit the transaction
session.getTransaction().commit();

System.out.println("Done!");
}
finally {
factory.close();
}
	}*/
	 /*public boolean supprimer(Employe emp) {
			boolean result = true;
			Session session = null;
			Transaction transaction = null;
			try {
				session = sessionFactory.openSession();
				transaction = session.beginTransaction();
				session.delete(emp);
				System.out.println("suppression avec succées");
				transaction.commit();
			} catch (Exception e) {
				result = false;
				if (transaction != null) {
					transaction.rollback();
				}
			} finally {
				session.close();
			}
			return result;
		}*/
	  public void supprimer(Employe emp){
		 Session sesion=HibernateUtil.currentSession();
		 sesion.getTransaction().begin();			
		sesion.delete(emp);
	 	sesion.getTransaction().commit();
	 	sesion.close();
	 	
	 }
	 public Employe modifier(Employe emp){
		Session sesion=HibernateUtil.currentSession(); 
		sesion.getTransaction().begin();
	 	sesion.merge(emp);
	 	sesion.getTransaction().commit();
	 	sesion.close();
     return emp;	 
	 }
	 @SuppressWarnings("unchecked")
	 public List<Employe> afficher(){
		List<Employe> EmployeList=null;
		 SessionFactory factory = new Configuration()
					.configure("hibernate.cfg.xml")
					.addAnnotatedClass(Employe.class)
					.buildSessionFactory();
		 Session session = factory.getCurrentSession();
			
			try {			
				
				// start a transaction
				session.beginTransaction();
				
				
			EmployeList = session.createQuery("from Employe").getResultList();
				session.getTransaction().commit();
				
				System.out.println("Done!");
			}
			finally {
				factory.close();
			}
	  return EmployeList;	
	 }
				
		/* 
		  List<Employe> results = null;
			Session session = null;
			Transaction transaction = null;
			try {
				session = sessionFactory.openSession();
				transaction = session.beginTransaction();
				org.hibernate.query.Query query = session.createQuery("from employe");
				results = query.getResultList();
				transaction.commit();
			} catch (Exception e) {
				results = null;
				if (transaction != null) {
					transaction.rollback();
				}
			} finally {
				session.close();
			}
			return results;
}
}*/
/*try{
	 	return(List<Employe>) sesion.createQuery("select emp from Employe emp").getResultList();
	 } 
	 	catch(Exception e)
	 	{return null;}*/
	// }
	/* public Employe chercherParId(int MatriculeEmp){
		 SessionFactory factory = new Configuration()
					.configure("hibernate.cfg.xml")
					.addAnnotatedClass(Employe.class)
					.buildSessionFactory();
		factory.openSession();
		 Session session = factory.getCurrentSession();
			
		 Employe emp=new Employe();
			try {			
				
				// start a transaction
				session.getTransaction().begin();
				
		 			emp=(Employe) sesion.createQuery("select emp from Employe emp where emp.matriculeEmp=:param").setParameter("param", MatriculeEmp).getSingleResult();
                    
		 			session.getTransaction().commit();
				
				System.out.println("Done!");
			}
			finally {
				factory.close();
			}
	return emp;
	 }*/
	 
	 //@SuppressWarnings({ "rawtypes"})
		public Employe chercherParId(int MatriculeEmp) {
			Employe emp = null;
			 SessionFactory sessionFactory = new Configuration()
						.configure("hibernate.cfg.xml")
						.addAnnotatedClass(Employe.class)
						.buildSessionFactory();
			Session session = null;
			Transaction transaction = null;
			try {
				session = sessionFactory.openSession();
				transaction = session.beginTransaction();
				org.hibernate.query.Query query = session.createQuery("from Employe where MatriculeEmp = :MatriculeEmp");
				query.setParameter("MatriculeEmp", MatriculeEmp);
				emp = (Employe) query.uniqueResult();
				System.out.println(emp);
				transaction.commit();
			} catch (Exception e) {
				emp= null;
				if (transaction != null) {
					transaction.rollback();
				}
			} finally {
				session.close();
			}
			return emp;
			
		}
		@SuppressWarnings({ "rawtypes", "unchecked" })
		public List<Employe> chercherB(int keyword) {
			List<Employe> listEm = null;
			 SessionFactory sessionFactory = new Configuration()
						.configure("hibernate.cfg.xml")
						.addAnnotatedClass(Employe.class)
						.buildSessionFactory();
			Session session = null;
			Transaction transaction = null;
			try {
				session = sessionFactory.openSession();
				transaction = session.beginTransaction();
				org.hibernate.query.Query query = session.createQuery(" from Employe where MatriculeEmp like CONCAT('%',:keyword,'%')");
				query.setParameter("keyword", keyword );
				listEm = query.list();
				System.out.println("la liste des employes"+listEm);
				
				transaction.commit();
				
			} catch (Exception e) {
				listEm = null;
				if (transaction != null) {
					transaction.rollback();
				}
			} finally {
				session.close();
			}
			
			return listEm;
			
		}
}
	/* public Employe chercherParId(int MatriculeEmp){
		 SessionFactory factory = new Configuration()
					.configure("hibernate.cfg.xml")
					.addAnnotatedClass(Employe.class)
					.buildSessionFactory();	
		 Session session=sessionFactory.getCurrentSession();
		 Employe em=new Employe();
		 try{
			 session.beginTransaction();
		 		em=	(Employe) session.createQuery("select em from Employe em where em.MatriculeEmp=:param").setParameter("param", MatriculeEmp).getSingleResult();
		 			System.out.println(em);
		 			session.getTransaction().commit();
		 return em;
		 } 
		 	catch(Exception e)
		 	{return null;}}

	
	 }*/
	 

