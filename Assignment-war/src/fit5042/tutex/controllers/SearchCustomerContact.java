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
@Named("searchCustomerContact")
public class SearchCustomerContact {
	 private boolean showForm = true;
	 private CustomerContact customerContact;	 
	 CustomerContactApplication app;
	 
	 private int searchByInt;
	 private double searchByDouble;
	 
	 private String gender;
	 private String firstName;
	 
	 public SearchCustomerContact() {
		 ELContext context = FacesContext.getCurrentInstance().getELContext();
		 
		 app = (CustomerContactApplication) FacesContext.getCurrentInstance()
	             .getApplication()
	             .getELResolver()
	             .getValue(context, null, "customerContactApplication");
	 
		 app.updateCustomerContactsList(); 
	 }
	 
	 public boolean isShowForm() {
	        return showForm;
	    }
	 //getter and setter method 
	public CustomerContact getCustomerContact() {
		return customerContact;
	}

	public void setCustomerContact(CustomerContact customerContact) {
		this.customerContact = customerContact;
	}

	public int getSearchByInt() {
		return searchByInt;
	}

	public void setSearchByInt(int searchByInt) {
		this.searchByInt = searchByInt;
	}

	public double getSearchByDouble() {
		return searchByDouble;
	}

	public void setSearchByDouble(double searchByDouble) {
		this.searchByDouble = searchByDouble;
	}
	public CustomerContactApplication getApp() {
		return app;
	}
	public void setApp(CustomerContactApplication app) {
		this.app = app;
	}
	
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
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
	
	public void searchCustomerContactById(int cContactId ) {
		try {
			  //search this customerContact then refresh the list in CustomerContactApplication bean
			app.searchCustomerContactById(cContactId);
			
		}catch(Exception e) {
			
		}
		showForm = true;
		
		
	} 
	
	
	public void searchCombinationResults() {
		try {
			  //search this customerContact then refresh the list in CustomerContactApplication bean
        if(firstName.trim().length() != 0 && gender.trim().length() == 0 ) { 
		  FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(firstName.trim()));

		  app.searchCustomerContactByName(firstName);
		    
        }else if (firstName.trim().length() == 0 && gender.trim().length() != 0 ) {
        	
        	FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(gender.trim()));
        	app.searchCustomerContactByGender(gender);
        	
        }else if (firstName.trim().length() != 0 && gender.trim().length() != 0 ) {        	  	
        	
        	FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Gender Input: "+gender+"   FirstName Input:"+firstName));
        	app.searchCustomerContactByCombinationFields(firstName.trim(),gender.trim());
        }
						
			
		}catch(Exception e) {
			Logger.getLogger(CustomerContactManagedBean.class.getName()).log(Level.SEVERE, null, e);
		}
		showForm = true;

	}
	
	
	
}
