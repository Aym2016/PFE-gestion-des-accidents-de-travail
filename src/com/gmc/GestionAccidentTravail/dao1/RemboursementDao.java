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
import com.gmc.GestionAccidentTravail.entity.Remboursement;


public class RemboursementDao {
	
	Session sesion=HibernateUtil.currentSession();/* private EntityManager em;
SessionFactory sessionFactory=HibernateUtil.getSessionFactory();

	 public EntityManager getEm() {
	 	if(em==null){
	 		return em=Persistence.createEntityManagerFactory("gestionaccident").createEntityManager();
	 	}
	 	return em;
	 }

	 public void setEm(EntityManager em) {
	 	this.em = em;
	 }*/
	 public void ajouter( Remboursement rm){
		 Session sesion=HibernateUtil.currentSession();
		sesion.getTransaction().begin();
	 	sesion.save(rm);
	 	sesion.getTransaction().commit();
	    sesion.close(); 	
	
	 }
	 public void supprimer(Remboursement rm){
		 Session sesion=HibernateUtil.currentSession(); 
		 sesion.getTransaction().begin();
	 	sesion.delete(rm);
	 	sesion.getTransaction().commit();
	 	sesion.close();
	 }
	 public void modifier(Remboursement rm){
		 Session sesion=HibernateUtil.currentSession();
		sesion.getTransaction().begin();
	 	sesion.merge(rm);
	 	sesion.getTransaction().commit();
	 	sesion.close();
	 
	 }
	 public Remboursement chercherParId(String id) {
		 SessionFactory sessionFactory = new Configuration()
					.configure("hibernate.cfg.xml")
					.addAnnotatedClass(Remboursement.class)
					.buildSessionFactory();	
		 Remboursement r = null;
			Session session = null;
			Transaction transaction = null;
			try {
				session = sessionFactory.openSession();
				transaction = session.beginTransaction();
				org.hibernate.query.Query query = session.createQuery("from Remboursement where IdRemboursement = :idRem");
				query.setParameter("idRem", id);
				r= (Remboursement) query.uniqueResult();
				transaction.commit();
			} catch (Exception e) {
				r= null;
				if (transaction != null) {
					transaction.rollback();
				}
			} finally {
				session.close();
			}
			return r;
		}
	 @SuppressWarnings({ "rawtypes", "unchecked" })
		public List<Remboursement> chercherB(String keyword) {
		 SessionFactory sessionFactory = new Configuration()
					.configure("hibernate.cfg.xml")
					.addAnnotatedClass(Remboursement.class)
					.buildSessionFactory();	
		 List<Remboursement> listRem = null;
			Session session = null;
			Transaction transaction = null;
			try {
				session = sessionFactory.openSession();
				transaction = session.beginTransaction();
				org.hibernate.query.Query query = session.createQuery("from Remboursement where IdRemboursement like CONCAT('%',:keyword,'%')");
				query.setParameter("keyword", keyword );
				listRem = query.list();
				System.out.println("la liste des remboursement"+listRem);
				
				transaction.commit();
				
			} catch (Exception e) {
				listRem = null;
				if (transaction != null) {
					System.out.println("pas de resultat");
					transaction.rollback();
				}
			} finally {
				session.close();
			}
			
			return listRem;
			
		}
	 @SuppressWarnings("unchecked")
	 public List<Remboursement> afficher(){
		List<Remboursement> result=null;
		 SessionFactory factory = new Configuration()
					.configure("hibernate.cfg.xml")
					.addAnnotatedClass(Remboursement.class)
					.buildSessionFactory();
		 Session session = factory.getCurrentSession();
			
			try {			
				
				// start a transaction
				session.beginTransaction();
				
				// query students
			result = session.createQuery("from Remboursement").getResultList();
				session.getTransaction().commit();
				
				System.out.println("Done!");
			}
			finally {
				factory.close();
			}
	  return result;	
	 }
	 
	
}
	 
	 
	 /*@SuppressWarnings("unchecked")
	 public List<Remboursement> afficher(){Session sesion=HibernateUtil.currentSession();
	 	try{
	 	return(List<Remboursement>) sesion.createQuery("select rm from Remboursement rm").getResultList();
	 } 
	 	catch(Exception e)
	 	{return null;}
	 }
	 public Remboursement chercherParId(String IdRem){
		 	try{
		 		return	(Remboursement) sesion.createQuery("select emp from Employe emp where emp.idr=:param").setParameter("param", IdRem).getSingleResult();
		 			 } 
		 	catch(Exception e)
		 	{return null;}}

	
	 }*/
