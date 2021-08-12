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
@Named("removeCustomer")
public class removeCustomer {
	
	@ManagedProperty(value = "#{CustomerContactManagedBean}")
	   CustomerContactManagedBean customerContactManagedBean;
	private boolean showForm = true;
	
	CustomerApplication app;
	private CustomerLocal customer;
	
	public boolean isShowForm() {
        return showForm;
    }
	//setter and getter method 

	public CustomerLocal getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerLocal customer) {
		this.customer = customer;
	}
	
	public removeCustomer() {
		ELContext context = FacesContext.getCurrentInstance().getELContext();
		app = (CustomerApplication)FacesContext.getCurrentInstance()
                .getApplication()
                .getELResolver()
                .getValue(context, null, "customerApplication");
		
		app.updateCustomerList();
		//instantiate CustomerContactManagedBean
	ELContext elContext = FacesContext.getCurrentInstance().getELContext();
		customerContactManagedBean = (CustomerContactManagedBean) FacesContext.getCurrentInstance().getApplication()
			             .getELResolver().getValue(elContext, null, "customerContactManagedBean");	
		
	}
	
	public void removeCustomer(int cId) {
		
		try {
			customerContactManagedBean.removeCustomer(cId);
			 //refresh the list in CustomerContactApplication bean
            app.searchAll();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Customer has been deleted succesfully"));
		}catch (Exception e) {
			
			
		}
		showForm = true;
	}
	
	

}
