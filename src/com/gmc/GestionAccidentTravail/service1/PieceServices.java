package com.gmc.GestionAccidentTravail.service1;
import java.util.List;

import com.gmc.GestionAccidentTravail.dao1.PieceDao;

import com.gmc.GestionAccidentTravail.entity.Piece;
public class PieceServices {
	PieceDao dao=new PieceDao();
	public Piece ajouter(Piece p){
		return dao.ajouter(p);
	}
	public Piece modifier (Piece p){
		return dao.modifier(p);
	}
	public void supprimer(Piece Pieceselectionee){
		dao.supprimer(Pieceselectionee);
	}
	public List<Piece> chercher(){
		return dao.afficher();
	}
	public Piece chercherParId(String id){
		return dao.chercherParId(id);
	}

}