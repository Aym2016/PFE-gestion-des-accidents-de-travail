package com.gmc.GestionAccidentTravail.entity;

import java.util.Date;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Collection;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.gmc.GestionAccidentTravail.Hibernate.HibernateUtil;


import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
@Table(name="employe")
public class Employe implements Serializable{
	//private static final long serialVersionUID = 1L;

	@Id
 //@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private int MatriculeEmp;
	private String NomEmp;
	private String PrenomEmp;
	private String SexeEmp;
	private String SituationFamiEmp;
	@Temporal(TemporalType.DATE)
	private Date DateNaissEmp;
	private String LieuNaissEmp;
	private String ProfessionEmp;
	private String NatureActEmp;
	@Temporal(TemporalType.DATE)
	private Date  DateRecrutEmp;
	@OneToMany(mappedBy="EmployeMat")
	private java.util.Collection<DossierAccident> dossierAccident;
	
	@OneToMany(mappedBy="employeH")
	private  java.util.Collection<Historique> Historique;
	//public java.util.Collection<Employe>ListEmploye;   
	public Employe() {
		super();
	}
	public Employe(int matriculeEmp, String nomEmp, String prenomEmp, String sexeEmp, String situationFamiEmp,
			Date dateNaissEmp, String lieuNaissEmp, String professionEmp, String natureActEmp, Date dateRecrutEmp,Collection<DossierAccident>dossierAccident) {
		super();
		MatriculeEmp = matriculeEmp;
		NomEmp = nomEmp;
		PrenomEmp = prenomEmp;
		SexeEmp = sexeEmp;
		SituationFamiEmp = situationFamiEmp;
		DateNaissEmp = dateNaissEmp;
		LieuNaissEmp = lieuNaissEmp;
		ProfessionEmp = professionEmp;
		NatureActEmp = natureActEmp;
		DateRecrutEmp = dateRecrutEmp;
		this.dossierAccident=dossierAccident;
	}
	public void AjouterEmploye (Employe em) {
		Session session = HibernateUtil.currentSession();
		 Transaction tx = null;
		 try {
		 tx = session.beginTransaction(); 
		  em = new Employe();
		 em.setNomEmp("Anathony");
		 em.setPrenomEmp("Mark");
		 session.save(em);
		 tx.commit();
		 }
		 catch (Exception e) {
		 if (tx != null) {
		 tx.rollback();
		 }
		 HibernateUtil.closeSession();
		 }
		 }
		
		/*if(!RechercherEmploye(e) ) {
			
			ListEmploye.add(e);
			System.out.println("L'employe a ete ajoute...");
		}
		else {
			System.out.println("L'employe existe deja dans ce groupe");
		}
	}*/
	   
	  
	  public void modifierEmploye(Employe em) {
	      // TODO: implement
		  Session session = HibernateUtil.currentSession();
		  Transaction tx = null;
		  try { tx = session.beginTransaction(); 
		  Integer id = new Integer(1);
		   em= (Employe)session.load(Employe.class,id);
		  em.setPrenomEmp("MALAK");
		  tx.commit(); 
		  } catch (Exception e) {
		  if (tx != null) {
		  tx.rollback();
		  }
		  HibernateUtil.closeSession();
		  }
		  }
	   
	  
	   
	  
	   public void SupprimerEmploye(Employe em) {
		   Session session = HibernateUtil.currentSession();
		   Transaction tx = null;
		   try { tx = session.beginTransaction();
		   
		   Integer id = new Integer(1);
		    em= (Employe)session.load(Employe.class,id);
		   session.delete(em) ; 
		   tx.commit();
		   } catch (Exception e) {
		   if (tx != null) {
		   tx.rollback();
		   HibernateUtil.closeSession();
		   }
		   }
			/*if(RechercherEmploye(e)) {
				System.out.println("L'employe existe deja");
				ListEmploye.remove(e);
				System.out.println("employe supprimé");
			}
			else {
				System.out.println("L'employe n'existe pas");
			}*/
		}
	   /*public boolean RechercherEmploye(Employe e) {
			boolean r = false;
			
			for (Employe em :ListEmploye ) {
				if(em == e) {
					r = true;
				}
			}
				
			return r;
			// TODO: implement
		}*/
	   public java.util.Collection<DossierAccident> getDossierAccident() {
	      if (dossierAccident == null)
	         dossierAccident = new java.util.HashSet<DossierAccident>();
	      return dossierAccident;
	   }
	   
	   
	   public java.util.Iterator getIteratorDossierAccident() {
	      if (dossierAccident == null)
	         dossierAccident = new java.util.HashSet<DossierAccident>();
	      return dossierAccident.iterator();
	   }
	   
	   
	   
