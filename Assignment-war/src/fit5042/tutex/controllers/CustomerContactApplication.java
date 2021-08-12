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

import fit5042.tutex.mbeans.CustomerContactManagedBean;
import fit5042.tutex.repository.entities.CustomerContact;
import java.util.List;
/**
 * 
 * @author ChengGuang Li
 *
 */

@Named(value = "customerContactApplication")
@ApplicationScoped

public class CustomerContactApplication {
	
	 @ManagedProperty(value = "#{customerContactManagedBean}")
	   CustomerContactManagedBean customerContactManagedBean;
	 private boolean showForm = true;
	 
	 private ArrayList<CustomerContact> customerContacts;
	 
	 public boolean isShowForm() {
	        return showForm;
	 }
	 
	 public CustomerContactApplication() throws Exception{
		customerContacts = new ArrayList<>(); 
		//instantiate CustomerContactManagedBean
		ELContext elContext = FacesContext.getCurrentInstance().getELContext();
		customerContactManagedBean = (CustomerContactManagedBean) FacesContext.getCurrentInstance().getApplication()
	             .getELResolver().getValue(elContext, null, "customerContactManagedBean");
		
		//get customerContacts from db 
		updateCustomerContactsList(); 
	 }
	 
	 //customerContacts getter and setter 
	public ArrayList<CustomerContact> getCustomerContacts() {
		return customerContacts;
	}

	public void setCustomerContacts(ArrayList<CustomerContact> customerContacts) {
		this.customerContacts = customerContacts;
	}
	 
	 //when loading, and after adding or deleting, the Customer Contact list needs to be refreshed
    //this method is for that purpose
	 public void updateCustomerContactsList() {
		 if (customerContacts != null && customerContacts.size() > 0) {
			 
		 }else {
			 customerContacts.clear();
			 for(fit5042.tutex.repository.entities.CustomerContact cContact: customerContactManagedBean.getAllCustomerContacts()) {
				 customerContacts.add(cContact);
			 }
			 setCustomerContacts(customerContacts);
		 }
	 }
	 
	 public void searchCustomerContactById(int cContactId) {
		 customerContacts.clear();
		 customerContacts.add(customerContactManagedBean.searchCustomerContactById(cContactId));
		 
	 }
	 
	 
	 public void searchAll() {
		 customerContacts.clear();
		 
		 for(fit5042.tutex.repository.entities.CustomerContact cContact: customerContactManagedBean.getAllCustomerContacts()) {
			 customerContacts.add(cContact);
		 }
		 setCustomerContacts(customerContacts);
		 
	 }
	 
	 
	 public void searchCustomerContactByName(String name) {
		 customerContacts.clear();	
		 
		 List<CustomerContact> cContact = new ArrayList<CustomerContact>();
		 
		 try {
  
			 cContact = customerContactManagedBean.searchCustomerContactByName(name);
	   
			 customerContacts = new ArrayList<CustomerContact>(cContact);		 		 
				   
		 }catch(Exception e) {
				Logger.getLogger(CustomerContactManagedBean.class.getName()).log(Level.SEVERE, null, e);
				
			}
	 
	 }
	 
	 public void searchCustomerContactByGender(String gender) { 
		 customerContacts.clear();	
		 List<CustomerContact> cContact = new ArrayList<CustomerContact>();
		 try {
			 cContact = customerContactManagedBean.searchCustomerContactByGender(gender);
			 
			 customerContacts = new ArrayList<CustomerContact>(cContact);
			 
		 }catch(Exception e) {
				Logger.getLogger(CustomerContactManagedBean.class.getName()).log(Level.SEVERE, null, e);
				
			}
		 
	 
	 }
	 
	 public void searchCustomerContactByCombinationFields(String name,String gender) {
		 customerContacts.clear();
		 List<CustomerContact> cContact = new ArrayList<CustomerContact>();
		 try { 
			 cContact = customerContactManagedBean.searchCustomerContactByCombinationFields(name,gender);
			 
			 customerContacts = new ArrayList<CustomerContact>(cContact);
		  
		 }catch(Exception e) {
				Logger.getLogger(CustomerContactManagedBean.class.getName()).log(Level.SEVERE, null, e);
				
			}
	 
	 }

}
