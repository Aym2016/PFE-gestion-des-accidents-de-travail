package com.gmc.GestionAccidentTravail.entity;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.annotations.GenericGenerator;

import com.gmc.GestionAccidentTravail.Hibernate.HibernateUtil;

import java.util.Collection;
import java.util.Date;
@Entity
@Table(name="DossierAccident")
public class DossierAccident implements Serializable{

//private static final long serialVersionUID = 1L;

	
 //@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id 
	//@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(name = "IdAcc")
	private String IdAcc;
@Temporal(TemporalType.DATE)
private Date DateAcc;
private int NbrJourRepos;
@Temporal(TemporalType.DATE)
private Date DateSaisie;
@Temporal(TemporalType.DATE)
private Date DateReprise;
private String TypeA;
private String CauseA;
private String etat;
@OneToOne
@JoinColumn(name="IdRemboursement")
public Remboursement remboursement;

@JoinColumn(name ="EmployeMat",referencedColumnName = "MatriculeEmp")
@ManyToOne
private Employe EmployeMat;
@JoinColumn(name="BordereauAcc",referencedColumnName="RefBord")
@ManyToOne
private BordereauEnvoi BordereauAcc;
@OneToMany(mappedBy ="DossierLesion")
private java.util.Collection<Lesion> lesion;
@OneToMany(mappedBy="DossierPiece")
private java.util.Collection<Piece> piece;
//@JoinColumn(name="EmployeDossier",referencedColumnName="ID")
//@ManyToOne
//private Employe employe;
//@JoinColumn(name="EmployeDossier",referencedColumnName="ID")
//@ManyToOne

@JoinColumn(name="AccidentTraiter",referencedColumnName = "")
@ManyToOne
private Utilisateur AccidentTraiter;
//@OneToMany(mappedBy="EmployeAccH")
//public java.util.Collection<Historique>ListHistorique;

//public java.util.Collection<DossierAccident>dossierAccident;

//@OneToMany(mappedBy="DossierListMandat")
//public java.util.Collection<Mandat>ListMandat;
public DossierAccident(String idAcc, Date dateAcc, int nbrJourRepos, Date dateSaisie, Date dateReprise, String typeA,
		String causeA, String etat, Remboursement remboursement,Utilisateur accidentTraiter,Employe em, Collection<Lesion> lesion, Collection<Piece> piece
		/*Collection<Mandat>ListMandat*/) {
	super();
	IdAcc = idAcc;
	DateAcc = dateAcc;
	NbrJourRepos = nbrJourRepos;
	DateSaisie = dateSaisie;
	DateReprise = dateReprise;
	TypeA = typeA;
	CauseA = causeA;
	this.etat = etat;
	this.remboursement = remboursement;
	this.lesion = lesion;
	this.piece = piece;
    this.AccidentTraiter=accidentTraiter;
	this.EmployeMat=em;
    /*this.ListMandat=ListMandat; */
}
	
public DossierAccident() {
	super();
}

public BordereauEnvoi getBordereauAcc() {
	return BordereauAcc;
}
public void setBordereauAcc(BordereauEnvoi bordereauAcc) {
	BordereauAcc = bordereauAcc;
}
	public Utilisateur getAccidentTraiter() {
	return AccidentTraiter;
}
public void setAccidentTraiter(Utilisateur accidentTraiter) {
	AccidentTraiter = accidentTraiter;
}
	/*public java.util.Collection<Mandat> getListMandat() {
	return ListMandat;
}*/
public Remboursement getRemboursement() {
	return remboursement;
}
public void setRemboursement(Remboursement remboursement) {
	this.remboursement = remboursement;
}
public Employe getEm() {
	return EmployeMat;
}
public void setEm(Employe em) {
	this.EmployeMat = em;
}
public Utilisateur getUt() {
	return AccidentTraiter;
}
public void setUt(Utilisateur ut) {
	this.AccidentTraiter = ut;
}
//public java.util.Collection<Historique> getListHistorique() {
	//return ListHistorique;
//}
//public void setListHistorique(java.util.Collection<Historique> listHistorique) {
	//ListHistorique = listHistorique;
//}
/*public java.util.Collection<DossierAccident> getDossierAccident() {
	return dossierAccident;
}
public void setDossierAccident(java.util.Collection<DossierAccident> dossierAccident) {
	this.dossierAccident = dossierAccident;
}
public java.util.Collection<Mandat> getListMandat() {
	return ListMandat;
}*/
/*public void setListMandat(java.util.Collection<Mandat> listMandat) {
	ListMandat = listMandat;
}*/
	
	
	public void AjouterDossierAccident (DossierAccident da) {
		Session session = HibernateUtil.currentSession();
		 Transaction tx = null;
		 try {
		 tx = session.beginTransaction(); // débuter la transaction
		 // on crée une instance de la classe de données Reservations
		  da = new DossierAccident();
		 da.setIdAcc("Anathony");
		 da.setCauseA("Mark");
		 session.save(da);
		 tx.commit();// ” commit” de la transaction
		 }
		 catch (Exception e) {
		 if (tx != null) {
		 tx.rollback();// on effectue un roll back en cas d’exception
		 // afin de garder la cohérence des données
		 }
		 HibernateUtil.closeSession();// fermeture de la session hibernate
		 }
		 }
	/*public void AjouterDossierAccident(DossierAccident newDossierAccident) {
	      if (newDossierAccident == null)
	         return;
	      if (this.dossierAccident == null)
	         this.dossierAccident = new java.util.HashSet<DossierAccident>();
	      if (!this.dossierAccident.contains(newDossierAccident))
	         this.dossierAccident.add(newDossierAccident);
	   }
		/** @pdOid c6fc2d85-f9ab-4cfa-b6b3-5e6cc53123a0 */
		/*public boolean RechercherDossierAccident(DossierAccident d) {
			boolean r = false;
			
			for (DossierAccident da : dossierAccident) {
				if(da == d) {
					r = true;
				}
			}
				
			return r;
			// TODO: implement
		}*/

