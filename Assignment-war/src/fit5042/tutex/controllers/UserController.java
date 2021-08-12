package fit5042.tutex.controllers;

import javax.el.ELContext;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import fit5042.tutex.repository.entities.CustomerContact;

/**
 * 
 * @author ChengGuang Li
 *
 */

@Named(value = "UserController")
@RequestScoped
public class UserController {
	//this customerContactId is the index, don't confuse with the CustomerContact Id	 
	private int userId;
	private fit5042.tutex.repository.entities.User user;

	public UserController() {				
		 // Assign CustomerContact identifier via GET param 
        //this customerContactId is the index, don't confuse with the CustomerContact Id
		userId = Integer.valueOf(FacesContext.getCurrentInstance()
                .getExternalContext()
                .getRequestParameterMap()
                .get("userID"));
        // Assign property based on the id provided 		
        user = getUser();
       
        
	}
	
	//SETTER AND GETTER
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public fit5042.tutex.repository.entities.User getUser(){
		if (user == null) {
			// Get application context bean CustomerContactApplication 
            ELContext context = FacesContext.getCurrentInstance().getELContext();	
			UserApplication app = (UserApplication) FacesContext.getCurrentInstance()
                    .getApplication()
                    .getELResolver()
                    .getValue(context, null, "userApplication");
			// -1 to csutomerContactId since we +1 in JSF (to always have positive property id!) 
			//this customerContactId is the index, don't confuse with the Property Id
			return app.getUsers().get(--userId);
		}
			
	  return user;	
	}

}
