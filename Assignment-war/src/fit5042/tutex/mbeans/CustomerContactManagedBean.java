package fit5042.tutex.mbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import fit5042.tutex.controllers.UserController;
import fit5042.tutex.repository.ContactAndCustomerRepository;
import fit5042.tutex.repository.entities.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.math.BigInteger;

/**
 * 
 * @author ChengGuang Li
 *
 */

@ManagedBean(name = "customerContactManagedBean")
@SessionScoped
public class CustomerContactManagedBean implements Serializable {

	@EJB
	ContactAndCustomerRepository contactAndCustomerRepository;
	/**
	 * Creates a new instance of CustomerContactManagedBean
	 * 
	 */

	public String selectName;

	public String selectIndustry;

	private Customer customer1;

	private String password;

	private String companyScale;
	
	private String companyName;
	
	private int passInt;
	
	private List<CustomerContact> customerContacts;
	
	private  String  groupName;
	

	
	public CustomerContactManagedBean() {

	}

	public void logout() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().invalidateSession();
		try {
			context.getExternalContext().redirect("http://localhost:8080/Assignment-war/");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		

	public String getUserName() {
		String name = FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();

		return name;
	}

	public List<CustomerContact> getAllCustomerContacts() {

		try {

			if (contactAndCustomerRepository != null) {
				Logger.getLogger(CustomerContactManagedBean.class.getName()).log(Level.SEVERE, null,
						"customerContacts is not null ");

			} else {
				Logger.getLogger(CustomerContactManagedBean.class.getName()).log(Level.SEVERE, null,
						"customerContacts is null ");
			}

			List<CustomerContact> customerContacts = contactAndCustomerRepository.getAllCustomerContact();

			return customerContacts;
		} catch (Exception e) {
			Logger.getLogger(CustomerContactManagedBean.class.getName()).log(Level.SEVERE, null, e);
		}

		return null;
	}

	/**
	 * getter and setter method of selectName and selectIndustry
	 */

	public String getSelectName() {
		return selectName;
	}

	public void setSelectName(String selectName) {
		this.selectName = selectName;
	}

	public String getSelectIndustry() {
		return selectIndustry;
	}

	public void setSelectIndustry(String selectIndustry) {
		this.selectIndustry = selectIndustry;
	}

	public String getPassword() {
		return password;
	}
    
	public String getInputPassword() {
	      return "Input Password:  " + password;
	   }
	
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getCompanyScale() {
		return companyScale;
	}

	public void setCompanyScale(String companyScale) {
		this.companyScale = companyScale;
	}
	
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	public List<CustomerContact> getCustomerContacts() {
		return customerContacts;
	}

	public void setCustomerContacts(List<CustomerContact> customerContacts) {
		this.customerContacts = customerContacts;
	}
	
	public int getPassInt() {
		return passInt;
	}

	public void setPassInt(int passInt) {
		this.passInt = passInt;
	}
	

	
	public void jumpToRestFulUrl() {
		int idd;
		String[] result = {};
		try {

			result = selectName.split("\\-");
			idd = Integer.parseInt(result[0].trim());
		String url = "http://localhost:8080/Assignment-war/webresources/greeting/findCustomerById/" + idd;
		//FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(selectName));
		//FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(idd+""));
			
		 FacesContext context = FacesContext.getCurrentInstance();
		 context.getExternalContext().redirect(url);
			 
		}catch (Exception e) {
			Logger.getLogger(CustomerContactManagedBean.class.getName()).log(Level.SEVERE, null, e);
		}
		
	}

	/**
	 * get all customer
	 * 
	 */

	public List<Customer> getAllCustomers() {

		try {

			List<Customer> customerss = contactAndCustomerRepository.getAllCustomer();
			return customerss;
		} catch (Exception e) {
			Logger.getLogger(CustomerContactManagedBean.class.getName()).log(Level.SEVERE, null, e);
		}

		return null;

	}

	public List<Industry> getAllIndustrys() {

		try {

			List<Industry> industry = contactAndCustomerRepository.getAllIndustry();
			return industry;
		} catch (Exception e) {
			Logger.getLogger(CustomerContactManagedBean.class.getName()).log(Level.SEVERE, null, e);
		}

		return null;

	}

	/**
	 * search CustomerContact by its id
	 */

	public CustomerContact searchCustomerContactById(int id) {
		try {

			return contactAndCustomerRepository.searchCustomerContactById(id);
		} catch (Exception e) {
			Logger.getLogger(CustomerContactManagedBean.class.getName()).log(Level.SEVERE, null, e);
		}

		return null;
	}

	/**
	 * search Customer by its id
	 */

	public Customer searchCustomerById(int id) {
		try {

			return contactAndCustomerRepository.searchCustomerById(id);
		} catch (Exception e) {
			Logger.getLogger(CustomerContactManagedBean.class.getName()).log(Level.SEVERE, null, e);
		}

		return null;

	}

	/**
	 * search Industry by its id
	 */
	public Industry searchIndustryById(int id) {
		try {

			return contactAndCustomerRepository.searchIndustryById(id);
		} catch (Exception e) {
			Logger.getLogger(CustomerContactManagedBean.class.getName()).log(Level.SEVERE, null, e);
		}

		return null;

	}

	/**
	 * search CustomerContact by its customer
	 */

	public Set<CustomerContact> searchCustomerContactByCustomer(Customer customer) {
		try {

			return contactAndCustomerRepository.searchCustomerContactByCustomer(customer);
		} catch (Exception e) {
			Logger.getLogger(CustomerContactManagedBean.class.getName()).log(Level.SEVERE, null, e);
		}

		return null;

	}

	public void removeCustomerContact(int contactId) {
		try {

			contactAndCustomerRepository.removerCustomerContact(contactId);
		} catch (Exception e) {
			Logger.getLogger(CustomerContactManagedBean.class.getName()).log(Level.SEVERE, null, e);
		}

	}

	public void removeCustomer(int contactId) {
		try {

			contactAndCustomerRepository.removeCustomer(contactId);
		} catch (Exception e) {
			Logger.getLogger(CustomerContactManagedBean.class.getName()).log(Level.SEVERE, null, e);
		}

	}

	public void removeIndustry(int idD) {
		try {

			contactAndCustomerRepository.removeIndustry(idD);
		} catch (Exception e) {
			Logger.getLogger(CustomerContactManagedBean.class.getName()).log(Level.SEVERE, null, e);
		}

	}

	/**
	 * edit CustomerContact method
	 * 
	 * @param cContact
	 */

	public void editCustomerContact(CustomerContact cContact) {

		String[] result = {};
		int idd;
		try {
			result = selectName.split("\\-");
			idd = Integer.parseInt(result[0].trim());
			for (Customer c : contactAndCustomerRepository.getAllCustomer()) {
				if (c.getCustomerId() == idd) {

					customer1 = c;
					FacesContext.getCurrentInstance().addMessage(null,
							new FacesMessage("Customer Edited successfully"));
				}

			}
			if (customer1.getCustomerId() == 0) {

				customer1 = null;
			}

			cContact.setCustomer(customer1);

		} catch (Exception e) {

		}

		try {
			contactAndCustomerRepository.editCustomerContact(cContact);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("CustomerContact  has been updated succesfully"));
		} catch (Exception e) {
			Logger.getLogger(CustomerContactManagedBean.class.getName()).log(Level.SEVERE, null, e);
		}

	}

	
	public void display() {
		
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("success"));
		
	}	
	
	
	public void editCustomer(Customer customer) {
		Industry industry = new Industry();

		String name1;
		try {

			name1 = selectIndustry;

			for (Industry iddd : contactAndCustomerRepository.getAllIndustry()) {
				if (iddd.getTypeName().trim().equals(name1.trim())) {

					industry = iddd;

					FacesContext.getCurrentInstance().addMessage(null,
							new FacesMessage("Industry Edited successfully!!!!!"));
				}

			}

			if (industry.getId() == 0) {

				industry = null;
			}

		} catch (Exception e) {
			Logger.getLogger(CustomerContactManagedBean.class.getName()).log(Level.SEVERE, null, e);

		}
		customer.setIndustry(industry);

		try {
			contactAndCustomerRepository.editCustomer(customer);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("Customer has been updated succesfully"));
		} catch (Exception e) {
			Logger.getLogger(CustomerContactManagedBean.class.getName()).log(Level.SEVERE, null, e);
		}

	}

	public void editIndustry(Industry industry) {

		try {
			contactAndCustomerRepository.editIndustry(industry);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("Industry has been updated succesfully"));

		} catch (Exception e) {
			Logger.getLogger(CustomerContactManagedBean.class.getName()).log(Level.SEVERE, null, e);
		}

	}

	public void addCustomerContact(fit5042.tutex.controllers.CustomerContact localCustomerContact) {

		CustomerContact customerContact = convertCustomerContactToEntity(localCustomerContact);
		
		if(customerContact == null) {
			
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Add New Contact Failed !! Because input email already exists ")); 		
			return;
		}else {
			try {

				contactAndCustomerRepository.addCustomerContact(customerContact);
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("New Customer Contact has been added succesfully"));
			} catch (Exception e) {
				Logger.getLogger(CustomerContactManagedBean.class.getName()).log(Level.SEVERE, null, e);
			}
			
		}


	}

	private CustomerContact convertCustomerContactToEntity(
			fit5042.tutex.controllers.CustomerContact localCustomerContact) {
		// entity
		CustomerContact customerContact = new CustomerContact();
		// Address
		String streetNumber = localCustomerContact.getStreetNumber();
		String streetAddress = localCustomerContact.getStreetAddress();
		String suburb = localCustomerContact.getSuburb();
		String postcode = localCustomerContact.getPostcode();
		String state = localCustomerContact.getState();
		Address address = new Address(streetNumber, streetAddress, suburb, postcode, state);
		// ********************************************************************************
		// Customer
		/*
		 * int customerId = localCustomerContact.getCustomerId(); String scale =
		 * localCustomerContact.getScale(); String name =
		 * localCustomerContact.getName(); String purchasedProductName =
		 * localCustomerContact.getPurchasedProductName(); String country =
		 * localCustomerContact.getCountry(); String industryType =
		 * localCustomerContact.getIndustryType(); customer = new
		 * fit5042.tutex.repository.entities.Customer(customerId,scale,name,
		 * purchasedProductName,country,industryType,address);
		 */
		String[] result = {};
		String Name;
		int idd;
		try {

			result = selectName.split("\\-");
			idd = Integer.parseInt(result[0].trim());
			Name = result[2];
			//FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(Name));

			for (Customer c : contactAndCustomerRepository.getAllCustomer()) {
				if (c.getCustomerId() == idd) {

					customer1 = c;
					//FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Customer added successfully"));
				}

			}

			if (customer1.getCustomerId() == 0) {

				customer1 = null;
			}
			//FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("CustomerId " + customer1.getCustomerId()));

		} catch (Exception e) {
			Logger.getLogger(CustomerContactManagedBean.class.getName()).log(Level.SEVERE, null, e);

		}

		customerContact.setCustomer(customer1);
		// ******************************************************************
		// CustomerContact
		customerContact.setPhoneNumber(localCustomerContact.getPhoneNumber());
		//validation email cannot be same as existed email 
		try {
		for(CustomerContact ct: contactAndCustomerRepository.getAllCustomerContact()) {
		  if(ct.getEmail().trim().equals(localCustomerContact.getEmail().trim())) {
			  
			 return null; 
		  }	
					
		}
		
	  } catch(Exception e) {
		  
		  Logger.getLogger(CustomerContactManagedBean.class.getName()).log(Level.SEVERE, null, e);
	  }
		
		customerContact.setEmail(localCustomerContact.getEmail());
		customerContact.setFirstName(localCustomerContact.getFirstName());
		customerContact.setLastName(localCustomerContact.getLastName());
		customerContact.setGender(localCustomerContact.getGender());

		return customerContact;
	}

	public void addCustomer(fit5042.tutex.controllers.CustomerLocal localCustomer) {

		Customer customer = convertCustomerToEntity(localCustomer);
		try {

			contactAndCustomerRepository.addCustomer(customer);
		} catch (Exception e) {
			Logger.getLogger(CustomerContactManagedBean.class.getName()).log(Level.SEVERE, null, e);
		}

	}

	private Customer convertCustomerToEntity(fit5042.tutex.controllers.CustomerLocal localCustomer) {

		Customer customer = new Customer();

		String streetNumber = localCustomer.getStreetNumber();
		String streetAddress = localCustomer.getStreetAddress();
		String suburb = localCustomer.getSuburb();
		String postcode = localCustomer.getPostcode();
		String state = localCustomer.getState();
		Address address = new Address(streetNumber, streetAddress, suburb, postcode, state);

		customer.setAddress(address);
		Industry industry = new Industry();

		String name1;
		try {

			name1 = selectIndustry;
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(selectIndustry));

			for (Industry iddd : contactAndCustomerRepository.getAllIndustry()) {
				if (iddd.getTypeName().trim().equals(name1.trim())) {

					industry = iddd;

					FacesContext.getCurrentInstance().addMessage(null,
							new FacesMessage("Industry added successfully!!!!!"));
				}

			}

			if (industry.getId() == 0) {

				industry = null;
			}

		} catch (Exception e) {
			Logger.getLogger(CustomerContactManagedBean.class.getName()).log(Level.SEVERE, null, e);

		}
		customer.setIndustry(industry);

		customer.setName(localCustomer.getName());
		customer.setScale(localCustomer.getScale());
		customer.setCountry(localCustomer.getCountry());
		customer.setCity(localCustomer.getCity());
		customer.setRegisterDate(localCustomer.getRegisterDate());
		customer.setPurchasedProductName(localCustomer.getPurchasedProductName());
		return customer;
	}

	public void addIndustry(fit5042.tutex.controllers.Industry localIndustry) {

		Industry industry = convertIndustryToEntity(localIndustry);
		try {

			contactAndCustomerRepository.addIndustry(industry);
		} catch (Exception e) {
			Logger.getLogger(CustomerContactManagedBean.class.getName()).log(Level.SEVERE, null, e);
		}

	}

	private Industry convertIndustryToEntity(fit5042.tutex.controllers.Industry localIndustry) {

		Industry industry = new Industry();

		industry.setTypeName(localIndustry.getTypeName());

		return industry;
	}

	// combine search fucntions

	public List<CustomerContact> searchCustomerContactByGender(String passGender) {

		try {

			return contactAndCustomerRepository.searchCustomerContactByGender(passGender);
		} catch (Exception e) {
			Logger.getLogger(CustomerContactManagedBean.class.getName()).log(Level.SEVERE, null, e);

		}

		return null;

	}

	public List<CustomerContact> searchCustomerContactByName(String passName) {
		try {
			List<CustomerContact> customerContact = new ArrayList<CustomerContact>();

			customerContact = contactAndCustomerRepository.searchCustomerContactByName(passName);

			return customerContact;

		} catch (Exception e) {
			Logger.getLogger(CustomerContactManagedBean.class.getName()).log(Level.SEVERE, null, e);

		}

		return null;

	}

	public List<CustomerContact> searchCustomerContactByCombinationFields(String name, String gender) {
		try {

			return contactAndCustomerRepository.searchCustomerContactByCombinationFields(name, gender);

		} catch (Exception e) {
			Logger.getLogger(CustomerContactManagedBean.class.getName()).log(Level.SEVERE, null, e);

		}

		return null;
	}
    
	
	public boolean checkValidity (String str) {
		String regex = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{4,10}$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(str);
		if (m.matches()) {
			return true;
		} else {
			return false;
		}
	}
	
	
	
	public void changePassword() {
		String name = FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();
		
		boolean  verify;
		verify = checkValidity(password.trim());
	
		if (verify) {
			// FacesContext.getCurrentInstance().addMessage(null, new
			// FacesMessage(name.trim()));
			User userEdit = new User();

			try {

				String passwordInput = getSHA256(this.getPassword());

				List<User> users = contactAndCustomerRepository.getAllUser();
				for (User user : users) {
					if (name.trim().equals(user.getUsername().trim())) {

						if (user.getPassword().trim().equals(passwordInput.trim())) {

						FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("New Password cannot be same as the old password"));
							return;

						} else {

							user.setPassword(passwordInput);
							userEdit = user;

						}

					}
				}

				if (name.trim().equals(userEdit.getUsername().trim())) {

					contactAndCustomerRepository.editUser(userEdit);
					FacesContext.getCurrentInstance().addMessage(null,
							new FacesMessage("New Password has been updated succesfully"));
				}

			} catch (Exception e) {
				Logger.getLogger(CustomerContactManagedBean.class.getName()).log(Level.SEVERE, null, e);

			}

		} else {

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Password is invalide!! Password contains at least numbers and English, length 4-10"));

		}

	}

	public static String getSHA256(String input) {

		try {

			// Static getInstance method is called with hashing SHA
			MessageDigest md = MessageDigest.getInstance("SHA-256");

			// digest() method called
			// to calculate message digest of an input
			// and return array of byte
			byte[] messageDigest = md.digest(input.getBytes());

			// Convert byte array into signum representation
			BigInteger no = new BigInteger(1, messageDigest);

			// Convert message digest into hex value
			String hashtext = no.toString(16);

			while (hashtext.length() < 32) {
				hashtext = "0" + hashtext;
			}

			return hashtext;
		}

		// For specifying wrong message digest algorithms
		catch (NoSuchAlgorithmException e) {
			System.out.println("Exception thrown" + " for incorrect algorithm: " + e);

			return null;
		}
	}
	
	
	
  //search fucntion
	
  public void searchCustomerContactByCustomerDetail() {	  	  	  
	  try {	 
	  List<CustomerContact> customerContactTemp = new ArrayList<CustomerContact>();	  
	////////////////////////////////////////////////////////////////////////////////////  
	  if(companyScale.trim().length() != 0 && companyName.trim().length() == 0) {
		  customerContactTemp.clear();
		 customerContactTemp = contactAndCustomerRepository.searchCustomerContactByCompanyScale(companyScale.trim());
		if(customerContactTemp.size() == 0) {			
		 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Search Result is empty"));
		 return;
		}else {	
			customerContacts = customerContactTemp;
			FacesContext context = FacesContext.getCurrentInstance();
			  context.getExternalContext().redirect("http://localhost:8080/Assignment-war/faces/admin/searchResult.xhtml");	 
		}
				  
	  }else if(companyScale.trim().length() == 0 && companyName.trim().length() != 0) {
		  customerContactTemp.clear();
	    customerContactTemp = contactAndCustomerRepository.searchCustomerContactByCompanyName(companyName.trim());
		if(customerContactTemp.size() == 0){			
			 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Search Result is empty"));
			 return;
			}else {  
				customerContacts = customerContactTemp;
				FacesContext context = FacesContext.getCurrentInstance();
				  context.getExternalContext().redirect("http://localhost:8080/Assignment-war/faces/admin/searchResult.xhtml");	
				
	     }
	  }else if(companyScale.trim().length() != 0 && companyName.trim().length() != 0) {
		  customerContactTemp.clear();
		customerContactTemp = contactAndCustomerRepository.searchCustomerContactByCompanyScaleAndName(companyScale.trim(),companyName.trim());  
		if(customerContactTemp.size() == 0){			
			 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Search Result is empty"));
			 return;
			}else {  
				customerContacts = customerContactTemp;
				FacesContext context = FacesContext.getCurrentInstance();
				  context.getExternalContext().redirect("http://localhost:8080/Assignment-war/faces/admin/searchResult.xhtml");	
				
	     } 
		    
	  }	  	  
	  }catch (Exception e) {
			Logger.getLogger(CustomerContactManagedBean.class.getName()).log(Level.SEVERE, null, e);

		}
	  
	  
  }
  
  
  public String getSpecificCustomerId() {
	  
	  passInt = Integer.valueOf(FacesContext.getCurrentInstance()
              .getExternalContext()
              .getRequestParameterMap()
              .get("passCustomerId"));
	  
	  FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Customer Id: "+passInt));
	  
	  String returnName;
	  try {
	  for(Customer ct: contactAndCustomerRepository.getAllCustomer()) {
		if(ct.getCustomerId() == passInt) {
			
			returnName = ct.getName();
			return returnName;
			
		}
		  
		  
	  }  
	  }catch(Exception e) {
		  
		  
	  }
	  
	  return null;
	  
  }
  
  public void addCustomerContactBySpecificCustomer(fit5042.tutex.controllers.CustomerContact localCustomerContact) {

		CustomerContact customerContact = convertCustomerContactOfSpecificCustomerToEntity(localCustomerContact);
		
		if(customerContact == null) {
			
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Add New Contact Failed !! Because input email already exists ")); 		
			return;
		}else {
			try {

				contactAndCustomerRepository.addCustomerContact(customerContact);
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("New Customer Contact has been added succesfully"));
			} catch (Exception e) {
				Logger.getLogger(CustomerContactManagedBean.class.getName()).log(Level.SEVERE, null, e);
			}
			
		}


	}

	private CustomerContact convertCustomerContactOfSpecificCustomerToEntity(fit5042.tutex.controllers.CustomerContact localCustomerContact) {
		// entity
		CustomerContact customerContact = new CustomerContact();
		try {
			for (Customer c : contactAndCustomerRepository.getAllCustomer()) {
				if (c.getCustomerId() == passInt) {

					customer1 = c;
					//FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Customer added successfully"));
				}

			}

			if (customer1.getCustomerId() == 0) {

				customer1 = null;
			}
			//FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("CustomerId " + customer1.getCustomerId()));

		} catch (Exception e) {
			Logger.getLogger(CustomerContactManagedBean.class.getName()).log(Level.SEVERE, null, e);

		}

		customerContact.setCustomer(customer1);
		// ******************************************************************
		// CustomerContact
		customerContact.setPhoneNumber(localCustomerContact.getPhoneNumber());
		//validation email cannot be same as existed email 
		try {
		for(CustomerContact ct: contactAndCustomerRepository.getAllCustomerContact()) {
		  if(ct.getEmail().trim().equals(localCustomerContact.getEmail().trim())) {
			  
			 return null; 
		  }	
					
		}
		
	  } catch(Exception e) {
		  
		  Logger.getLogger(CustomerContactManagedBean.class.getName()).log(Level.SEVERE, null, e);
	  }
		
		customerContact.setEmail(localCustomerContact.getEmail());
		customerContact.setFirstName(localCustomerContact.getFirstName());
		customerContact.setLastName(localCustomerContact.getLastName());
		customerContact.setGender(localCustomerContact.getGender());

		return customerContact;
	}

 /////////////////////////////////////////////////////////////////////////////////////////////
  //Method about user and group
	 public void addUserAndGroup(fit5042.tutex.controllers.User localUser) {
		 User userTemp = new User();
		 userTemp.setUsername(localUser.getUsername().trim());
		 String passwordTemp = getSHA256(localUser.getPassword().trim());
		 userTemp.setPassword(passwordTemp);
		 
		 Group groupTemp = new Group();	 
		 groupTemp.setGroupname("user");
		 groupTemp.setUsername(localUser.getUsername().trim());
		 
		 try {
			 contactAndCustomerRepository.addUser(userTemp);
			 contactAndCustomerRepository.addGroup(groupTemp);
			 
		 } catch(Exception e) {
			  
			  Logger.getLogger(CustomerContactManagedBean.class.getName()).log(Level.SEVERE, null, e);
		  }
		 		 
	 }
	 
	 public List<User> getAllUsers(){
		 
		 try {

		List<User> users = contactAndCustomerRepository.getAllUser();
		return users;
				
		} catch (Exception e) {
				Logger.getLogger(CustomerContactManagedBean.class.getName()).log(Level.SEVERE, null, e);
	     }

	 return null;
	 }
	 
	 
	 public User searchUserById(int id) {
		 try {

				return contactAndCustomerRepository.searchUserById(id);
			} catch (Exception e) {
				Logger.getLogger(CustomerContactManagedBean.class.getName()).log(Level.SEVERE, null, e);
			}

			return null;
		 
	 }
	 
	 public void removeUserAndGroup(int id) {
		 try {
			 
			     contactAndCustomerRepository.deleteUser(id);
				contactAndCustomerRepository.deleteGroup(id);
				
			} catch (Exception e) {
				Logger.getLogger(CustomerContactManagedBean.class.getName()).log(Level.SEVERE, null, e);
			} 
		 
		 
	 }
	 
	 public List<Group> getAllGroups(){
		 
		 try {

		List<Group> groups = contactAndCustomerRepository.getAllGroup();
		return groups;
				
		} catch (Exception e) {
				Logger.getLogger(CustomerContactManagedBean.class.getName()).log(Level.SEVERE, null, e);
	     }

	 return null;
	 }
	
	 
	 public void editUser(User user) {		
		 int idTemp = user.getId();
		 String Temp = "";
	 try {
		  for(User user1: getAllUsers()) {
			  if(user1.getId() == idTemp)
			  Temp = user1.getUsername();	  
		  }  	
		   Group groupTemp = new Group();		
		for(Group group: getAllGroups()) {
			if(group.getUsername().trim().equals(Temp.trim())) {			
				groupTemp = group;				
			}
	
		}	
		groupTemp.setUsername(user.getUsername());
		contactAndCustomerRepository.editGroup(groupTemp);
		
		String password =  getSHA256(user.getPassword().trim());
		
		user.setPassword(password);
		contactAndCustomerRepository.editUser(user);		
		FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage("User has been updated succesfully"));

			} catch (Exception e) {
				Logger.getLogger(CustomerContactManagedBean.class.getName()).log(Level.SEVERE, null, e);
			}
		 
		 
	 }
	 
	 
	 public String getGroupName() {
		int userId = Integer.valueOf(FacesContext.getCurrentInstance()
                .getExternalContext()
                .getRequestParameterMap()
                .get("userID"));
		// FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(userId + ""));
		int count = getAllUsers().size();
		// FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(count + ""));
		 
        int[] store = new int[count];
        int repeat = count;
        
		for(int i=0;i<repeat;i++) {
			store[i] = count;
		    count = count-1;
		}
		int k;	
		k = store[userId-1];
		//FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(k + ""));
		String userName = ""; 	
	   for(User user: getAllUsers()) {
		   if(user.getId() == k) {		
			   userName = user.getUsername();	
		   }		   
	   }
		
	   try {  
	  for(Group group: getAllGroups()) {
		 if(group.getUsername().trim().equals(userName.trim())) {
			 groupName = group.getGroupname(); 
		 } 
	  
	  }
	   
	  }catch (Exception e) {
			Logger.getLogger(CustomerContactManagedBean.class.getName()).log(Level.SEVERE, null, e);
	     }
	  
	   return groupName;
	 }
	 
	 public void assignAsUser() {
		 int idd = Integer.valueOf(FacesContext.getCurrentInstance()
	                .getExternalContext()
	                .getRequestParameterMap()
	                .get("customerID"));
		 int count = getAllCustomers().size(); 
	        int[] store = new int[count];
	        int repeat = count;
	        
			for(int i=0;i<repeat;i++) {
				store[i] = count;
			    count = count-1;
			}
			int k;	
			k = store[idd-1];
		 
          String name = ""; 
          for(Customer c: getAllCustomers()) {
        	  if(c.getCustomerId() == k) {
        		  name = c.getName();
        	  }
          }
			
         User userTemp = new User();
 		 String passwordTemp = getSHA256("123");
 		 userTemp.setPassword(passwordTemp);
 		 userTemp.setUsername(name);
 		 
 		 
 		 Group groupTemp = new Group();	 
 		 groupTemp.setGroupname("user");
 		 groupTemp.setUsername(name);
 		 
 		 try {
 			 contactAndCustomerRepository.addUser(userTemp);
 			 contactAndCustomerRepository.addGroup(groupTemp);
 	 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Successfully!The user name is customer name And default password is 123")); 
 		 } catch(Exception e) {
 			  
 			  Logger.getLogger(CustomerContactManagedBean.class.getName()).log(Level.SEVERE, null, e);
 		  }
          
          
			
	 }
	 
	 
}
