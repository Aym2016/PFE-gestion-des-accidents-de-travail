package com.gmc.GestionAccidentTravail.presentation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.SessionScoped;

import com.gmc.GestionAccidentTravail.dao1.HistoriqueDao;
import com.gmc.GestionAccidentTravail.entity.Employe;
import com.gmc.GestionAccidentTravail.entity.Historique;
//import com.gmc.GestionAccidentTravail.dao.entity.Remboursement;

@SessionScoped
public class HistoriqueBean {
	private int inputname;
	public int getInputname() {
		return inputname;
	}


	public void setInputname(int inputname) {
		this.inputname = inputname;
	}
	private Historique historique= new Historique();
	private Historique historiquemodif= new Historique();
	private List<Historique> HistoriqueList= new ArrayList<Historique>();
	private HistoriqueDao hd=new HistoriqueDao();
	
	
	public Historique getHistorique() {
		return historique;
	}


	public void setHistorique(Historique historique) {
		this.historique = historique;
	}


	public List<Historique> getHistoriqueList() {
		return HistoriqueList;
	}


	public void setHistoriqueList(List<Historique> historiqueList) {
		HistoriqueList = historiqueList;
	}

public void chercher(int enteredValue) {
		
		this.HistoriqueList=new ArrayList<Historique>();
		this.HistoriqueList=hd.chercherB(enteredValue);
		//System.out.println(this.listB);
		
		
	
	}

	public void ajouter(){
	
		hd.ajouter(this.historique);
		this.historique=new Historique();
		
	}
	public void allHistorique(){
		this.HistoriqueList=new ArrayList<Historique>();
		this.HistoriqueList=hd.afficher();
	}
	public HistoriqueBean(){
		this.HistoriqueList=new ArrayList<Historique>();
		this.HistoriqueList=hd.afficher();
	}
	
	
public void supprimer(int idhist){
	Historique historiqueselectionee=new Historique();
	historiqueselectionee=hd.chercherParId(idhist);
	hd.supprimer(historiqueselectionee);
	}


public Historique getHistoriquemodif() {
	return historiquemodif;
}


public void setHistoriquemodif(Historique historiquemodif) {
	this.historiquemodif = historiquemodif;
}
public void modifselect(int id){
		this.historiquemodif=hd.chercherParId(id);
	
}
public void enregmodif(){
	hd.modifier(this.historiquemodif);
}
	
}


