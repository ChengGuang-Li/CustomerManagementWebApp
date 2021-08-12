package fit5042.tutex.repository.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.text.SimpleDateFormat;

/*@author chengguang li*/

@Entity
@Table(name = "Customer")
@NamedQueries({
    @NamedQuery(name = Customer.GET_ALL_QUERY_NAME, query = "SELECT c FROM Customer c order by c.customerId desc")})

public class Customer implements Serializable{
	public static final String GET_ALL_QUERY_NAME = "Customer.getAll";
	
	private int customerId;
	private String scale;
	private String name;
	private String purchasedProductName;
	private String country;
	private String city;
	private Date registerDate;
	private Industry industry;
	private Address address;
	private Set<CustomerContact> customerContacts;
	
	// default constructoer 
	public Customer() {
		
	}
	// constructor
	public Customer(int customerId, String scale, String name, String purchasedProductName, String country,String city,Date registerDate, Industry industryType,
			Address address) {
		//super();
		this.customerId = customerId;
		this.scale = scale;
		this.name = name;
		this.purchasedProductName = purchasedProductName;
		this.country = country;
		this.city = city;
		this.registerDate = registerDate;
		this.industry = industryType;
		this.address = address;
		this.customerContacts = new HashSet<>();
	}
	

   // get and set method 
	@Id
    @GeneratedValue
    @Column(name = "customer_id")
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
	
	@Column(name="purchased_productName")
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
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn
	public Industry getIndustry() {
		return industry;
	}
	public void setIndustry(Industry industryType) {
		this.industry = industryType;
	}
	//insert annotation here to make addess as embeded to Property entity and stored as part of Property
	 @Embedded
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	@OneToMany(mappedBy = "customer",cascade = CascadeType.PERSIST,fetch=FetchType.EAGER)
	public Set<CustomerContact> getCustomerContact() {
		return customerContacts;
	}
	public void setCustomerContact(Set<CustomerContact> customerContacts) {
		this.customerContacts = customerContacts;
	}
	@Temporal(TemporalType.DATE)
	@Column(name="REGISTER_DATE")
	public Date getRegisterDate() {

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = df.format(registerDate);
		
		try {
		Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
		return date1;
		}catch(Exception e) {
			
			
		}
	return null;
	}
	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
	
	
	/*
	 * //override hashcode method
	 * 
	 * @Override public int hashCode() { int hash = 7; hash = 53 * hash +
	 * this.customerId; return hash; }
	 * 
	 * //overrite equals method
	 * 
	 * @Override public boolean equals(Object obj) { if (obj == null) { return
	 * false; } if (getClass() != obj.getClass()) { return false; }
	 * 
	 * final Customer ct = (Customer) obj; if (this.customerId != ct.customerId) {
	 * return false; } return true; }
	 */
	 
	
	
	// to String 
	@Override
	public String toString() {
		return  customerId + "-" + scale + "-" + name + "-" + purchasedProductName + "-" + country + "-" + city + "-" + industry + "-" + address;			
	}
	
	
    
     
}
