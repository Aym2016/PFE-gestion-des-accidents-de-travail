package com.gmc.GestionAccidentTravail.presentation;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.component.datatable.feature.SelectionFeature;

import com.gmc.GestionAccidentTravail.dao1.DossierAccidentDao;
import com.gmc.GestionAccidentTravail.dao1.EmployeDao;
import com.gmc.GestionAccidentTravail.entity.BordereauEnvoi;
import com.gmc.GestionAccidentTravail.entity.DossierAccident;
import com.gmc.GestionAccidentTravail.entity.Employe;

@SessionScoped

@ManagedBean(name="employeBean")
public class EmployeBean {
	private int inputname;
	public int getInputname() {
		return inputname;
	}



	public void setInputname(int inputname) {
		this.inputname = inputname;
	}
	private Employe EmployeModif=new Employe();
	public Employe getEmployeModif() {
		return EmployeModif;
	}
public void chercher(int enteredValue) {
		
		this.EmployeList=new ArrayList<Employe>();
		this.EmployeList=em.chercherB(enteredValue);
		//System.out.println(this.listB);
		
		
	
	}


	public void setEmployeModif(Employe EmployeModif) {
		this.EmployeModif = EmployeModif;
	}
	private Employe Emp= new Employe();
	private List<Employe> EmployeList= new ArrayList<Employe>();
    private EmployeDao em=new EmployeDao();
     private DossierAccidentDao dad=new DossierAccidentDao();
    		 
    private List<DossierAccident> DossierAccidentList= new ArrayList<DossierAccident>();
    private DossierAccident Dossier= new DossierAccident();
    public List<DossierAccident> getDossierAccidentList() {
    	this. DossierAccidentList=new ArrayList< DossierAccident>();
    	this. DossierAccidentList=dad.afficher();
    	return this. DossierAccidentList;
	}
    public void setDossierAccidentList(List<DossierAccident> DossierAccidentList) {
		this.DossierAccidentList = DossierAccidentList;
	}
    public DossierAccident getDossierAccident() {
		return Dossier ;
	}



	public void setDossierAccident(DossierAccident Dossier) {
		this.Dossier = Dossier;
	}

public Employe getEmploye() {
		return Emp;
	}
/*public void supprimer(int mat){
	
	Employe Employeselectionee=new Employe();
	Employeselectionee=em.chercherParId(mat);
	System.out.println("fffffffffffffffffffff "+Employeselectionee.getMatriculeEmp());	
	em.supprimer(Employeselectionee);
	
}*/


	public void setEmploye(Employe Emp) {
		this.Emp = Emp;
	}



	public List<Employe> getEmployeList() {
		return EmployeList;
	}
public EmployeBean() {
	EmployeDao emp=new EmployeDao();
	this.EmployeList=emp.afficher();
	
}


