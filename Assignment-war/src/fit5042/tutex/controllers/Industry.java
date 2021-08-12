package fit5042.tutex.controllers;

import java.io.Serializable;
import java.util.Set;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import fit5042.tutex.repository.entities.Customer;

@RequestScoped
@Named(value = "industry")
public class Industry implements Serializable{
   private int id;
   
   private String typeName;
   
   private Set<fit5042.tutex.repository.entities.Customer>  customers;
	
	
   public Industry() {
	   
	   
   }


  public Industry(int id, String typeName) {
	super();
	this.id = id;
	this.typeName = typeName;
  }


public int getId() {
	return id;
}


public void setId(int id) {
	this.id = id;
}


public String getTypeName() {
	return typeName;
}


public void setTypeName(String typeName) {
	this.typeName = typeName;
}


public Set<fit5042.tutex.repository.entities.Customer> getCustomers() {
	return customers;
}


public void setCustomers(Set<fit5042.tutex.repository.entities.Customer> customers) {
	this.customers = customers;
}
   
   
   
	
}
