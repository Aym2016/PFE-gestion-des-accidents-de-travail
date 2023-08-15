package com.gmc.GestionAccidentTravail.presentation;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.SessionScoped;

import org.primefaces.component.datatable.feature.SelectionFeature;

import com.gmc.GestionAccidentTravail.dao1.BordereauEnvoiDao;

import com.gmc.GestionAccidentTravail.entity.BordereauEnvoi;


@SessionScoped
public class BordereauEnvoiBean {
	private String inputname;
	
	public String getInputname() {
		return inputname;
	}



	public void setInputname(String inputname) {
		this.inputname = inputname;
	}
public void chercher(String enteredValue) {
		if(inputname=="") {
			this.BordereauEnvoiList=null;
		}else {
		this.BordereauEnvoiList=new ArrayList<BordereauEnvoi>();
		this.BordereauEnvoiList=be.chercherB(enteredValue);
		//System.out.println(this.listB);
		}
	     
	}
	private BordereauEnvoi BorModif=new BordereauEnvoi();
	public BordereauEnvoi getBorModif() {
		return BorModif;
	}



	public void setBorModif(BordereauEnvoi BorModif) {
		this.BorModif = BorModif;
	}
	private BordereauEnvoi b= new BordereauEnvoi();
	private List<BordereauEnvoi> BordereauEnvoiList= new ArrayList<BordereauEnvoi>();
    private BordereauEnvoiDao be=new BordereauEnvoiDao();
    
    
	
    
   public BordereauEnvoi getBordereauEnvoi() {
		return b;
	}



	public void setBordereauEnvoi(BordereauEnvoi b) {
		this.b = b;
	}


	public void supprimer(String refBord){
		System.out.println("la reference de bordereau est "+refBord);
		BordereauEnvoi BordereauEnvoiselectionee=new BordereauEnvoi();
		BordereauEnvoiselectionee=be.chercherParId(refBord);
		System.out.println("cet reference de bordereau "+BordereauEnvoiselectionee.getRefBord()+" existe");	
		be.supprimer(BordereauEnvoiselectionee);
		
	}
	public List<BordereauEnvoi> getBordereauEnvoiList() {
		return BordereauEnvoiList;
	}
public BordereauEnvoiBean() {
	BordereauEnvoiDao be=new BordereauEnvoiDao();
	this.BordereauEnvoiList=be.afficher();
}


	public void setBordereauEnvoiList(List<BordereauEnvoi> BordereauEnvoiList) {
		this.BordereauEnvoiList = BordereauEnvoiList;
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
		   be.ajouter(b);
		   this.b=new BordereauEnvoi();
	   } 
public void allBordereauEnvoi(){
	this.BordereauEnvoiList=new ArrayList<BordereauEnvoi>();
	this.BordereauEnvoiList=be.afficher();
}
public void modifselect(String id){
	this.BorModif=be.chercherParId(id);
	
}
public void enregistrermodif(){
	be.modifier(this.BorModif);
}
}

/*public class BordereauEnvoiBean{
	//private List<BordereauEnvoi> BordereauEnvoiList;
	//private BordereauEnvoi bordereauEnvoi;
	private BordereauEnvoi bordereauEnvoi= new BordereauEnvoi();
	private List<BordereauEnvoi> BordereauEnvoiList= new ArrayList<BordereauEnvoi>();
	private BordereauEnvoiDao be=new BordereauEnvoiDao();
	public List<BordereauEnvoi> getBordereauEnvoiList() {
		return BordereauEnvoiList;
	}

	public void allBordereauEnvoi(){
		this.BordereauEnvoiList=new ArrayList<BordereauEnvoi>();
		this.BordereauEnvoiList=be.afficher();
	}
	public BordereauEnvoi getBordereauEnvoi() {
		return bordereauEnvoi;
	}

	public void setBordereau(BordereauEnvoi bordereauEnvoi) {
		this.bordereauEnvoi= bordereauEnvoi;
	}

	public void setBordereauEnvoiList(List<BordereauEnvoi> BordereauEnvoiList) {
		this.BordereauEnvoiList = BordereauEnvoiList;
	}

	public String ajouter() {
		
		BordereauEnvoiDao BordereauEnvoiDao = new BordereauEnvoiDao();
		BordereauEnvoiDao.ajouter(this.bordereauEnvoi);
	    return "ajoutBordereauEnvoi?faces-redirect=true";
	}
	public BordereauEnvoiBean() {
	       BordereauEnvoiDao BordereauEnvoiDao = new BordereauEnvoiDao();
		this.BordereauEnvoiList = BordereauEnvoiDao.afficher();
		
		
	}

	public String index() {
		BordereauEnvoiDao BordereauEnvoiDao = new BordereauEnvoiDao();
		this.BordereauEnvoiList = BordereauEnvoiDao.afficher();
		return "ConsulterListBordereau?faces-redirect=true";
	}


	}*/
/*public class BordereauEnvoiBean {
	
	
	private BordereauEnvoi BordereauEnvoiModif=new BordereauEnvoi();
	public BordereauEnvoi getBordereauEnvoitModif() {
		return BordereauEnvoiModif;
	}



	public void setBordereauEnvoiModif(BordereauEnvoi BordereauEnvoiModif) {
		this.BordereauEnvoiModif = BordereauEnvoiModif;
	}
	private BordereauEnvoi Bor= new BordereauEnvoi();
	private List<BordereauEnvoi> BordereauEnvoiList= new ArrayList<BordereauEnvoi>();
    private BordereauEnvoiDao be=new BordereauEnvoiDao();
    
	
    
   public BordereauEnvoi getBordereauEnvoi() {
		return Bor;
	}



	public void setBordereauEnvoi(BordereauEnvoi Bor) {
		this.Bor= Bor;
	}



	public List<BordereauEnvoi> getBordereauEnvoiList() {
		return BordereauEnvoiList;
	}



	public void setBordereauEnvoiList(List<BordereauEnvoi> BordereauEnvoiList) {
		this.BordereauEnvoiList = BordereauEnvoiList;
	}



public void ajouter(){
	   be.ajouter(Bor);
	   this.Bor=new BordereauEnvoi();
   } 
public void  allBordereauEnvoi(){
	BordereauEnvoiDao be=new BordereauEnvoiDao();
	//be.afficher();
	this.BordereauEnvoiList=be.afficher();
 
}
public BordereauEnvoiBean() {
    BordereauEnvoiDao BordereauEnvoiDao = new BordereauEnvoiDao();
	this.BordereauEnvoiList = BordereauEnvoiDao.afficher();
	
	
}
public BordereauEnvoi getBor() {
	return Bor;
}



public void setBor(BordereauEnvoi bor) {
	Bor = bor;
}



public BordereauEnvoiDao getBe() {
	return be;
}



public void setBe(BordereauEnvoiDao be) {
	this.be = be;
}



public BordereauEnvoi getBordereauEnvoiModif() {
	return BordereauEnvoiModif;
}



public void supprimer(String refBord){
	System.out.println("la reference de bordereau est "+refBord);
	BordereauEnvoi BordereauEnvoiselectionee=new BordereauEnvoi();
	BordereauEnvoiselectionee=be.chercherParId(refBord);
	System.out.println("cet reference de bordereau "+BordereauEnvoiselectionee.getRefBord()+" existe");	
	be.supprimer(BordereauEnvoiselectionee);
	
}
public void Modifselect(String id){
	this.BordereauEnvoiModif=be.chercherParId(id);
	
}
public void enregistrermodif(){
	be.modifier(Bor);
}
}*/


    
    
    
