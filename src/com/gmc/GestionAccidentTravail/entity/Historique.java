package com.gmc.GestionAccidentTravail.entity;
import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name="historique")
public class Historique {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private int id;
	@Temporal(TemporalType.DATE)
	private Date date;
	private String observation;
	@ManyToOne
	@JoinColumn(name = "employeH",referencedColumnName = "MatriculeEmp")
   
	private Employe employeH;
	public Historique() {
		super();
	}
	public Historique(int id, Date date, String observation, Employe employeH) {
		super();
		this.id = id;
		this.date = date;
		this.observation = observation;
		this.employeH = employeH;
	}
	public Employe getEmployeH() {
		return employeH;
	}
	public void setEmployeH(Employe employeH) {
		this.employeH = employeH;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getObservation() {
		return observation;
	}
	public void setObservation(String observation) {
		this.observation = observation;
	}
	

}
