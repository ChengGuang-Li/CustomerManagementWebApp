package fit5042.tutex.controllers;

import java.util.ArrayList;

import javax.el.ELContext;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import fit5042.tutex.repository.entities.CustomerContact;

/**
 * 
 * @author ChengGuang Li
 *
 */

@Named(value = "ContactOfCustomerController")
@RequestScoped
public class ContactOfCustomerController {
	
	private int customerContactId;
	private fit5042.tutex.repository.entities.CustomerContact customerContact;
	
	public ContactOfCustomerController() {				
		 // Assign CustomerContact identifier via GET param 
        //this customerContactId is the index, don't confuse with the CustomerContact Id
		customerContactId = Integer.valueOf(FacesContext.getCurrentInstance()
                .getExternalContext()
                .getRequestParameterMap()
                .get("passCustomerContactId").trim());
        // Assign property based on the id provided 
        customerContact = getCustomerContact();
     

        
	}
	
	
	//SETTER AND GETTER
		public int getCustomerContactId() {
			return customerContactId;
		}

		public void setCustomerContactId(int customerContactId) {
			this.customerContactId = customerContactId;
		}

  public fit5042.tutex.repository.entities.CustomerContact getCustomerContact(){
			if (customerContact == null) {
				
				try {
				// Get application context bean CustomerContactApplication 
	            ELContext context = FacesContext.getCurrentInstance().getELContext();	
				CustomerContactApplication app = (CustomerContactApplication) FacesContext.getCurrentInstance()
	                    .getApplication()
	                    .getELResolver()
	                    .getValue(context, null, "customerContactApplication");
				// -1 to csutomerContactId since we +1 in JSF (to always have positive property id!) 
				//this customerContactId is the index, don't confuse with the Property Id
				
				app.searchAll();
			for(CustomerContact ct : app.getCustomerContacts()) {
				if(customerContactId == ct.getContactId()) {
					customerContact = ct;
					return  customerContact;					
				}								
			}
			
	  }catch(Exception e) {
		  
		  
	  }
			
	  }
				
		  return customerContact;	
  }
		
}