		 public void modifierDossierAccident(DossierAccident da) {
		      // TODO: implement
			  Session session = HibernateUtil.currentSession();
			  Transaction tx = null;
			  try { tx = session.beginTransaction(); // débuter la transaction et
			  // On charge la classe de données Client dont l’identifiantest égale à 1
			  Integer id = new Integer(1);
			   da= (DossierAccident)session.load(DossierAccident.class,id);
			  da.setIdAcc("lj123");//modification de la propriété //Prenom
			  session.update(da);// sauvegarde des modifications en //mémoire
			  tx.commit(); //” commit” de la transaction et mise à jour de la BD
			  } catch (Exception e) {
			  if (tx != null) {
			  tx.rollback();// on effectue un roll back en cas //d’exception afin de garder la cohérence des données
			  }
			  HibernateUtil.closeSession();
			  }
			  }
		
		
		
		/** @pdOid bb17c8a2-3a97-430b-a42c-39c9ba9e53d0 */
		/*public DossierAccident ModifierDossierAccident() {
		   // TODO: implement
		}

		/** @pdOid 09841a72-c5f0-4509-b5ed-aebb120898e4 */
	/*	public VerifierConformiteDossierAccident() {
		   // TODO: implement
		}


		/** @pdGenerated default getter */
		public java.util.Collection<Lesion> getLesion() {
		   if (lesion == null)
		      lesion = new java.util.HashSet<Lesion>();
		   return lesion;
		}

		/** @pdGenerated default iterator getter */
		public java.util.Iterator getIteratorLesion() {
		   if (lesion == null)
		      lesion = new java.util.HashSet<Lesion>();
		   return lesion.iterator();
		}

		/** @pdGenerated default setter
		  * @param newLesion */
		public void setLesion(java.util.Collection<Lesion> newLesion) {
		   removeAllLesion();
		   for (java.util.Iterator iter = newLesion.iterator(); iter.hasNext();)
		      addLesion((Lesion)iter.next());
		}

