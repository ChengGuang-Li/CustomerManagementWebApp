package fit5042.tutex.controllers;

import javax.el.ELContext;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named(value = "CustomerController")
@RequestScoped
public class CustomerController {

	private int customerId;
	private fit5042.tutex.repository.entities.Customer customer;
	
	
	public CustomerController() {
		customerId = Integer.valueOf(FacesContext.getCurrentInstance()
                .getExternalContext()
                .getRequestParameterMap()
                .get("customerID"));
		// Assign property based on the id provided 
        customer = getCustomer();              
		
	}


	public int getCustomerId() {
		return customerId;
	}


	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	public fit5042.tutex.repository.entities.Customer getCustomer(){
		
		 if (customer == null) { 
			// Get application context bean CustomerApplication 
	         //customer = null;
            ELContext context = FacesContext.getCurrentInstance().getELContext();		
		CustomerApplication app =  (CustomerApplication) FacesContext.getCurrentInstance()
                .getApplication()
                .getELResolver()
                .getValue(context, null, "customerApplication");
			
			return app.getCustomers().get(--customerId);
			
	    }
	
		return customer;
	}
	
	
}