	   public void setDossierAccident(java.util.Collection<DossierAccident> newDossierAccident) {
	      removeAllDossierAccident();
	      for (java.util.Iterator iter = newDossierAccident.iterator(); iter.hasNext();)
	         addDossierAccident((DossierAccident)iter.next());
	   }
	   
	   
	     
	   public void addDossierAccident(DossierAccident newDossierAccident) {
	      if (newDossierAccident == null)
	         return;
	      if (this.dossierAccident == null)
	         this.dossierAccident = new java.util.HashSet<DossierAccident>();
	      if (!this.dossierAccident.contains(newDossierAccident))
	         this.dossierAccident.add(newDossierAccident);
	   }
	   
	   
	   
	   public void removeDossierAccident(DossierAccident oldDossierAccident) {
	      if (oldDossierAccident == null)
	         return;
	      if (this.dossierAccident != null)
	         if (this.dossierAccident.contains(oldDossierAccident))
	            this.dossierAccident.remove(oldDossierAccident);
	   }
	   
	   
	   public void removeAllDossierAccident() {
	      if (dossierAccident != null)
	         dossierAccident.clear();
	   }

	
	public int getMatriculeEmp() {
		return MatriculeEmp;
	}
	public void setMatriculeEmp(int matriculeEmp) {
		MatriculeEmp = matriculeEmp;
	}
	public String getNomEmp() {
		return NomEmp;
	}
	public void setNomEmp(String nomEmp) {
		NomEmp = nomEmp;
	}
	public String getPrenomEmp() {
		return PrenomEmp;
	}
	public void setPrenomEmp(String prenomEmp) {
		PrenomEmp = prenomEmp;
	}
	public String getSexeEmp() {
		return SexeEmp;
	}
	public void setSexeEmp(String sexeEmp) {
		SexeEmp = sexeEmp;
	}
	public String getSituationFamiEmp() {
		return SituationFamiEmp;
	}
	public void setSituationFamiEmp(String situationFamiEmp) {
		SituationFamiEmp = situationFamiEmp;
	}
	public Date getDateNaissEmp() {
		return DateNaissEmp;
	}
	public void setDateNaissEmp(Date dateNaissEmp) {
		DateNaissEmp = dateNaissEmp;
	}
	public String getLieuNaissEmp() {
		return LieuNaissEmp;
	}
	public void setLieuNaissEmp(String lieuNaissEmp) {
		LieuNaissEmp = lieuNaissEmp;
	}
	public String getProfessionEmp() {
		return ProfessionEmp;
	}
	public void setProfessionEmp(String professionEmp) {
		ProfessionEmp = professionEmp;
	}
	public String getNatureActEmp() {
		return NatureActEmp;
	}
	public void setNatureActEmp(String natureActEmp) {
		NatureActEmp = natureActEmp;
	}
	public Date getDateRecrutEmp() {
		return DateRecrutEmp;
	}
	public void setDateRecrutEmp(Date dateRecrutEmp) {
		DateRecrutEmp = dateRecrutEmp;
	}
	@Override
	public String toString() {
		return "Employe [MatriculeEmp=" + MatriculeEmp + ", NomEmp=" + NomEmp + ", PrenomEmp=" + PrenomEmp
				+ ", SexeEmp=" + SexeEmp + ", SituationFamiEmp=" + SituationFamiEmp + ", DateNaissEmp=" + DateNaissEmp
				+ ", LieuNaissEmp=" + LieuNaissEmp + ", ProfessionEmp=" + ProfessionEmp + ", NatureActEmp="
				+ NatureActEmp + ", DateRecrutEmp=" + DateRecrutEmp + "]";
	}
	
	
	
	
	

}
