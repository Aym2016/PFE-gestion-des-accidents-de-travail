package com.gmc.GestionAccidentTravail.presentation;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import com.gmc.GestionAccidentTravail.dao1.*;
import com.gmc.GestionAccidentTravail.entity.*;

@SessionScoped
@ManagedBean(name = "chercherBeanB")
public class ChercherBeanB {
private List<BordereauEnvoi> listB=null;
BordereauEnvoiDao Bor	= new BordereauEnvoiDao();	
public List<BordereauEnvoi> getListB() {
	return listB;
}

public void setListB(List<BordereauEnvoi> listB) {
	this.listB = listB;
}


private String inputName;

	public String getInputName() {
		return inputName;
	}

	public void setInputName(String inputName) {
		this.inputName = inputName;
	}

	
	public void chercher(String enteredValue) {
		
		this.listB=new ArrayList<BordereauEnvoi>();
		this.listB=Bor.chercherB(enteredValue);
		//System.out.println(this.listB);
		
	
	}


}