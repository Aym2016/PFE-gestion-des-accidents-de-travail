package com.gmc.GestionAccidentTravail.presentation;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;


import org.primefaces.component.datatable.feature.SelectionFeature;

import com.gmc.GestionAccidentTravail.dao1.DossierAccidentDao;
import com.gmc.GestionAccidentTravail.dao1.EmployeDao;
import com.gmc.GestionAccidentTravail.dao1.LesionDao;
import com.gmc.GestionAccidentTravail.entity.BordereauEnvoi;
import com.gmc.GestionAccidentTravail.entity.DossierAccident;
import com.gmc.GestionAccidentTravail.entity.Employe;
import com.gmc.GestionAccidentTravail.entity.Lesion;

@SessionScoped

public class  DossierAccidentBean {
	private String inputname;
	private DossierAccident dossierAccidentModif=new DossierAccident();
	private DossierAccident Dossier=new DossierAccident();
	public String getInputname() {
		return inputname;
	}



	public void setInputname(String inputname) {
		this.inputname = inputname;
	}


public void chercher(String enteredValue) {
	    if(inputname=="") {
		this.DossierAccidentList=null;
	    }else {
		this.DossierAccidentList=new ArrayList<DossierAccident>();
		this.DossierAccidentList=dad.chercherB(enteredValue);
		//System.out.println(this.listB);
	    }
	
	}
	public DossierAccident getDossierAccidentModif() {
		return dossierAccidentModif;
	}



	public void setDossierAccidentModif(DossierAccident dossierAccidentModif) {
		this.dossierAccidentModif = dossierAccidentModif;
	}
	private DossierAccident da= new DossierAccident();
	private List<DossierAccident> DossierAccidentList= new ArrayList<DossierAccident>();
    private DossierAccidentDao dad=new DossierAccidentDao();
    private LesionDao ld=new LesionDao(); 
    
	
    
   public DossierAccident getDossierAccident() {
		return Dossier ;
	}



	public void setDossierAccident(DossierAccident Dossier) {
		this.Dossier = Dossier;
	}



	public List<DossierAccident> getDossierAccidentList() {
		return DossierAccidentList;
	}
	
public DossierAccidentBean() {
	/*DossierAccidentDao emp=new DossierAccidentDao();
	this.DossierAccidentList=emp.afficher();*/
}

public void Ajouter(Lesion e) {
	ld.ajouter(e);
}
public void AjouterLesion(String ch1,String ch2,String ch3) {
	ld.AjouterLesion(ch1, ch2, ch3);
}
	public void setDossierAccidentList(List<DossierAccident> DossierAccidentList) {
		this.DossierAccidentList = DossierAccidentList;
	}


	/*public String save() {
		ProductModel productModel = new ProductModel();
		productModel.create(this.product);
		return "success?faces-redirect=true";
	}*/
/*public void ajouter(){
	EmployeDao emp=new EmployeDao();
	  emp.ajouter(this.Emp);
   } */
	public void ajouter(){
		   dad.ajouter(this.Dossier);
		   this.Dossier=new  DossierAccident();
	   } 
public void allDossierAccident(){
	this.DossierAccidentList=new ArrayList< DossierAccident>();
	this.DossierAccidentList=dad.afficher();
}
public void supprimerDossierAccident(String idAcc){
	System.out.println("ID accident est  "+idAcc);
	DossierAccident DossierAccidentselectionee=new DossierAccident();
	DossierAccidentselectionee=dad.chercherParId(idAcc);
	System.out.println("Dossier Accident avec cet Id existe et voila"+ DossierAccidentselectionee.getIdAcc());	
	dad.supprimer(DossierAccidentselectionee);
	
}
public void Modifselect(String id){
	this.dossierAccidentModif=dad.chercherParId(id);
	
}

public void enregistrermodif(){
	dad.modifier(this.dossierAccidentModif);
}
}

/*public class DossierAccidentBean {
	private DossierAccident Dossier= new DossierAccident();
private List<DossierAccident> DossierAccidentList= new ArrayList<DossierAccident>();
private DossierAccidentDao da=new DossierAccidentDao();

	private DossierAccident DossierAccidentModif=new DossierAccident();
	


	public DossierAccident getDossierAccidentModif() {
		return DossierAccidentModif;
	}



	public void setDossierAccidentModif(DossierAccident DossierAccidentModif) {
		this.DossierAccidentModif = DossierAccidentModif;
	}
	
    
	
    
   public DossierAccident getDossierAccident() {
		return Dossier;
	}



	public void setDossierAccident(DossierAccident Dossier) {
		this.Dossier = Dossier;
	}



	public List<DossierAccident> getDossierAccidentList() {
		return DossierAccidentList;
	}



	public void setDosssierAccidentList(List<DossierAccident> DossierAccidentList) {
		this.DossierAccidentList = DossierAccidentList;
	}

public DossierAccidentBean(){
	this.DossierAccidentList=new ArrayList<DossierAccident>();
	this.DossierAccidentList=da.afficher();
}

public void ajouter(){
	   da.ajouter(Dossier);
	   this.Dossier=new DossierAccident();
	
   } 
public void allDossierAccident(){
	this.DossierAccidentList=new ArrayList<DossierAccident>();
	this.DossierAccidentList=da.afficher();
}
public void supprimerDossierAccident(String idAcc){
	System.out.println("ID accident est  "+idAcc);
	DossierAccident DossierAccidentselectionee=new DossierAccident();
	DossierAccidentselectionee=da.chercherParId(idAcc);
	System.out.println("Dossier Accident avec cet Id existe et voila"+ DossierAccidentselectionee.getIdAcc());	
	da.supprimer(DossierAccidentselectionee);
	
}
public void Modifselect(String id){
	this.DossierAccidentModif=da.chercherParId(id);
	
}
public void enregistrermodif(){
	da.modifier(Dossier);
}


    
    
    
}*/