package fit5042.tutex.controllers;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import fit5042.tutex.repository.entities.Address;
import fit5042.tutex.repository.entities.Industry;

/**
 * 
 * @author ChengGuang Li
 *
 */
@RequestScoped
@Named(value = "customerLocal")
public class CustomerLocal implements Serializable{
	
	private int customerId;
	private String scale;
	private String name;
	
	private String purchasedProductName;
	private String country;
	private String city;
	private Date registerDate;
	private fit5042.tutex.repository.entities.Industry industry;
	private fit5042.tutex.repository.entities.Address address;
	private Set<fit5042.tutex.repository.entities.CustomerContact> customerContacts;
	
	
	private String streetNumber;
    private String streetAddress;
    private String suburb;
    private String postcode;
    private String state;
    
    private int id;
	private String typeName;
    private Set<fit5042.tutex.repository.entities.Customer> customers;
	
	public CustomerLocal() {
		
		
	}

	public CustomerLocal(int customerId, String scale, String name, String purchasedProductName, String country,
			String city,Date registerDate, Industry industry, Address address) {
		super();
		this.customerId = customerId;
		this.scale = scale;
		this.name = name;
		this.purchasedProductName = purchasedProductName;
		this.country = country;
		this.city = city;
		this.registerDate = registerDate;
		this.industry = industry;
		this.address = address;
	}
 
  //Customer 
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getScale() {
		return scale;
	}

	public void setScale(String scale) {
		this.scale = scale;
	}

	public String getPurchasedProductName() {
		return purchasedProductName;
	}

	public void setPurchasedProductName(String purchasedProductName) {
		this.purchasedProductName = purchasedProductName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
    
	public Date getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
	
	
	public fit5042.tutex.repository.entities.Industry getIndustry() {
		return industry;
	}

	public void setIndustry(fit5042.tutex.repository.entities.Industry industry) {
		this.industry = industry;
	}

	public fit5042.tutex.repository.entities.Address getAddress() {
		return address;
	}

	public void setAddress(fit5042.tutex.repository.entities.Address address) {
		this.address = address;
	}

	public Set<fit5042.tutex.repository.entities.CustomerContact> getCustomerContacts() {
		return customerContacts;
	}

	public void setCustomerContacts(Set<fit5042.tutex.repository.entities.CustomerContact> customerContacts) {
		this.customerContacts = customerContacts;
	}

	
	//Address 
	public String getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getSuburb() {
		return suburb;
	}

	public void setSuburb(String suburb) {
		this.suburb = suburb;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	
	//Industry
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
