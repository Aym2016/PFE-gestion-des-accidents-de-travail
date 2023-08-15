package com.gmc.GestionAccidentTravail.presentation;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.SessionScoped;

import com.gmc.GestionAccidentTravail.dao1.HistoriqueDao;
import com.gmc.GestionAccidentTravail.dao1.UtilisateurDao;
import com.gmc.GestionAccidentTravail.entity.Employe;
import com.gmc.GestionAccidentTravail.entity.Historique;
import com.gmc.GestionAccidentTravail.entity.Utilisateur;
@SessionScoped
public class UtilisateurBean {
	private String inputname;
	public String getInputname() {
		return inputname;
	}
	public void setInputname(String inputname) {
		this.inputname = inputname;
	}
public void chercher(String enteredValue) {
		
	   if(inputname=="") {
		this.utilisateurList=null;
	}else {
		this.utilisateurList=new ArrayList<Utilisateur>();
		this.utilisateurList=ud.chercherB(enteredValue);
		//System.out.println(this.listB);
	     }
		
	
	}

	private Utilisateur utilisateur= new Utilisateur();
	private Utilisateur utilisateurmodif=new Utilisateur();
	private List<Utilisateur> utilisateurList= new ArrayList<Utilisateur>();
    private UtilisateurDao ud=new UtilisateurDao();
	

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public Utilisateur getUtilisateurmodif() {
		return utilisateurmodif;
	}
	public void setUtilisateurmodif(Utilisateur utilisateurmodif) {
		this.utilisateurmodif = utilisateurmodif;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	public List<Utilisateur> getUtilisateurList() {
		return utilisateurList;
	}
	public void setUtilisateurList(List<Utilisateur> utilisateurList) {
		this.utilisateurList = utilisateurList;
	}
    
   public void ajouter(){
	   ud.ajouter(utilisateur);
	   this.utilisateur=new Utilisateur();
	
   } 
   public UtilisateurBean(){
   	this.utilisateurList=new ArrayList<Utilisateur>();
   	this.utilisateurList=ud.afficher();
   }
    public void allUtilisateur(){
    	this.utilisateurList=new ArrayList<Utilisateur>();
    	this.utilisateurList=ud.afficher();
    }
    public void supprimer(String identifiant){
    	Utilisateur utilisateurSelectionnee=new Utilisateur();
    	utilisateurSelectionnee=ud.chercherParId(identifiant);
    	ud.supprimer(utilisateurSelectionnee);
    }
    public void modifselect(String identifiant){
    	this.utilisateurmodif=ud.chercherParId(identifiant); 	
    }
    public void enregmodif() {
    	ud.modifier(this.utilisateurmodif);
		
	}
   
	
    
}
