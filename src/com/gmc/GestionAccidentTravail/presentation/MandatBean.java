package com.gmc.GestionAccidentTravail.presentation;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.component.datatable.feature.SelectionFeature;

import com.gmc.GestionAccidentTravail.dao1.BordereauEnvoiDao;
import com.gmc.GestionAccidentTravail.dao1.MandatDao;
import com.gmc.GestionAccidentTravail.entity.Employe;
import com.gmc.GestionAccidentTravail.entity.Mandat;

@SessionScoped
@ManagedBean(name="mandatBean")
public class MandatBean {
	private Mandat MandatModif=new Mandat();
	private String inputname;
	
	public String getInputname() {
		return inputname;
	}

	public void setInputname(String inputname) {
		this.inputname = inputname;
	}

	public Mandat getMandatModif() {
		return  MandatModif;
	}
public void chercher(String enteredValue) {
	if(inputname=="") {
		this.MandatList=null;
	}else {
		this.MandatList=new ArrayList<Mandat>();
		this.MandatList=md1.chercherB(enteredValue);
		//System.out.println(this.listB);
	    }
		
	
	}

	public MandatBean() {
		MandatDao md=new MandatDao();
		this.MandatList=md.afficher();
	}

	public void setMandatModif(Mandat MandatModif) {
		this.MandatModif = MandatModif;
	}
	
	private Mandat md =new Mandat();
	private List<Mandat> MandatList= new ArrayList<Mandat>();
    private  MandatDao md1=new MandatDao();
    
    public  void chercherParId(String idMand){
    	this.md=md1.chercherParId(idMand);
    }
	
    
   public Mandat getMandat() {
		return md;
	}



	public void setMandat(Mandat md) {
		this.md= md;
	}



	public List<Mandat> getMandatList() {
		return MandatList;
	}



	public void setMandatList(List<Mandat> MandatList) {
		this.MandatList = MandatList;
	}



public String ajouter(){
	    md1.ajouter(md);
	   this.md=new Mandat();
       return md1.toString();  
} 
public void allMandat(){
	this.MandatList=new ArrayList<Mandat>();
	this.MandatList=md1.afficher();
}
public void supprimer(String idMandat){
	System.out.println("l'identifiant de mandat est   "+idMandat);
	Mandat md=new Mandat();
	md=md1.chercherParId(idMandat);
	System.out.println("Mandat avec cet identifiant " +md.getIdMand()+" existe");	
	md1.supprimer(md);
	
}
public void modifier(String id){
	this.MandatModif=md1.chercherParId(id);
	
	
}
/*public MandatBean(Mandat mandatModif, Mandat md, List<Mandat> mandatList, MandatDao md1) {
	super();
	MandatModif = mandatModif;
	this.md = md;
	MandatList = mandatList;
	this.md1 = md1;
}*/



public void enregistrermodif(){
	md1.modifier(this.MandatModif);
}
}


    
    
    
