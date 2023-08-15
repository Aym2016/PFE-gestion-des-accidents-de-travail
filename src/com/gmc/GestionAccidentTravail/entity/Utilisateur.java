package com.gmc.GestionAccidentTravail.entity;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import java.util.Collection;

@Entity
@Table(name="utilisateur")
public class Utilisateur  implements Serializable {
	//@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	@Id 
	//@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(name = "Identifiant")
	private String Identifiant=null;
	private String passwd;
	private String profil;
	private String mail;
	private Date DateCreation;
	private static final long serialVersionUID = 1L;
	@OneToMany(mappedBy="AccidentTraiter")
	private  java.util.Collection<DossierAccident> dossierAccident;
	public Utilisateur() {
		super();
	}

	public Utilisateur(String identifiant, String passwd, String profil, String mail,Collection<DossierAccident> dossierAccident, Date dateCreation) {
		super();
		this.Identifiant = identifiant;
		this.passwd = passwd;
		this.profil = profil;
		this.mail = mail;
	    this.dossierAccident=dossierAccident;
	    this.DateCreation=DateCreation;
	}  
	   
	   public Date getDateCreation() {
		return DateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		DateCreation = dateCreation;
	}

	/** @pdGenerated default getter */
	   public java.util.Collection<DossierAccident> getDossierAccident() {
	      if (dossierAccident == null)
	         dossierAccident = new java.util.HashSet<DossierAccident>();
	      return dossierAccident;
	   }
	   
	   /** @pdGenerated default iterator getter */
	   public java.util.Iterator getIteratorDossierAccident() {
	      if (dossierAccident == null)
	         dossierAccident = new java.util.HashSet<DossierAccident>();
	      return dossierAccident.iterator();
	   }
	   
	   /** @pdGenerated default setter
	     * @param newDossierAccident */
	   public void setDossierAccident(java.util.Collection<DossierAccident> newDossierAccident) {
	      removeAllDossierAccident();
	      for (java.util.Iterator iter = newDossierAccident.iterator(); iter.hasNext();)
	         addDossierAccident((DossierAccident)iter.next());
	   }
	   
	   /** @pdGenerated default add
	     * @param newDossierAccident */
	   public void addDossierAccident(DossierAccident newDossierAccident) {
	      if (newDossierAccident == null)
	         return;
	      if (this.dossierAccident == null)
	         this.dossierAccident = new java.util.HashSet<DossierAccident>();
	      if (!this.dossierAccident.contains(newDossierAccident))
	         this.dossierAccident.add(newDossierAccident);
	   }
	   
	   /** @pdGenerated default remove
	     * @param oldDossierAccident */
	   public void removeDossierAccident(DossierAccident oldDossierAccident) {
	      if (oldDossierAccident == null)
	         return;
	      if (this.dossierAccident != null)
	         if (this.dossierAccident.contains(oldDossierAccident))
	            this.dossierAccident.remove(oldDossierAccident);
	   }
	   
	   /** @pdGenerated default removeAll */
	   public void removeAllDossierAccident() {
	      if (dossierAccident != null)
	         dossierAccident.clear();
	   }
	
	public String getIdentifiant() {
		return Identifiant;
	}
	
	public void setIdentifiant(String login) {
		this.Identifiant= login;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getProfil() {
		return profil;
	}
	public void setProfil(String profil) {
		this.profil = profil;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}

	@Override
	public String toString() {
		return "Utilisateur [login=" + Identifiant + ", passwd=" + passwd + ", profil=" + profil + ", mail=" + mail + "]";
	}

	

}
