package com.gmc.GestionAccidentTravail.service1;
import java.util.List;

import com.gmc.GestionAccidentTravail.dao1.DossierAccidentDao;

import com.gmc.GestionAccidentTravail.entity.DossierAccident;
public class DossierAccidentServices {
	DossierAccidentDao dao=new DossierAccidentDao();
	public void ajouter(DossierAccident d){
		 dao.ajouter(d);
	}
	public DossierAccident modifier (DossierAccident d){
		return dao.modifier(d);
	}
	public void supprimer(DossierAccident DossierAccidentselectionee){
		dao.supprimer(DossierAccidentselectionee);
	}
	public List<DossierAccident> chercher(){
		return dao.afficher();
	}
	public DossierAccident chercherParId(String id){
		return dao.chercherParId(id);
	}

}