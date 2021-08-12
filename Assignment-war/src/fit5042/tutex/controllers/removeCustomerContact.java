package fit5042.tutex.controllers;

import java.util.logging.Level;
import java.util.logging.Logger;

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
@Named("removeCustomerContact")
public class removeCustomerContact {
 
	@ManagedProperty(value = "#{CustomerContactManagedBean}")
	   CustomerContactManagedBean customerContactManagedBean;
	private boolean showForm = true;
	
	CustomerContactApplication app;
	private CustomerContact customerContact;
	
	public boolean isShowForm() {
        return showForm;
    }
   
	//setter and getter method 
	public CustomerContact getCustomerContact() {
		return customerContact;
	}

	public void setCustomerContact(CustomerContact customerContact) {
		this.customerContact = customerContact;
	}
	
	public removeCustomerContact() {
		ELContext context = FacesContext.getCurrentInstance().getELContext();
		app = (CustomerContactApplication) FacesContext.getCurrentInstance()
                .getApplication()
                .getELResolver()
                .getValue(context, null, "customerContactApplication");	
		app.updateCustomerContactsList();
		
		//instantiate CustomerContactManagedBean
		ELContext elContext = FacesContext.getCurrentInstance().getELContext();
		customerContactManagedBean = (CustomerContactManagedBean) FacesContext.getCurrentInstance().getApplication()
	             .getELResolver().getValue(elContext, null, "customerContactManagedBean");		
	}
	
	public void removeCustomerContact(int cContactId) {
		
		try {
			customerContactManagedBean.removeCustomerContact(cContactId);
			 //refresh the list in CustomerContactApplication bean
            app.searchAll();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("CustomerContact has been deleted succesfully"));
		}catch(Exception e) {
			
		}
		showForm = true;
	}
	
	

	
	
}
