package fit5042.tutex.controllers;

import java.util.logging.Level;
import java.util.logging.Logger;

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
@Named("removeIndustry")
public class removeIndustry {
	@ManagedProperty(value = "#{CustomerContactManagedBean}")
	   CustomerContactManagedBean customerContactManagedBean;
	private boolean showForm = true;
	
	IndustryApplication app;
	private Industry industry;
	
	public boolean isShowForm() {
        return showForm;
    }

	public Industry getIndustry() {
		return industry;
	}

	public void setIndustry(Industry industry) {
		this.industry = industry;
	}
	
	public removeIndustry() {
		 ELContext context = FacesContext.getCurrentInstance().getELContext();
			app = (IndustryApplication)FacesContext.getCurrentInstance()
		             .getApplication()
		             .getELResolver()
		             .getValue(context, null, "industryApplication");
			app.updateIndustryList();
			
			//instantiate CustomerContactManagedBean
			ELContext elContext = FacesContext.getCurrentInstance().getELContext();
			customerContactManagedBean = (CustomerContactManagedBean) FacesContext.getCurrentInstance().getApplication()
		             .getELResolver().getValue(elContext, null, "customerContactManagedBean");	
		
	}
	
	
	public void removeIndustrys(int id) {
		
		try {
				customerContactManagedBean.removeIndustry(id);				
			 //refresh the list in CustomerContactApplication bean
            app.searchAll();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Industry has been deleted succesfully"));
		}catch(Exception e) {
			Logger.getLogger(CustomerContactManagedBean.class.getName()).log(Level.SEVERE, null, e);
		}
		showForm = true;
		
	}
}
