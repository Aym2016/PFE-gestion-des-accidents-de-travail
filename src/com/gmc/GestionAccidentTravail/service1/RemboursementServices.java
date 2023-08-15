package com.gmc.GestionAccidentTravail.service1;
import java.util.List;

import com.gmc.GestionAccidentTravail.dao1.RemboursementDao;

import com.gmc.GestionAccidentTravail.entity.Remboursement;
public class RemboursementServices {
	RemboursementDao dao=new RemboursementDao();
	public void ajouter(Remboursement rm){
		 dao.ajouter(rm);
	}
	public void modifier (Remboursement rm){
		 dao.modifier(rm);
	}
	public void supprimer(Remboursement Remboursementselectionee){
		dao.supprimer(Remboursementselectionee);
	}
	public List<Remboursement> chercher(){
		return dao.afficher();
	}
	public Remboursement chercherParId(String id){
		return dao.chercherParId(id);
	}

}