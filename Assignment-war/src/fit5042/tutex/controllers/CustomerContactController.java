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

@Named(value = "CustomerContactController")
@RequestScoped
public class CustomerContactController {
	//this customerContactId is the index, don't confuse with the CustomerContact Id	 
	private int customerContactId;
	private fit5042.tutex.repository.entities.CustomerContact customerContact;
	
	public CustomerContactController() {				
		 // Assign CustomerContact identifier via GET param 
        //this customerContactId is the index, don't confuse with the CustomerContact Id
		customerContactId = Integer.valueOf(FacesContext.getCurrentInstance()
                .getExternalContext()
                .getRequestParameterMap()
                .get("customerContactID"));
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
			// Get application context bean CustomerContactApplication 
            ELContext context = FacesContext.getCurrentInstance().getELContext();	
			CustomerContactApplication app = (CustomerContactApplication) FacesContext.getCurrentInstance()
                    .getApplication()
                    .getELResolver()
                    .getValue(context, null, "customerContactApplication");
			// -1 to csutomerContactId since we +1 in JSF (to always have positive property id!) 
			//this customerContactId is the index, don't confuse with the Property Id
			return app.getCustomerContacts().get(--customerContactId);
		}
			
	  return customerContact;	
	}
	

}
