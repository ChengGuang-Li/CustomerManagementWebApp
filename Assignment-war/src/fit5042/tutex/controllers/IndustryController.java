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

@Named(value = "IndustryController")
@RequestScoped
public class IndustryController {
	
	private int id;
	private fit5042.tutex.repository.entities.Industry industry;
	
	public IndustryController() {
		// Assign Industry identifier via GET param 
        //this IndustryId is the index, don't confuse with the Industry Id
		id = Integer.valueOf(FacesContext.getCurrentInstance()
                .getExternalContext()
                .getRequestParameterMap()
                .get("industryID"));
		
		industry = getIndustry();
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public fit5042.tutex.repository.entities.Industry getIndustry() {
		if(industry == null) {
			
		// Get application context bean IndustryApplication 
       ELContext context = FacesContext.getCurrentInstance().getELContext();
		IndustryApplication app = (IndustryApplication)FacesContext.getCurrentInstance()
                .getApplication()
                .getELResolver()
                .getValue(context, null, "industryApplication");
		// -1 to industryId since we +1 in JSF (to always have positive industry id!) 
		//this industryId is the index, don't confuse with the industry Id
			return app.getIndustrys().get(--id);
		}
			
		return industry;
	}

	
	
	public void setIndustry(fit5042.tutex.repository.entities.Industry industry) {
		this.industry = industry;
	}
	
	
	

}
