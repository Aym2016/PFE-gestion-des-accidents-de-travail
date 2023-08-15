package com.gmc.GestionAccidentTravail.presentation;



import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;

import org.primefaces.model.chart.PieChartModel;

import com.gmc.GestionAccidentTravail.dao1.DossierAccidentDao;
import com.gmc.GestionAccidentTravail.entity.DossierAccident;
@SessionScoped
public class StatistiqueBean  {
	  private PieChartModel pieModel1=new PieChartModel();
	    private PieChartModel pieModel2;
	    private DossierAccidentDao pd=new DossierAccidentDao();
	   public void init() {
	        createPieModels();
	    }
	    public PieChartModel getPieModel1() {
	        return pieModel1;
	    }
	     
	    public PieChartModel getPieModel2() {
	        return pieModel2;
	    }
	     
	    private void createPieModels() {
	        createPieModel1();
	       // createPieModel2();
	    }
	    @SuppressWarnings("deprecation")
		public int accidentparmois(int mois){
	    	int x=0;
	    	List<DossierAccident> listDa=new ArrayList<DossierAccident>();
	    	listDa=pd.afficher();
	    	for(DossierAccident da:listDa){
		    	Calendar c=Calendar.getInstance();
		    	
		    	//c.setTime(new Date(2015, 3, 17));
		    	if(da.getDateAcc()!=null)
		    	{c.setTime(da.getDateAcc());
		    	int moisajout=c.get(Calendar.MONTH)+1;
		    		if(moisajout==mois){
		    			x++;
		    		}
		    	}
	    	}
	    	
	    	
	    	return x;
	    }
	   /* public int accidentparAns(int Ans){
	    	int x=0;
	    	List<DossierAccident> listDa=new ArrayList<DossierAccident>();
	    	listDa=pd.afficher();
	    	for(DossierAccident da:listDa){
	    		
	    		Calendar c=Calendar.getInstance();
	    		c.setTime(new Date(2015, 3, 17));
	    		c.setTime(da.getDateSaisie());
		    	int moisajout=c.get(Calendar.YEAR)+1;
		    		if(moisajout==Ans){
		    			x++;
		    		}
	    		
	    	}
	    	
	    	
	    	return x;
	    }*/
	    private void createPieModel1() {
	    	pieModel1 = new PieChartModel();
	    	
	    	
	    	
	        
	         
	        pieModel1.set("Janvier", accidentparmois(1));
	        pieModel1.set("Fevrier", accidentparmois(2));
	        pieModel1.set("Mars", accidentparmois(3));
	        pieModel1.set("Avril", accidentparmois(4));
	        pieModel1.set("Mai", accidentparmois(5));
	        pieModel1.set("Juin", accidentparmois(6));
	        pieModel1.set("Juillet", accidentparmois(7));
	        pieModel1.set("Aout", accidentparmois(8));
	        pieModel1.set("Septembre", accidentparmois(9));
	        pieModel1.set("Octobre", accidentparmois(10));
	        pieModel1.set("Novembre", accidentparmois(11));
	        pieModel1.set("Decembre", accidentparmois(12));
	         
	        pieModel1.setTitle("statistique des Accidents par Mois");
	        
	        pieModel1.setLegendPosition("w");
	    }
	     
	    private void createPieModel2() {
	        pieModel2 = new PieChartModel();
	         
	        pieModel2.set("Brand 1", 540);
	        pieModel2.set("Brand 2", 325);
	        pieModel2.set("Brand 3", 702);
	        pieModel2.set("Brand 4", 421);
	         
	        pieModel2.setTitle("Custom Pie");
	        pieModel2.setLegendPosition("e");
	        pieModel2.setFill(false);
	        pieModel2.setShowDataLabels(true);
	        pieModel2.setDiameter(150);
	    }
	     
	}


