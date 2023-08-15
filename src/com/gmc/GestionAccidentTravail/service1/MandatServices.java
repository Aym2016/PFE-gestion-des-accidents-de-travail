package com.gmc.GestionAccidentTravail.service1;
import java.util.List;

import com.gmc.GestionAccidentTravail.dao1.MandatDao;

import com.gmc.GestionAccidentTravail.entity.Mandat;
public class MandatServices {
	MandatDao dao=new MandatDao();
	public Mandat ajouter(Mandat md){
		return dao.ajouter(md);
	}
	public void modifier (Mandat md){
		 dao.modifier(md);
	}
	public void supprimer(Mandat Mandatselectionee){
		dao.supprimer(Mandatselectionee);
	}
	public List<Mandat> chercher(){
		return dao.afficher();
	}
	public Mandat chercherParId(String id){
		return dao.chercherParId(id);
	}

}