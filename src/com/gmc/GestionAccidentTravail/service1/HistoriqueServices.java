package com.gmc.GestionAccidentTravail.service1;
import java.util.List;

import com.gmc.GestionAccidentTravail.dao1.HistoriqueDao;

import com.gmc.GestionAccidentTravail.entity.Historique;
public class HistoriqueServices {
	HistoriqueDao dao=new HistoriqueDao();
	public void ajouter(Historique d){
		dao.ajouter(d);
	}
	public Historique modifier (Historique d){
		return dao.modifier(d);
	}
	public void supprimer(Historique Historiqueselectionee){
		dao.supprimer(Historiqueselectionee);
	}
	public List<Historique> afficher(){
		return dao.afficher();
	}
	public Historique chercherParId(int id){
		return dao.chercherParId(id);
	}

}