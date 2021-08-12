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
@Named("addIndustry")
public class AddIndustry {
	@ManagedProperty(value = "#{customerContactManagedBean}")
	   CustomerContactManagedBean customerContactManagedBean;
	 private boolean showForm = true;
	 
	 private Industry industry;
	 
	 IndustryApplication app;
	 
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
	 
	 public AddIndustry() {
		 ELContext context = FacesContext.getCurrentInstance().getELContext();
			app = (IndustryApplication)FacesContext.getCurrentInstance()
		             .getApplication()
		             .getELResolver()
		             .getValue(context, null, "industryApplication");  
		 
			//instantiate CustomerContactManagedBean
			 ELContext elContext = FacesContext.getCurrentInstance().getELContext();
			 customerContactManagedBean = (CustomerContactManagedBean) FacesContext.getCurrentInstance().getApplication()
		             .getELResolver().getValue(elContext, null, "customerContactManagedBean");
		 
	 }
	 
	 
	public void addIndustry(Industry localIndustry) {
		
		
		try {
			customerContactManagedBean.addIndustry(localIndustry);
			app.searchAll();	 
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("New Industry has been added succesfully"));
			
		}catch (Exception e) {
			 
			 
		 }
		 showForm = true;
		
	}
	
	 
	 
}
