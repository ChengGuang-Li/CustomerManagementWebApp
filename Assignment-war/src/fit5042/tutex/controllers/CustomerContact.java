package fit5042.tutex.controllers;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import fit5042.tutex.repository.entities.*;

/**
 * 
 * @author ChengGuang Li
 *
 */
@RequestScoped
@Named(value = "customerContact")
public class CustomerContact implements Serializable{
	private int contactId;
	private String phoneNumber;
	private String email;
	private String firstName;
	private String lastName;
	private String gender;
	private fit5042.tutex.repository.entities.Customer customer;
	
	private int customerId;
	private String scale;
	private String name;
	private String purchasedProductName;
	private String country;
	private Industry industryType;
	private Address address;
	private Set<fit5042.tutex.repository.entities.CustomerContact> customerContacts;
	
	private String streetNumber;
    private String streetAddress;
    private String suburb;
    private String postcode;
    private String state;
    
    private int id;
	private String typeName;
	private Set<fit5042.tutex.repository.entities.Customer> customers;
    //default constructor 
    public CustomerContact() {
		
	}
    

	// Constructor 
    public CustomerContact(int contactId, String phoneNumber, String email, String firstName, String lastName,
			String gender, fit5042.tutex.repository.entities.Customer customer) {
		super();
		this.contactId = contactId;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.customer = customer;
	}
	
	//=================================================================================
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
  //=================================================================================
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Industry getIndustryType() {
		return industryType;
	}

	public void setIndustryType(Industry industryType) {
		this.industryType = industryType;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Set<fit5042.tutex.repository.entities.CustomerContact> getCustomerContacts() {
		return customerContacts;
	}

	public void setCustomerContacts(Set<fit5042.tutex.repository.entities.CustomerContact> customerContacts) {
		this.customerContacts = customerContacts;
	}
	//=================================================================================
    

    public int getContactId() {
		return contactId;
	}

	public void setContactId(int contactId) {
		this.contactId = contactId;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public fit5042.tutex.repository.entities.Customer getCustomer() {
		return customer;
	}

	public void setCustomer(fit5042.tutex.repository.entities.Customer customer) {
		this.customer = customer;
	}
	
	////////////////////////////////////////////

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
	
	
	//toString 
	@Override
	public String toString() {
		return "CustomerContact [contactId=" + contactId + ", phoneNumber=" + phoneNumber + ", email=" + email
				+ ", firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender + ", customer="
				+ customer + "]";
	}




	public Set<fit5042.tutex.repository.entities.Customer> getCustomers() {
		return customers;
	}


	public void setCustomers(Set<fit5042.tutex.repository.entities.Customer> customers) {
		this.customers = customers;
	}
	
}