	public void setEmployeList(List<Employe> EmployeList) {
		this.EmployeList = EmployeList;
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
	/*public void ajouter(){
		EmployeDao empd = new EmployeDao();
		empd.ajouter(this.Emp); 
		  // this.Emp=new Employe();
	   }*/ 
	public void ajouter(){
		   em.ajouter(this.Emp);
		   this.Emp=new Employe();
	   }
	public void allEmploye(){
	this.EmployeList=new ArrayList<Employe>();
	this.EmployeList=em.afficher();
}
	public void supprimer(int id){
		System.out.println("la reference de employe est "+id);
		Employe Employeselectionee=new Employe();
		Employeselectionee=em.chercherParId(id);
		//System.out.println("cet reference de bordereau "+BordereauEnvoiselectionee.getRefBord()+" existe");	
		em.supprimer(Employeselectionee);
		   
	   }
	/*public void supprimer(int id) {
	EmployeDao empd = new EmployeDao();
	empd.supprimer(id);}*/

public void modifier(int id) {
	
	this.EmployeModif=em.chercherParId(id);
	}
public void enregistrermodif(){
	em.modifier(this.EmployeModif);
}
}
/*public class EmployeBean {
	
	private Employe EmployeModif=new Employe();
	 private int id;
	    
		
	    
	   public int getId() {
			return id;
		}



		public void setId(int id) {
			this.id = id;
		}
		public Employe getDossierAccidentModif() {
		return EmployeModif;
	}

    

	public void setEmployeModif(Employe EmployeModif) {
		this.EmployeModif = EmployeModif;
	}
	private Employe Emp= new Employe();
	private List<Employe> EmployeList= new ArrayList<Employe>();
    private EmployeDao em=new EmployeDao();
    
    
	
    
   public Employe getEmploye() {
		return Emp;
	}



	public void setEmploye(Employe Emp) {
		this.Emp = Emp;
	}



	public List<Employe> getEmployeList() {
		return EmployeList;
	}
public EmployeBean() {
	EmployeDao emp=new EmployeDao();
	this.EmployeList=emp.afficher();
}


	public void setEmployeList(List<Employe> EmployeList) {
		this.EmployeList = EmployeList;
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
	/*public void ajouter(){
		   em.ajouter(Emp);
		   this.Emp=new Employe();
	   } 
	public void supprimer(int id) {
		EmployeDao empd = new EmployeDao();
		empd.supprimer(empd.chercherParId(id));}

	public void allEmploye(){
	this.EmployeList=new ArrayList<Employe>();
	this.EmployeList=em.afficher();
}

}*/
/*public class EmployeBean {
	
	private Employe EmployeModif=new Employe();
	private Employe getDossierAccidentModif() {
		return EmployeModif;
	}



	public void setEmployeModif(Employe EmployeModif) {
		this.EmployeModif = EmployeModif;
	}
	private Employe Emp= new Employe();
	private List<Employe> EmployeList= new ArrayList<Employe>();
    private EmployeDao em=new EmployeDao();
    
    
	
    
   public Employe getEmploye() {
		return Emp;
	}



	public void setEmploye(Employe Emp) {
		this.Emp = Emp;
	}
}
	/*public class EmployeBean {
		
		private Employe EmployeModif=new Employe();
		private Employe getDossierAccidentModif() {
			return EmployeModif;
		}



		public void setEmployeModif(Employe EmployeModif) {
			this.EmployeModif = EmployeModif;
		}
		private Employe Emp= new Employe();
		private List<Employe> EmployeList= new ArrayList<Employe>();
	    private EmployeDao em=new EmployeDao();
	    
	    
		
	    
	   public Employe getEmploye() {
			return Emp;
		}



		public void setEmploye(Employe Emp) {
			this.Emp = Emp;
		}



		public List<Employe> getEmployeList() {
			return EmployeList;
		}*/
	/*public EmployeBean() {
		EmployeDao emp=new EmployeDao();
		this.EmployeList=emp.afficher();
	}*/


	/*	public void setEmployeList(List<Employe> EmployeList) {
			this.EmployeList = EmployeList;
		}

	public List<Employe> getEmployeList() {
		return EmployeList;
	}
public EmployeBean() {
	EmployeDao emp=new EmployeDao();
	this.EmployeList=emp.afficher();
}


	public void setEmployeList(List<Employe> EmployeList) {
		this.EmployeList = EmployeList;
	}
}
	/*public class EmployeBean {
	
	private Employe EmployeModif=new Employe();
	public Employe getDossierAccidentModif() {
		return EmployeModif;
	}

public void supprimer(int mat){
	System.out.println("fffffffffffffffffffff "+mat);
	Employe Employeselectionee=new Employe();
	Employeselectionee=em.chercherParId(mat);
	System.out.println("fffffffffffffffffffff "+Employeselectionee.getMatriculeEmp());	
	em.supprimer(Employeselectionee);
	
}

	public void setEmployeModif(Employe EmployeModif) {
		this.EmployeModif = EmployeModif;
	}
	private Employe Emp= new Employe();
	private List<Employe> EmployeList= new ArrayList<Employe>();
    private EmployeDao em=new EmployeDao();
    
    
	
    
   public Employe getEmploye() {
		return Emp;
	}



	public void setEmploye(Employe Emp) {
		this.Emp = Emp;
	}



	public List<Employe> getEmployeList() {
		return EmployeList;
	}



	public void setEmployeList(List<Employe> EmployeList) {
		this.EmployeList = EmployeList;
	}



public void ajouter(){
	   em.ajouter(Emp);
	   this.Emp=new Employe();
   } 
public void allEmploye(){
	this.EmployeList=new ArrayList<Employe>();
	this.EmployeList=em.afficher();
}
public EmployeBean() {
	EmployeDao emp=new EmployeDao();
	this.EmployeList=emp.afficher();
}

public void supprimerEmploye(int mat){
	System.out.println("fffffffffffffffffffff "+mat);
	Employe Employeselectionee=new Employe();
	Employeselectionee=em.chercherParId(mat);
	System.out.println("fffffffffffffffffffff "+Employeselectionee.getMatriculeEmp());	
	em.supprimer(Employeselectionee);
	
}
public void Modifselect(int mat){
	this.EmployeModif=em.chercherParId(mat);
	
}
public void enregistrermodif(){
	em.modifier(Emp);
}


    
    
    
}*/