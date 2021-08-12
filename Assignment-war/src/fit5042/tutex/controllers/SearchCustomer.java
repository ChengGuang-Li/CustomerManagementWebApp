package fit5042.tutex.controllers;

import javax.el.ELContext;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;


/**
 * 
 * @author ChengGuang Li
 *
 */
@RequestScoped
@Named("searchCustomer")
public class SearchCustomer {
	private boolean showForm = true;
	private CustomerLocal customer;
	CustomerApplication app;
	
	private int searchByInt;
	
	public SearchCustomer() {
		ELContext context = FacesContext.getCurrentInstance().getELContext();
		app = (CustomerApplication)FacesContext.getCurrentInstance()
                .getApplication()
                .getELResolver()
                .getValue(context, null, "customerApplication");
		app.updateCustomerList();
		
	}
	
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

	public int getSearchByInt() {
		return searchByInt;
	}

	public void setSearchByInt(int searchByInt) {
		this.searchByInt = searchByInt;
	}

	public CustomerApplication getApp() {
		return app;
	}

	public void setApp(CustomerApplication app) {
		this.app = app;
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
	
	
   public void searchCustomerById(int cId) {
	   try {
		 //search this customer then refresh the list in CustomerApplication bean
		   app.searchCustomerById(cId);
		   
	   }catch(Exception e) {
		   
	   }
	   showForm = true;
	   
   }
   
   
   
   
	
	
}
