package fit5042.tutex.repository.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/*@author chengguang li*/
@Entity
@Table(name = "Customer_Contact")
@NamedQueries({
    @NamedQuery(name = CustomerContact.GET_ALL_QUERY_NAME, query = "SELECT c FROM CustomerContact c order by c.contactId desc"),  
    @NamedQuery(name = CustomerContact.GET_From_FirstName, query = "SELECT c FROM CustomerContact c WHERE c.firstName = :firstName"),
    @NamedQuery(name = CustomerContact.GET_From_Gender, query = "SELECT c FROM CustomerContact c WHERE c.gender = :gender")
     })

public class CustomerContact implements Serializable{
	public static final String GET_ALL_QUERY_NAME = "CustomerContact.getAll";
	public static final String GET_From_FirstName = "CustomerContact.getCustomerContactsByFirstName";
	public static final String GET_From_Gender = "CustomerContact.getCustomerContactByGender";
	private int contactId;
	private String phoneNumber;
	private String email;
	private String firstName;
	private String lastName;
	private String gender;
	private Customer customer;
	
	//default constructor 
	public CustomerContact() {
		
	}
	
    // Constructor 
	public CustomerContact(int contactId, String phoneNumber, String email, String firstName, String lastName,
			String gender, Customer customer) {
		super();
		this.contactId = contactId;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.customer = customer;
	}

    //getter and setter method 
    
	@Id
    @GeneratedValue
    @Column(name = "contact_id")
	public int getContactId() {
		return contactId;
	}

	public void setContactId(int contactId) {
		this.contactId = contactId;
	}
     
	@Column(name = "phone_number")
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
    
	@Column(name = "first_name")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
    
	@Column(name = "last_name")
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
    
	//enforce the relationship between a Customer Contact  and its Cusomer using annotation(s). 
	//Each customer contact has one and only one customer. 
	//Each customer might be responsible for zero to many customer contact
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn
	public Customer getCustomer() {
		return customer;
		
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
   
	
	//toString 
	@Override
	public String toString() {
		return "contactId= " + contactId + ",  phoneNumber=" + phoneNumber + ",  email=" + email
				+ ",  firstName=" + firstName + ",  lastName=" + lastName + ",  gender=" + gender;
	}
	
	
	
}
