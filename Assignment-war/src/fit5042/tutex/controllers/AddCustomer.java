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
@Named("addCustomer")
public class AddCustomer {
	 @ManagedProperty(value = "#{customerContactManagedBean}")
	   CustomerContactManagedBean customerContactManagedBean;
	 private boolean showForm = true;
	 
	 private CustomerLocal customer;
	 
	 CustomerApplication app;
	 
	 public boolean isShowForm() {
	       return showForm;
	   }
    
	 
	//getter and setter method  
	public CustomerLocal getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerLocal customer) {
		this.customer = customer;
	}
	 
	public AddCustomer() {
		ELContext context = FacesContext.getCurrentInstance().getELContext();
		app = (CustomerApplication)FacesContext.getCurrentInstance()
	             .getApplication()
	             .getELResolver()
	             .getValue(context, null, "customerApplication"); 
		
		//instantiate CustomerContactManagedBean
		 ELContext elContext = FacesContext.getCurrentInstance().getELContext();
		 customerContactManagedBean = (CustomerContactManagedBean) FacesContext.getCurrentInstance().getApplication()
	             .getELResolver().getValue(elContext, null, "customerContactManagedBean");
		
	} 
	
	
	public void addCustomer(CustomerLocal localCustomer) {
		
		 try {
			 customerContactManagedBean.addCustomer(localCustomer);
			 app.searchAll();	 
			 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("New Customer has been added succesfully"));
		 }catch (Exception e) {
			 
			 
		 }
		showForm = true;
	}
	 

}
