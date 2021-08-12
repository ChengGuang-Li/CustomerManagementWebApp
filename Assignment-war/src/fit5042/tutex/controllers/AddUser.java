package fit5042.tutex.controllers;

import javax.el.ELContext;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import fit5042.tutex.mbeans.CustomerContactManagedBean;

/**
 * 
 * @author ChengGuang Li
 *
 */
@RequestScoped
@Named("addUser")
public class AddUser {
	 @ManagedProperty(value = "#{customerContactManagedBean}")
	   CustomerContactManagedBean customerContactManagedBean;
	 private boolean showForm = true;
	 
	 private User user;
	 
	 UserApplication app;
	 
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
	 
	public AddUser() {
		ELContext context = FacesContext.getCurrentInstance().getELContext();
		app = (UserApplication)FacesContext.getCurrentInstance()
	             .getApplication()
	             .getELResolver()
	             .getValue(context, null, "userApplication"); 
		
		//instantiate CustomerContactManagedBean
		 ELContext elContext = FacesContext.getCurrentInstance().getELContext();
		 customerContactManagedBean = (CustomerContactManagedBean) FacesContext.getCurrentInstance().getApplication()
	             .getELResolver().getValue(elContext, null, "customerContactManagedBean");
		
	} 
	
	
	public void addUser(User localUser) {
		
		 try {
			 customerContactManagedBean.addUserAndGroup(localUser);
			 app.searchAll();	 
			 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("New User has been added succesfully"));
		 }catch (Exception e) {
			 
			 
		 }
		showForm = true;
	}
	 

}
