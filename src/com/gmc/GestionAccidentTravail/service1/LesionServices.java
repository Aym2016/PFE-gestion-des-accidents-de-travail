package com.gmc.GestionAccidentTravail.service1;
import java.util.List;

import com.gmc.GestionAccidentTravail.dao1.LesionDao;

import com.gmc.GestionAccidentTravail.entity.Lesion;
public class LesionServices {
	LesionDao dao=new LesionDao();
	public Lesion ajouter(Lesion l){
		return dao.ajouter(l);
	}
	public Lesion modifier (Lesion l){
		return dao.modifier(l);
	}
	public void supprimer(Lesion Lesionselectionee){
		dao.supprimer(Lesionselectionee);
	}
	public List<Lesion> chercher(){
		return dao.afficher();
	}
	public Lesion chercherParId(String id){
		return dao.chercherParId(id);
	}

}