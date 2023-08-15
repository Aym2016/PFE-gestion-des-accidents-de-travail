package com.gmc.GestionAccidentTravail.service1;
import java.util.List;

import com.gmc.GestionAccidentTravail.dao1.EmployeDao;

import com.gmc.GestionAccidentTravail.entity.Employe;
public class EmployeServices {
	EmployeDao dao=new EmployeDao();
	public void ajouter(Employe em){
		dao.ajouter(em);
	}
	public Employe modifier (Employe em){
		return dao.modifier(em);
	}
	public void supprimer(Employe Employeselectionee){
		dao.supprimer(Employeselectionee);
	}
	public List<Employe> afficher(){
		return dao.afficher();
	}
	public Employe chercherParId(int id){
		return dao.chercherParId(id);
	}

}