package com.gmc.GestionAccidentTravail.entity;
import java.io.Serializable;

import javax.faces.event.ValueChangeEvent;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;


@Entity
@Table(name="lesion")
public class Lesion implements Serializable {
	//private static final long serialVersionUID = 1L;

	
 //@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id 
	//@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(name = "RefLes")
	private String RefLes;
	
	private String NatureL;
	
	@ManyToOne
	@JoinColumn(name="DossierLesion",referencedColumnName = "IdAcc")
	private DossierAccident DossierLesion;
	
	public Lesion() {
		super();
	}
	public void localeChanged(ValueChangeEvent e) {
	      //assign new value to country
	      RefLes = e.getNewValue().toString(); 
	   }
	public Lesion(String refles, String natureL,DossierAccident DossierLesion) {
		super();
		RefLes = refles;
		NatureL = natureL;
	    this.DossierLesion=DossierLesion;
	}
	public String getRefles() {
		return RefLes;
	}
	public void setRefles(String refles) {
		RefLes = refles;
	}
	public String getNatureL() {
		return NatureL;
	}
	public void setNatureL(String natureL) {
		NatureL = natureL;
	}
	
	

}
