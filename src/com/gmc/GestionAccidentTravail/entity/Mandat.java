package com.gmc.GestionAccidentTravail.entity;

//import java.util.Collection;
import java.util.Date;
import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
//import javax.persistence.MapsId;
import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.annotations.GenericGenerator;

import com.gmc.GestionAccidentTravail.Hibernate.HibernateUtil;


@Entity

@Table(name="Mandat")




public class Mandat implements Serializable{
	
	//private static final long serialVersionUID = 1L;

	
 //@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id 
	//@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(name = "IdMand")
	private String IdMand;
	
	@Temporal(TemporalType.DATE)
	private Date DateRecept;
	@Temporal(TemporalType.DATE)
	private Date DateEcheance;
	private double Montant;
	@ManyToOne
	@JoinColumn(name="ListMandat",referencedColumnName = "IdRemboursement")
	
	private Remboursement ListMandat ;
	//public java.util.Collection<Mandat>ListMandat;
	public Mandat() {
		super();
	}
	public Mandat(String idMand, Date dateRecept, Date dateEcheance, double montant,Remboursement ListMandat) {
		super();
		IdMand = idMand;
		DateRecept = dateRecept;
		DateEcheance = dateEcheance;
		Montant = montant;
		this.ListMandat=this.ListMandat;
	}
public Remboursement getListMandat() {
		return ListMandat;
	}
	public void setListMandat(Remboursement ListMandat) {
		this.ListMandat = ListMandat;
	}
	public String getIdMand() {
		return IdMand;
	}
	public void setIdMand(String idMand) {
		IdMand = idMand;
	}
	public Date getDateRecept() {
		return DateRecept;
	}
	public void setDateRecept(Date dateRecept) {
		DateRecept = dateRecept;
	}
	public Date getDateEcheance() {
		return DateEcheance;
	}
	public void setDateEcheance(Date dateEcheance) {
		DateEcheance = dateEcheance;
	}
	public double getMontant() {
		return Montant;
	}
	public void setMontant(double montant) {
		Montant = montant;
	}
	public void AjouterMandat (Mandat md) {
		Session session = HibernateUtil.currentSession();
		 Transaction tx = null;
		 try {
		 tx = session.beginTransaction(); 
		  md = new Mandat();
		 md.setIdMand("RD1234");
		 md.setMontant(7000);
		 session.save(md);
		 tx.commit();
		 }
		 catch (Exception e) {
		 if (tx != null) {
		 tx.rollback();
		 }
		 HibernateUtil.closeSession();
		 }
		 }

public void modifierMandat(Mandat md) {
    
	  Session session = HibernateUtil.currentSession();
	  Transaction tx = null;
	  try { tx = session.beginTransaction(); 
	  Integer id = new Integer(1);
	   md= (Mandat)session.load(Mandat.class,id);
	  md.setIdMand("lj123");
	  session.update(md);
	  tx.commit(); 
	  } catch (Exception e) {
	  if (tx != null) {
	  tx.rollback();
	  }
	  HibernateUtil.closeSession();
	  }
}
/*public boolean RechercherMandat(Mandat m) {
	boolean r = false;
	
	for (Mandat md :ListMandat ) {
		if(md == m) {
			r = true;
		}
	}
		
	return r;
	// TODO: implement
}*/


public void SupprimerMandat(Mandat md) {
	   Session session = HibernateUtil.currentSession();
	   Transaction tx = null;
	   try { tx = session.beginTransaction();
	   Integer id = new Integer(1);
	    md= (Mandat)session.load(Mandat.class,id);
	   session.delete(md) ; 
	   tx.commit();
	   } catch (Exception e) {
	   if (tx != null) {
	   tx.rollback();
	   HibernateUtil.closeSession();
	   }
	   }
}
}

	
	