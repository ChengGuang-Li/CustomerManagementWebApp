package fit5042.tutex.controllers;

import java.util.ArrayList;

import javax.el.ELContext;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import fit5042.tutex.repository.entities.Customer;
import fit5042.tutex.mbeans.CustomerContactManagedBean;

/**
 * 
 * @author ChengGuang Li
 *
 */


@Named(value = "customerApplication")
@ApplicationScoped
public class CustomerApplication {
   
	 @ManagedProperty(value = "#{customerContactManagedBean}")
	   CustomerContactManagedBean customerContactManagedBean;
	 private boolean showForm = true;
	 
	 private ArrayList<Customer> customers;
	 
	 public boolean isShowForm() {
	        return showForm;
	 }
	 
	 public CustomerApplication() throws Exception{
		 
		 customers = new ArrayList<>();
		//instantiate CustomerContactManagedBean
			ELContext elContext = FacesContext.getCurrentInstance().getELContext();
			customerContactManagedBean = (CustomerContactManagedBean) FacesContext.getCurrentInstance().getApplication()
		             .getELResolver().getValue(elContext, null, "customerContactManagedBean");
			
			//get customerContacts from db 
			updateCustomerList(); 
	 }
	 
	 //customers getter and setter
	public ArrayList<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(ArrayList<Customer> customers) {
		this.customers = customers;
	}
	 
	//when loading, and after adding or deleting, the Customer list needs to be refreshed
    //this method is for that purpose
    public void updateCustomerList() {
		
		  if (customers != null && customers.size() > 0) {
		  
		  }else {
		 
		    customers.clear();
			 for(fit5042.tutex.repository.entities.Customer customer: customerContactManagedBean.getAllCustomers()) {
				 customers.add(customer);
			 }
			 
			 setCustomers(customers);
			 
		 } 
    }
    
    public void searchCustomerById(int id) {
    	customers.clear();
    	customers.add(customerContactManagedBean.searchCustomerById(id));
    }
    
    public void searchAll() {
    	customers.clear();
    	 for(fit5042.tutex.repository.entities.Customer customer: customerContactManagedBean.getAllCustomers()) {
			 customers.add(customer);
		 }
		 
		 setCustomers(customers);
    }
    
	
}
