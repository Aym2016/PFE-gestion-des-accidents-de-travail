package com.gmc.GestionAccidentTravail.service1;
import java.util.List;

import com.gmc.GestionAccidentTravail.dao1.BordereauEnvoiDao;

import com.gmc.GestionAccidentTravail.entity.BordereauEnvoi;
public class BordereauEnvoiServices {
	BordereauEnvoiDao dao=new BordereauEnvoiDao();
	public BordereauEnvoi ajouter(BordereauEnvoi b){
		return dao.ajouter(b);
	}
	public BordereauEnvoi modifier (BordereauEnvoi b){
		return dao.modifier(b);
	}
	public void supprimer(BordereauEnvoi bordereauEnvoiselectionee){
		dao.supprimer(bordereauEnvoiselectionee);
	}
	public List<BordereauEnvoi> chercher(){
		return dao.afficher();
	}
	public BordereauEnvoi chercherParId(String id){
		return dao.chercherParId(id);
	}

}