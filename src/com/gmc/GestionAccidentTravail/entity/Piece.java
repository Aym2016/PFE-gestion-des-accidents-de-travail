package com.gmc.GestionAccidentTravail.entity;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import java.util.*;

@Entity
@Table(name="Piece")
public class Piece implements Serializable{
	//private static final long serialVersionUID = 1L;

	//@Id
 //@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id 
	//@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(name = "RefPiece")
	private String RefPiece;
private String IntitulePiece;

@JoinColumn(name="DossierPiece",referencedColumnName = "IdAcc")
@ManyToOne

private DossierAccident DossierPiece;


public Piece() {
	super();
}
public Piece(String refPiece, String intitulePiece,DossierAccident DossierPiece) {
	super();
	RefPiece = refPiece;
	IntitulePiece = intitulePiece;
    this.DossierPiece=DossierPiece;
    		
}
public String getRefPiece() {
	return RefPiece;
}
public void setRefPiece(String refPiece) {
	RefPiece = refPiece;
}
public String getIntitulePiece() {
	return IntitulePiece;
}
public void setIntitulePiece(String intitulePiece) {
	IntitulePiece = intitulePiece;
}

public DossierAccident getDossierPiece() {
	return DossierPiece;
}
public void setDossierPiece(DossierAccident dossierPiece) {
	DossierPiece = dossierPiece;
}
@Override
public String toString() {
	return "Piece [RefPiece=" + RefPiece + ", IntitulePiece=" + IntitulePiece + "]";
}


}
