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
@Named("removeUser")
public class removeUser {
	
	@ManagedProperty(value = "#{CustomerContactManagedBean}")
	   CustomerContactManagedBean customerContactManagedBean;
	private boolean showForm = true;
	
	UserApplication app;
	private User user;
	
	public boolean isShowForm() {
        return showForm;
    }
	//setter and getter method 

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public removeUser() {
		ELContext context = FacesContext.getCurrentInstance().getELContext();
		app = (UserApplication)FacesContext.getCurrentInstance()
                .getApplication()
                .getELResolver()
                .getValue(context, null, "userApplication");
		
		app.updateUserList();
		//instantiate CustomerContactManagedBean
	ELContext elContext = FacesContext.getCurrentInstance().getELContext();
		customerContactManagedBean = (CustomerContactManagedBean) FacesContext.getCurrentInstance().getApplication()
			             .getELResolver().getValue(elContext, null, "customerContactManagedBean");	
		
	}
	
	public void removeUser(int id) {
		
		try {
			customerContactManagedBean.removeUserAndGroup(id);
			 //refresh the list in CustomerContactApplication bean
            app.searchAll();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("User has been deleted succesfully"));
		}catch (Exception e) {
			
			
		}
		showForm = true;
	}
	
	

}
