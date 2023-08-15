package com.gmc.GestionAccidentTravail.service1;
import java.util.List;

import com.gmc.GestionAccidentTravail.dao1.UtilisateurDao;

import com.gmc.GestionAccidentTravail.entity.Utilisateur;
public class UtilisateurServices {
	UtilisateurDao dao=new UtilisateurDao();
	public  Utilisateur ajouter(Utilisateur ut){
		return dao.ajouter(ut);
	}
	public Utilisateur modifier (Utilisateur ut){
		return dao.modifier(ut);
	}
	public void supprimer(Utilisateur Utilisateurselectionee){
		dao.supprimer(Utilisateurselectionee);
	}
	public List<Utilisateur> chercher(){
		return dao.afficher();
	}
	public Utilisateur chercherParId(String id){
		return dao.chercherParId(id);
	}

}