		/** @pdGenerated default add
		  * @param newLesion */
		public void addLesion(Lesion newLesion) {
		   if (newLesion == null)
		      return;
		   if (this.lesion == null)
		      this.lesion = new java.util.HashSet<Lesion>();
		   if (!this.lesion.contains(newLesion))
		      this.lesion.add(newLesion);
		}

		/** @pdGenerated default remove
		  * @param oldLesion */
		public void removeLesion(Lesion oldLesion) {
		   if (oldLesion == null)
		      return;
		   if (this.lesion != null)
		      if (this.lesion.contains(oldLesion))
		         this.lesion.remove(oldLesion);
		}

		/** @pdGenerated default removeAll */
		public void removeAllLesion() {
		   if (lesion != null)
		      lesion.clear();
		}
		/** @pdGenerated default getter */
		
		
		/** @pdGenerated default getter */
		public java.util.Collection<Piece> getPiece() {
		   if (piece == null)
		      piece = new java.util.HashSet<Piece>();
		   return piece;
		}

		/** @pdGenerated default iterator getter */
		public java.util.Iterator getIteratorPiece() {
		   if (piece == null)
		      piece = new java.util.HashSet<Piece>();
		   return piece.iterator();
		}

		/** @pdGenerated default setter
		  * @param newPiece */
		public void setPiece(java.util.Collection<Piece> newPiece) {
		   removeAllPiece();
		   for (java.util.Iterator iter = newPiece.iterator(); iter.hasNext();)
		      addPiece((Piece)iter.next());
		}

		/** @pdGenerated default add
		  * @param newPiece */
		public void addPiece(Piece newPiece) {
		   if (newPiece == null)
		      return;
		   if (this.piece == null)
		      this.piece = new java.util.HashSet<Piece>();
		   if (!this.piece.contains(newPiece))
		      this.piece.add(newPiece);
		}

		/** @pdGenerated default remove
		  * @param oldPiece */
		public void removePiece(Piece oldPiece) {
		   if (oldPiece == null)
		      return;
		   if (this.piece != null)
		      if (this.piece.contains(oldPiece))
		         this.piece.remove(oldPiece);
		}

		/** @pdGenerated default removeAll */
		public void removeAllPiece() {
		   if (piece != null)
		      piece.clear();
		}


public String getIdAcc() {
	return IdAcc;
}
public void setIdAcc(String idAcc) {
	IdAcc = idAcc;
}
public Date getDateAcc() {
	return DateAcc;
}
public void setDateAcc(Date dateAcc) {
	DateAcc = dateAcc;
}
public int getNbrJourRepos() {
	return NbrJourRepos;
}
public void setNbrJourRepos(int nbrJourRepos) {
	NbrJourRepos = nbrJourRepos;
}
public Date getDateSaisie() {
	return DateSaisie;
}
public void setDateSaisie(Date dateSaisie) {
	DateSaisie = dateSaisie;
}
public Date getDateReprise() {
	return DateReprise;
}
public void setDateReprise(Date dateReprise) {
	DateReprise = dateReprise;
}
public String getTypeA() {
	return TypeA;
}
public void setTypeA(String typeA) {
	TypeA = typeA;
}
public String getCauseA() {
	return CauseA;
}
public void setCauseA(String causeA) {
	CauseA = causeA;
}
public String getEtat() {
	return etat;
}
public void setEtat(String etat) {
	this.etat = etat;
}
@Override
public String toString() {
	return "DossierAccident [IdAcc=" + IdAcc + ", DateAcc=" + DateAcc + ", NbrJourRepos=" + NbrJourRepos + ", DateSaisie="
			+ DateSaisie + ", DateReprise=" + DateReprise + ", TypeA=" + TypeA + ", CauseA=" + CauseA + ", etat=" + etat
			+ "]";
}


}

