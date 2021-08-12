package fit5042.tutex.controllers;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.faces.context.FacesContext;

/**
 * 
 * @author ChengGuang Li
 *
 */
@Named(value = "titleController")
@RequestScoped
public class TitleController {

	 private String pageTitle;

	    public TitleController() {
	        // Set the page title 
	        pageTitle = "CM Web Application";
	    }

	    public String getPageTitle() {
	        return pageTitle;
	    }

	    public void setPageTitle(String pageTitle) {
	        this.pageTitle = pageTitle;
	    }
	
	
	
	
}
