package com.gmc.GestionAccidentTravail.presentation;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.gmc.GestionAccidentTravail.entity.Utilisateur;
@SessionScoped
@ManagedBean(name = "identificationBean")
public class IdentificationBean {
	private String identifiant;
	public String getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	private String passwd;
	private boolean isLogin = false;
	private Utilisateur ut;
	private String message = "";

	public IdentificationBean() {
		this.ut = new Utilisateur();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isLogin() {
		return isLogin;
	}

	public void setLogin(boolean isLogin) {
		this.isLogin = isLogin;
	}

	public Utilisateur getUtilisateur() {
		return ut;
	}

	public void setUtilisateur(Utilisateur ut) {
		this.ut = ut;
	}

	public void verifyLogin() {
		if (!this.isLogin) {
			doRedirect("login.xhtml");
		}
	}

	public void verif() {
		if (this.ut.getIdentifiant().equalsIgnoreCase(this.identifiant)
				&& this.ut.getPasswd().equalsIgnoreCase(this.passwd)) {
			this.isLogin = true;
			this.message = "";
			doRedirect("template.xhtml");
		} else {
			this.message = "Account's Invalid";
			doRedirect("login.xhtml");
		}
	}

	public void logout() {
		this.isLogin = false;
		doRedirect("login.xhtml");
	}

	private void doRedirect(String url) {
		try {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.getExternalContext().redirect(url);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
}

