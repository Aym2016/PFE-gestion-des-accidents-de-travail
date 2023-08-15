package com.gmc.GestionAccidentTravail.presentation;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.SessionScoped;

import org.primefaces.component.datatable.feature.SelectionFeature;

import com.gmc.GestionAccidentTravail.dao1.LesionDao;

import com.gmc.GestionAccidentTravail.entity.Lesion;
import com.gmc.GestionAccidentTravail.entity.Piece;


@SessionScoped
public class LesionBean {
	private String inputname;
	
	public String getInputname() {
		return inputname;
	}



	public void setInputname(String inputname) {
		this.inputname = inputname;
	}
public void chercher(String enteredValue) {
		if(inputname=="") {
			this.LesionList=null;
		}else {
		this.LesionList=new ArrayList<Lesion>();
		this.LesionList=be.chercherB(enteredValue);
		//System.out.println(this.listB);
		}
	     
	}
	private Lesion LesionModif=new Lesion();
	public Lesion getLesionModif() {
		return LesionModif;
	}



	public void setLesionModif(Lesion LesionModif) {
		this.LesionModif = LesionModif;
	}
	private Lesion b= new Lesion();
	private List<Lesion> LesionList= new ArrayList<Lesion>();
    private LesionDao be=new LesionDao();
    public void ajouter(){
		   be.ajouter(this.b);
		   this.b=new Lesion();
	   }
    
	
    
   public Lesion getLesion() {
		return b;
	}



	public void setLesion(Lesion b) {
		this.b = b;
	}


	public void supprimer(String refLes){
		System.out.println("la reference de bordereau est "+refLes);
		Lesion Lesionselectionee=new Lesion();
		Lesionselectionee=be.chercherParId(refLes);
		System.out.println("cet reference de bordereau "+Lesionselectionee.getRefles()+" existe");	
		be.supprimer(Lesionselectionee);
		
	}
	public List<Lesion> getLesionList() {
		return LesionList;
	}
public LesionBean() {
	LesionDao be=new LesionDao();
	this.LesionList=be.afficher();
}


	public void setLesionList(List<Lesion> LesionList) {
		this.LesionList = LesionList;
	}
}