package fit5042.tutex.controllers;
import java.util.List;

import javax.el.ELContext;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import fit5042.tutex.mbeans.CustomerContactManagedBean;
import fit5042.tutex.repository.entities.Customer; 

@FacesConverter(forClass = fit5042.tutex.repository.entities.Customer.class, value = "customer")

public class CustomerConverter implements Converter  {
	@ManagedProperty(value = "#{customerContactManagedBean}")
	   CustomerContactManagedBean customerContactManagedBean;

	public List<Customer> customerDB;
	
	public CustomerConverter() {
		
		try {
			//instantiate CustomerContactManagedBean
			ELContext elContext = FacesContext.getCurrentInstance().getELContext();
			customerContactManagedBean = (CustomerContactManagedBean) FacesContext.getCurrentInstance().getApplication()
		             .getELResolver().getValue(elContext, null, "customerContactManagedBean");
			
		customerDB = customerContactManagedBean.getAllCustomers();
			
		}catch(Exception e) {
			
			
		}
		
	}

	//this method is for converting the submitted value (as String) to the customer object
    //the reason for using this method is, the dropdown box in the xhtml does not capture the customer object, but the String.
		
	
	public Object getAsObject(FacesContext facesContext, UIComponent component, String submittedValue) {
		if (submittedValue.trim().equals("")) {
            return null;
        } else {
        	
        	try {
        		int number = Integer.parseInt(submittedValue);
        	  for (Customer c: customerDB) {
        		  if (c.getCustomerId() == number) {
                      return c;
                  }	  
        		  
        	  } 

        	}catch (NumberFormatException exception) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid Customer"));
            }
        	
   	        	
        }
				
		return null;
		
	}

	
	public String getAsString(FacesContext facesContext, UIComponent component, Object value) {
		if (value == null || value.equals("")) {
            return "";
        } else {
        	
        	return String.valueOf(((Customer) value).getCustomerId());
        	
        }
	}
	
	
	
   
	
	
	
}
