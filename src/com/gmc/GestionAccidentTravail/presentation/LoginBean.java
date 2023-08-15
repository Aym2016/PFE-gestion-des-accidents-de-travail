package com.gmc.GestionAccidentTravail.presentation;



import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.io.Serializable;

import com.gmc.GestionAccidentTravail.dao1.UtilisateurDao;
import com.gmc.GestionAccidentTravail.entity.Utilisateur;
@SessionScoped
public class LoginBean implements Serializable {
	 private static final long serialVersionUID = 7765876811740798583L;
	 private boolean loggedIn;
	 public boolean isLoggedIn() {
	        return loggedIn;
	    }
	 
	    public void setLoggedIn(boolean loggedIn) {
	        this.loggedIn = loggedIn;
	    } 
	private Utilisateur user=new Utilisateur();
	private UtilisateurDao ud=new UtilisateurDao();
	private String username="";
	private String pwd="";
	private String message = "";
	 //@ManagedProperty(value="#{navigationBean}")
	     NavigationBean nb=new NavigationBean();
	public String verif(){
		System.out.println("jgjhgjhfghfhgfhg");
		this.user=ud.connexion(this.username, this.pwd);
		if(this.user!=null){
			System.out.println("cet utilisateur existe");
			loggedIn = true;
            return nb.redirectToWelcome();
			//return "secured/index.xhtml?faces-redirect=true";
		}else{
			System.out.println("elseeeeeeeeeeeee");

			 FacesMessage faceMsg=new FacesMessage(FacesMessage.SEVERITY_INFO, "erreur", "verifier donnees");
		        FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
		        FacesContext.getCurrentInstance().addMessage("success info", faceMsg);
			return "#";
		}

	}
	
	public Utilisateur getUser() {
		return user;
	}
	


	public void setUser(Utilisateur user) {
		this.user = user;
	}



	public String getUsername() {
		return username;
	}

	
		
	public void setUsername(String username) {
		this.username = username;
	}



	public String getPwd() {
		return pwd;
	}
	


	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	 public String doLogout() {
	        // Set the paremeter indicating that user is logged in to false
	        loggedIn = false;
	         
	        // Set logout message
	        //FacesMessage msg = new FacesMessage("Logout success!", "INFO MSG");
	        //msg.setSeverity(FacesMessage.SEVERITY_INFO);
	        //FacesContext.getCurrentInstance().addMessage(null, msg);
	         
	        return nb.redirectToLogin();
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