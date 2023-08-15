package com.gmc.GestionAccidentTravail.presentation;
//import com.gmc.GestionAccidentTravail.Hibernate;
import com.gmc.GestionAccidentTravail.Hibernate.HibernateUtil;
import com.gmc.GestionAccidentTravail.entity.*;
//import com.gmc.GestionAccidentTravail.dao.*;
import com.gmc.GestionAccidentTravail.dao1.BordereauEnvoiDao;
import com.gmc.GestionAccidentTravail.dao1.DossierAccidentDao;
import com.gmc.GestionAccidentTravail.dao1.EmployeDao;
import com.gmc.GestionAccidentTravail.dao1.MandatDao;
import com.gmc.GestionAccidentTravail.dao1.RemboursementDao;
import com.gmc.GestionAccidentTravail.dao1.UtilisateurDao;

import java.util.*;import org.hibernate.Session;
import org.hibernate.Transaction;
//import com.isetn.model.Client;
//import com.isetn.hibernate.HibernateUtil;
public class Test {
public static void main(String[] args) {

Session session = HibernateUtil.currentSession();
BordereauEnvoiDao bd1=new BordereauEnvoiDao();

/*EmployeDAO em=new EmployeDAOImpl();
MandatDAO  md=new MandatDAOImpl();
DossierAccidentDAO da=new DossierAccidentDAOImpl();
UtilisateurDAO ut=new UtilisateurDAOImpl();
HistoriqueDAO hd=new HistoriqueDAOImpl();
LesionDAO ld=new LesionDAOImpl();
PieceDAO pd=new PieceDAOImpl();
BordereauEnvoiDAO be=new BordereauEnvoiDAOImpl();*/
//em.ajouter(new Employe());
EmployeDao eb=new EmployeDao();
eb.chercherB(6);
RemboursementBean rb=new RemboursementBean();
System.out.println("la resultat de recherche est"); 
rb.chercher("");
RemboursementDao rbd=new RemboursementDao();
rbd.chercherB("ff");

BordereauEnvoiBean bv=new BordereauEnvoiBean();
Transaction tx = null;
try {
tx = session.beginTransaction(); System.out.println("// on cree une instance de la classe de donnees Reservations");
  Lesion e = new Lesion();
 //e.setRefles("az");
  //Employe ep=new Employe();
  //ep.setMatriculeEmp(123456);
  
  Mandat md1=new Mandat();
  //md1.setIdMand("azery");
  Historique h=new Historique();
  //h.setId(123);
  Piece p=new Piece();
  //p.setRefPiece("r123");
  Utilisateur ut1=new Utilisateur();
 // ut1.setLogin("azer120");
  BordereauEnvoi be1=new BordereauEnvoi();
  //be1.setRefBord("qsdf1234");
  DossierAccident da1=new DossierAccident();
 // da1.setIdAcc("AZERt");
  session.save(e);
  //session.save(ep);
  
  session.save(da1);
  session.save(md1);
  session.save(h);
  session.save(p);
  session.save(ut1);
  session.save(be1);
  session.save(da1);
  
  

//session.save(ep);
tx.commit();
}
catch (Exception e) {
if (tx != null) {
tx.rollback();
}
HibernateUtil.closeSession();
}

ChercherBeanB bd=new ChercherBeanB();
System.out.println("la liste des Bordereau est");
bd.chercher("ff");
bv.allBordereauEnvoi();
//System.out.println(bd1.getListBordereauEnvoi());
//bd1.afficher().toString();
/*UtilisateurDao ud=new UtilisateurDao();
System.out.println("l utilisateur ud"+ud.connexion("azerttg", "qsdfg"));*/


DossierAccidentBean dab=new DossierAccidentBean();
DossierAccidentDao dad=new DossierAccidentDao();
System.out.println("la liste des accident est");
System.out.println(dad.afficher());
System.out.println("la liste des accident bean est");

dab.allDossierAccident();
MandatDao mdd=new MandatDao();
/*EmployeDao empd= new EmployeDao();
System.out.println("l' employe est "+empd.chercherParId(12345));*/
EmployeBean emb=new EmployeBean();
Employe em=new Employe(); 
emb.supprimer(1245);
MandatBean md=new MandatBean();
md.supprimer("hjkl");
System.out.println("la liste des Mandat est");
md.getMandatList();
System.out.println(mdd.afficher());
}

}
