package com.gmc.GestionAccidentTravail.presentation;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.SessionScoped;

import org.primefaces.component.datatable.feature.SelectionFeature;

import com.gmc.GestionAccidentTravail.dao1.PieceDao;
import com.gmc.GestionAccidentTravail.entity.Employe;
import com.gmc.GestionAccidentTravail.entity.Piece;


@SessionScoped
public class PieceBean {
	private String inputname;
	
	public String getInputname() {
		return inputname;
	}



	public void setInputname(String inputname) {
		this.inputname = inputname;
	}
public void chercher(String enteredValue) {
		if(inputname=="") {
			this.PieceList=null;
		}else {
		this.PieceList=new ArrayList<Piece>();
		this.PieceList=be.chercherB(enteredValue);
		//System.out.println(this.listB);
		}
	     
	}
	private Piece PieceModif=new Piece();
	public Piece getPieceModif() {
		return PieceModif;
	}

	public void ajouter(){
		   be.ajouter(this.b);
		   this.b=new Piece();
	   }

	public void setPieceModif(Piece PieceModif) {
		this.PieceModif = PieceModif;
	}
	private Piece b= new Piece();
	private List<Piece> PieceList= new ArrayList<Piece>();
    private PieceDao be=new PieceDao();
    
    
	
    
   public Piece getPiece() {
		return b;
	}



	public void setPiece(Piece b) {
		this.b = b;
	}


	public void supprimer(String refPiece){
		System.out.println("la reference de Piece est "+refPiece);
		Piece Pieceselectionee=new Piece();
		Pieceselectionee=be.chercherParId(refPiece);
	   System.out.println("la reference de la piece"+Pieceselectionee.getRefPiece());	
		Pieceselectionee.setRefPiece(refPiece);
		be.supprimer(Pieceselectionee);
		
	}
	public List<Piece> getPieceList() {
		return PieceList;
	}
public PieceBean() {
	PieceDao be=new PieceDao();
	this.PieceList=be.afficher();
}


	public void setPieceList(List<Piece> LesionList) {
		this.PieceList = PieceList;
	}
}