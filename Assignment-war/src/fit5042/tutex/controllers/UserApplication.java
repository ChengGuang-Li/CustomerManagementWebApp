package fit5042.tutex.controllers;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.el.ELContext;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import fit5042.tutex.repository.entities.Group;
import fit5042.tutex.repository.entities.User;
import fit5042.tutex.mbeans.CustomerContactManagedBean;

/**
 * 
 * @author ChengGuang Li
 *
 */


@Named(value = "userApplication")
@ApplicationScoped
public class UserApplication {
   
	 @ManagedProperty(value = "#{customerContactManagedBean}")
	   CustomerContactManagedBean customerContactManagedBean;
	 private boolean showForm = true;
	 
	 private ArrayList<User> users;

	 
	 public boolean isShowForm() {
	        return showForm;
	 }
	 
	 public UserApplication() throws Exception{
		 
		 users = new ArrayList<>();
		//instantiate CustomerContactManagedBean
			ELContext elContext = FacesContext.getCurrentInstance().getELContext();
			customerContactManagedBean = (CustomerContactManagedBean) FacesContext.getCurrentInstance().getApplication()
		             .getELResolver().getValue(elContext, null, "customerContactManagedBean");
			
			//get customerContacts from db 
			updateUserList(); 
			
	 }
	 
	 //customers getter and setter
	public ArrayList<User> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}
	 
	
	//when loading, and after adding or deleting, the Customer list needs to be refreshed
    //this method is for that purpose
    public void updateUserList() {
		
		  if (users != null && users.size() > 0) {
		  
		  }else {
		 
		    users.clear();
			 for(fit5042.tutex.repository.entities.User user: customerContactManagedBean.getAllUsers()) {
				 users.add(user);
			 }
			 
			 setUsers(users);
			 
		 } 
    }
    
    public void searchUserById(int id) {
    	try {
    	users.clear();
    	users.add(customerContactManagedBean.searchUserById(id));
    	
    	
     	}catch(Exception e) {
 		   Logger.getLogger(CustomerContactManagedBean.class.getName()).log(Level.SEVERE, null, e);
 	   }
    }
    
    public void searchAll() {
    	users.clear();
    	 for(fit5042.tutex.repository.entities.User user: customerContactManagedBean.getAllUsers()) {
			 users.add(user);
		 }
		 
		 setUsers(users);
    }
    
}
