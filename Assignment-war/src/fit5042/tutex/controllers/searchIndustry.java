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
@Named("searchIndustry")
public class searchIndustry {
	private boolean showForm = true;
	private Industry industry;
	IndustryApplication app;
	private int searchByInt;
	
	
	public searchIndustry() {
		ELContext context = FacesContext.getCurrentInstance().getELContext();
		app = (IndustryApplication)FacesContext.getCurrentInstance()
	             .getApplication()
	             .getELResolver()
	             .getValue(context, null, "industryApplication");
		app.updateIndustryList();

	}
	public boolean isShowForm() {
        return showForm;
    }
	
	//getter and setter method
	public Industry getIndustry() {
		return industry;
	}
	public void setIndustry(Industry industry) {
		this.industry = industry;
	}
	public IndustryApplication getApp() {
		return app;
	}
	public void setApp(IndustryApplication app) {
		this.app = app;
	}
	public int getSearchByInt() {
		return searchByInt;
	}
	public void setSearchByInt(int searchByInt) {
		this.searchByInt = searchByInt;
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
     
    public void searchIndustryById(int id) {
    	try {
    		app.searchIndustryById(id);
    		
    	}catch(Exception e) {
 		   
 	   }
 	   showForm = true;
    	
    }
	
	

}
