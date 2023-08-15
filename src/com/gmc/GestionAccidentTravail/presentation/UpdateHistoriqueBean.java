package com.gmc.GestionAccidentTravail.presentation;

import javax.faces.bean.SessionScoped;

import com.gmc.GestionAccidentTravail.dao1.HistoriqueDao;
import com.gmc.GestionAccidentTravail.entity.Historique;;
//import com.sun.javafx.scene.traversal.Hueristic2D;
@SessionScoped
public class UpdateHistoriqueBean {
	private Historique historiquemodif= new Historique();
	private Historique historiquemodif1= new Historique();
	private HistoriqueDao hd=new HistoriqueDao(); 
	public Historique historique=new Historique();
	public Historique getHistorique() {
		return historique;
	}

	public void setHistorique(Historique historique) {
		this.historique = historique;
	}

	public Historique getHistoriquemodif() {
		return historiquemodif;
	}

	public void setHistoriquemodif(Historique historiquemodif) {
		this.historiquemodif = historiquemodif;
	}
	public void modifselect(int id){
		System.out.println("modifier Historique");
		this.historiquemodif1=new Historique();
		this.historiquemodif1=hd.chercherParId(id);
		System.out.println("observation du historique= "+this.historiquemodif1.getObservation());
		
	}
	public void ajouter(){
		
		hd.ajouter(this.historique);
		this.historique=new Historique();
		
	}
	public void enregmodif(){
		hd.modifier(this.historiquemodif1);
	}

	public Historique getHistoriquemodif1() {
		return historiquemodif1;
	}

	public void setHistoriquemodif1(Historique historiquemodif1) {
		this.historiquemodif1 = historiquemodif1;
	}

}
