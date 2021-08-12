package fit5042.tutex.controllers;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.el.ELContext;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import fit5042.tutex.mbeans.CustomerContactManagedBean;


/**
 * 
 * @author ChengGuang Li
 *
 */
@RequestScoped
@Named("searchUser")
public class SearchUser {
	private boolean showForm = true;
	private User user;
	UserApplication app;
	
	private int searchByInt;
	
	public SearchUser() {
		ELContext context = FacesContext.getCurrentInstance().getELContext();
		app = (UserApplication)FacesContext.getCurrentInstance()
                .getApplication()
                .getELResolver()
                .getValue(context, null, "userApplication");
		app.updateUserList();
		
	}
	
	public boolean isShowForm() {
        return showForm;
    }
	
	//getter and setter method 
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getSearchByInt() {
		return searchByInt;
	}

	public void setSearchByInt(int searchByInt) {
		this.searchByInt = searchByInt;
	}

	public UserApplication getApp() {
		return app;
	}

	public void setApp(UserApplication app) {
		this.app = app;
	}
	
	/**
	 *  search all method
	 */
	
  public void searchAll() {
		
		try {
			 //return all customerContacts from db via EJB
			app.searchAll();
			
		}catch(Exception e) {
			
		}
		showForm = true;
	}
	
	
   public void searchUserById(int id) {	  
	   try {
		 //search this customer then refresh the list in CustomerApplication bean	
		   app.searchUserById(id);	   
	   }catch(Exception e) {
		   Logger.getLogger(CustomerContactManagedBean.class.getName()).log(Level.SEVERE, null, e);
	   }
	   showForm = true;
	   
   }
   
   
   
   
	
	
}
