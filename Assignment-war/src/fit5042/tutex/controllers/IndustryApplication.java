package fit5042.tutex.controllers;

import java.util.ArrayList;

import javax.el.ELContext;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import fit5042.tutex.repository.entities.Industry;
import fit5042.tutex.mbeans.CustomerContactManagedBean;

/**
 * 
 * @author ChengGuang Li
 *
 */


@Named(value = "industryApplication")
@ApplicationScoped
public class IndustryApplication {
	
	 @ManagedProperty(value = "#{customerContactManagedBean}")
	   CustomerContactManagedBean customerContactManagedBean;
	 private boolean showForm = true;
	 
	 private ArrayList<Industry> industrys;
	 
	 public boolean isShowForm() {
	        return showForm;
	 }
	 
	 public IndustryApplication() throws Exception{
		 industrys = new ArrayList<>();
		//instantiate CustomerContactManagedBean
			ELContext elContext = FacesContext.getCurrentInstance().getELContext();
			customerContactManagedBean = (CustomerContactManagedBean) FacesContext.getCurrentInstance().getApplication()
		             .getELResolver().getValue(elContext, null, "customerContactManagedBean");
			
			//get customerContacts from db 
			updateIndustryList();
		 
	 }

	public ArrayList<Industry> getIndustrys() {
		return industrys;
	}

	public void setIndustrys(ArrayList<Industry> industrys) {
		this.industrys = industrys;
	}
	 
	 
	public void updateIndustryList() {
		
		if(industrys != null  && industrys.size() > 0 ) {
	
			
		}else {
			
			industrys.clear();
			
			for(fit5042.tutex.repository.entities.Industry industry: customerContactManagedBean.getAllIndustrys()) {
				
				industrys.add(industry);				
				
			}
			
			setIndustrys(industrys);
			
		}
	}
	
	
	
	 public void searchIndustryById(int id) {
		 industrys.clear();
		 industrys.add(customerContactManagedBean.searchIndustryById(id));
		 
	 }
   
	 
	 public void searchAll() {
		 industrys.clear();
		 for(fit5042.tutex.repository.entities.Industry industry: customerContactManagedBean.getAllIndustrys()) {
				
				industrys.add(industry);				
				
			}
			
			setIndustrys(industrys);
	 }
}
