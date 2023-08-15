package com.gmc.GestionAccidentTravail.entity;

import java.util.Date;
import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

import java.util.*;
@Entity
@Table(name="remboursement")
public class Remboursement implements Serializable
{  //private static final long serialVersionUID = 1L;

	
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	@Id 
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(name = "IdRemboursement")
	private String id;
	private String TypeRemboursement;
	@Temporal(TemporalType.DATE)
	private Date    DateRemboursement;
	private double Montant;
	@OneToOne
	
	private DossierAccident da;
	@OneToMany(mappedBy="ListMandat")
	Collection<Mandat>ListMandat;
	
	public Remboursement() {
		super();
	}

	public Remboursement(String idRemboursement, String typeRemboursement, Date dateRemboursement, double montant,Collection<Mandat>ListMandat,
			DossierAccident da) {
		super();
		id = idRemboursement;
		TypeRemboursement = typeRemboursement;
		DateRemboursement = dateRemboursement;
		Montant = montant;
	    this.ListMandat=ListMandat;
	    this.da=da;
	}

	@Override
	public String toString() {
		return "Remboursement [id=" + id + ", TypeRemboursement=" + TypeRemboursement + ", DateRemboursement="
				+ DateRemboursement + ", Montant=" + Montant + ", da=" + da + ", ListMandat=" + ListMandat + "]";
	}

	public DossierAccident getDa() {
		return da;
	}

	public void setDa(DossierAccident da) {
		this.da = da;
	}

	public Collection<Mandat> getListMandat() {
		return ListMandat;
	}

	public void setListMandat(Collection<Mandat> listMandat) {
		ListMandat = listMandat;
	}

	public String getIdRemboursement() {
		return id;
	}

	public void setIdRemboursement(String idRemboursement) {
	   id = idRemboursement;
	}

	public String getTypeRemboursement() {
		return TypeRemboursement;
	}

	public void setTypeRemboursement(String typeRemboursement) {
		TypeRemboursement = typeRemboursement;
	}

	public Date getDateRemboursement() {
		return DateRemboursement;
	}

	public void setDateRemboursement(Date dateRemboursement) {
		DateRemboursement = dateRemboursement;
	}

	public double getMontant() {
		return Montant;
	}

	public void setMontant(double montant) {
		Montant = montant;
	}

	
	
	
	
}