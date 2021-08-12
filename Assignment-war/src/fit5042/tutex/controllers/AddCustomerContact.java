package fit5042.tutex.controllers;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.el.ELContext;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import fit5042.tutex.mbeans.CustomerContactManagedBean;

/**
 * 
 * @author ChengGuang Li
 *
 */

@RequestScoped
@Named("addCustomerContact")
public class AddCustomerContact {
	
   @ManagedProperty(value = "#{customerContactManagedBean}")
   CustomerContactManagedBean customerContactManagedBean;
   private boolean showForm = true;
   
   private CustomerContact customerContact;
   
   CustomerContactApplication app;
   
   public boolean isShowForm() {
       return showForm;
   }

   
  // customerContact getter and setter 
 public CustomerContact getCustomerContact() {
	return customerContact;
 }

 public void setCustomerContact(CustomerContact customerContact) {
	this.customerContact = customerContact;
 }
 
 public AddCustomerContact() {
	 ELContext context = FacesContext.getCurrentInstance().getELContext();
	 
	 app = (CustomerContactApplication) FacesContext.getCurrentInstance()
             .getApplication()
             .getELResolver()
             .getValue(context, null, "customerContactApplication");
	  //instantiate CustomerContactManagedBean
	 ELContext elContext = FacesContext.getCurrentInstance().getELContext();
	 customerContactManagedBean = (CustomerContactManagedBean) FacesContext.getCurrentInstance().getApplication()
             .getELResolver().getValue(elContext, null, "customerContactManagedBean");	 
 }
 
 public void addCustomerContact(CustomerContact localCustomerContact) {
	 
	 try {
		 customerContactManagedBean.addCustomerContact(localCustomerContact);
		 app.searchAll();	 
		 //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("New Customer Contact has been added succesfully"));
	 }catch(Exception e) {
		 Logger.getLogger(CustomerContactManagedBean.class.getName()).log(Level.SEVERE, null, e);
	 }
	 showForm = true;
 }
 
 public void addCustomerContactBySpecificCustomer(CustomerContact localCustomerContact){
	 
	 try {
		 customerContactManagedBean.addCustomerContactBySpecificCustomer(localCustomerContact);
		 app.searchAll();	 
		 //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("New Customer Contact has been added succesfully"));	 
		 FacesContext context = FacesContext.getCurrentInstance();
		 context.getExternalContext().redirect("http://localhost:8080/Assignment-war/faces/admin/allCustomerContact.xhtml");
		//FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("New Customer Contact has been added succesfully"));
	 }catch(Exception e) {
		 Logger.getLogger(CustomerContactManagedBean.class.getName()).log(Level.SEVERE, null, e);
	 }
	 //showForm = true;
 }

}
