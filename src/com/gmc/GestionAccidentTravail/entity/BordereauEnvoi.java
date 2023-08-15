package com.gmc.GestionAccidentTravail.entity;

import java.util.Collection;
import java.util.Date;
import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.annotations.GenericGenerator;
 
import com.gmc.GestionAccidentTravail.Hibernate.HibernateUtil;;




@Entity
@Table(name="bordereauenvoi")
public class BordereauEnvoi  implements Serializable{
	
	//private static final long serialVersionUID = 1L;

	
 //@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id 
	//@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")

	@Column(name = "RefBord")
    
	private  String RefBord;
	@Temporal(TemporalType.DATE)
	private Date PeriodeBord;
	private String TypeBord;
	private String DestinationBord;
	@Temporal(TemporalType.DATE)
	private Date DateEnvoi;
    
	
	@OneToMany(mappedBy="BordereauAcc")
	private java.util.Collection<DossierAccident> dossierAccident;
	
	
	//private java.util.Collection<BordereauEnvoi> bordereauEnvoi;
	public BordereauEnvoi() {
		super();
	}
	public BordereauEnvoi(String refBord, Date periodeBord, String typeBord, String destinationBord, Date dateEnvoi,
			Collection<DossierAccident> dossierAccident) {
		super();
		RefBord = refBord;
		PeriodeBord = periodeBord;
		TypeBord = typeBord;
		DestinationBord = destinationBord;
		DateEnvoi = dateEnvoi;
		
		this.dossierAccident = dossierAccident;
	}
	
	   
	  
	 public void ajouterBordereauEnvoi(BordereauEnvoi b1) {
		 Session session = HibernateUtil.currentSession();
		 Transaction tx = null;
		 try {
		 tx = session.beginTransaction(); // débuter la transaction
		 // on crée une instance de la classe de données Reservations
		  b1 = new BordereauEnvoi();
		 b1.setRefBord("B2017");
		 b1.setTypeBord("Yassine");
		 session.save(b1);
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
		 //on ajoute si bordereau d'envoi n'existe pas
			/*if(!verification(e)  ) {
				
				bordereauEnvoi.add(e);
				System.out.println("Bordereau d'envoi  a été ajouté...");
			}
			else {
				System.out.println("Bordereau d'envoi existe déja dans ce groupe");
			}*/
		
	/* public boolean  RechercherBordereauEnvoi(BordereauEnvoi b) {
			
			boolean r = false;
			
			for (BordereauEnvoi be : bordereauEnvoi) {
				if(be == b) {
					r = true;
				}
			}
				
			return r;
		}	*/
		
	 
			
			
	   
	 // a completer public modifierBordereauEnvoi() {
	      // TODO: implement
	 //  }
	 public void modifierBordereauEnvoi(BordereauEnvoi b1) {
	      // TODO: implement
		  Session session = HibernateUtil.currentSession();
		  Transaction tx = null;
		  try { tx = session.beginTransaction(); // débuter la transaction et
		  // On charge la classe de données Client dont l’identifiantest égale à 1
		  Integer id = new Integer(1);
		   b1= (BordereauEnvoi)session.load(BordereauEnvoi.class,id);
		  b1.setRefBord("lj123");//modification de la propriété //Prenom
		  session.update(b1);// sauvegarde des modifications en //mémoire
		  tx.commit(); //” commit” de la transaction et mise à jour de la BD
		  } catch (Exception e) {
		  if (tx != null) {
		  tx.rollback();// on effectue un roll back en cas //d’exception afin de garder la cohérence des données
		  }
		  HibernateUtil.closeSession();
		  }
		  }
	   
	   
	   public boolean RechercherDossierAccident(DossierAccident d) {
			boolean r = false;
			
			for (DossierAccident da : dossierAccident) {
				if(da == d) {
					r = true;
				}
			}
				
			return r;
			// TODO: implement
		}
	   
	   
	 //  public verifierConformitéDossierAccident() {
	      // TODO: implement
	 //  }
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
	         AjouterDossierAccident((DossierAccident)iter.next());
	   }
	   
	  
	   public void AjouterDossierAccident(DossierAccident newDossierAccident) {
	      if (newDossierAccident == null)
	         return;
	      if (this.dossierAccident == null)
	         this.dossierAccident = new java.util.HashSet<DossierAccident>();
	      if (!this.dossierAccident.contains(newDossierAccident))
	         this.dossierAccident.add(newDossierAccident);
	   }
	   
	   
	   public void supprimerDossierAccident(DossierAccident oldDossierAccident) {
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
	public String getRefBord() {
		return RefBord;
	}
	public void setRefBord(String refBord) {
		RefBord = refBord;
	}
	
		public Date getPeriodeBord() {
		return PeriodeBord;
	}
	public void setPeriodeBord(Date periodeBord) {
		PeriodeBord = periodeBord;
	}
		public String getTypeBord() {
		return TypeBord;
	}
	public void setTypeBord(String typeBord) {
		TypeBord = typeBord;
	}
	public String getDestinationBord() {
		return DestinationBord;
	}
	public void setDestinationBord(String destinationBord) {
		DestinationBord = destinationBord;
	}
	public Date getDateEnvoi() {
		return DateEnvoi;
	}
	public void setDateEnvoi(Date dateEnvoi) {
		DateEnvoi = dateEnvoi;
	}
	@Override
	public String toString() {
		return "Bordereau d'envoi [RefBord=" + RefBord + ", PeriodeBord=" + PeriodeBord + ", TypeBord=" + TypeBord
				+ ", DestinationBord=" + DestinationBord + ", DateEnvoi=" + DateEnvoi + "]";
	}
	

}
