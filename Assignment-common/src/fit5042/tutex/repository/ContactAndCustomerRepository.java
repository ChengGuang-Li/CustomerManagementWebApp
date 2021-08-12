package fit5042.tutex.repository;
import java.util.List;
import java.util.Set;
import javax.ejb.Remote;

import fit5042.tutex.repository.entities.Customer;
import fit5042.tutex.repository.entities.CustomerContact;
import fit5042.tutex.repository.entities.Group;
import fit5042.tutex.repository.entities.Industry;
import fit5042.tutex.repository.entities.User;



/**
 * @autor chengguang li
 */
@Remote
public interface ContactAndCustomerRepository {

/**
 * Add the Customer info being passed as parameter into the repository
 *
 * @param Customer - the Customer to add
 */
public void addCustomer(Customer customer) throws Exception;

/**
 * Search for a Customer by its customerID
 *
 * @param id - the customerId of the customer to search for
 * @return the customer found
 */
public Customer searchCustomerById(int customerId) throws Exception;

/**
 * Remove the Customer, whose  CustomerID matches the one being passed as
 * parameter, from the repository
 *
 * @param customerId - the ID of the customer to remove
 */
public void removeCustomer(int customerId) throws Exception;

/**
 * Update a Customer in the repository
 *
 * @param customer - the updated information regarding a customer
 */
public void editCustomer(Customer customer) throws Exception;

/*******************************************************************************/
/**
 * Add the CustomerContact info being passed as parameter into the repository
 *
 * @param CustomerContact - the CustomerContact to add
 */
public void addCustomerContact(CustomerContact cContact) throws Exception;
/**
 * Search for a CustomerContact by its customerContactID
 *
 * @param id - the customerContactId of the customer to search for
 * @return the customerContact found
 */
public CustomerContact searchCustomerContactById(int contactId) throws Exception;
/**
 * Remove the CustomerContact, whose  CustomerContactID matches the one being passed as
 * parameter, from the repository
 *
 * @param customerContactId - the ID of the customerContact to remove
 */
public void removerCustomerContact(int contactId)throws Exception;

/**
 * Update a CustomerContact in the repository
 *
 * @param customer - the updated information regarding a customerContact
 */
public void editCustomerContact(CustomerContact cContact) throws Exception;

/****************************************************************************/

/**
 * Return all the customers in the repository
 *
 * @return all the customers in the repository
 */

public List<Customer> getAllCustomer() throws Exception;

/**
 * Return all the customerContacts in the repository
 *
 * @return all the customerContacts in the repository
 */
public List<CustomerContact> getAllCustomerContact() throws Exception; 

/**************************************************************************/
/**
 * Search for customerContacts by their Customer
 *
 * @param Customer - the Customer that is responsible for the Customer Contact
 * 
 * @return the CustomerContacts found
 */
public Set<CustomerContact> searchCustomerContactByCustomer(Customer customer) throws Exception;

/**
 *  Industry method 
 */

public void addIndustry(Industry industry) throws Exception;

public Industry searchIndustryById(int id) throws Exception;

public List<Industry> getAllIndustry() throws Exception;

public void removeIndustry(int id) throws Exception;

public void editIndustry(Industry industry) throws Exception;


//search combinations function
public List<CustomerContact> searchCustomerContactByName(String passName) throws Exception;

public List<CustomerContact> searchCustomerContactByGender(String passGender) throws Exception;

public List<CustomerContact> searchCustomerContactByCombinationFields(String name,String gender) throws Exception;


//User methods including add / getAll / edit method

public void editUser(User user) throws Exception;

public void addUser(User user) throws Exception;

public List<User> getAllUser() throws Exception;

public void deleteUser(int id) throws Exception;

public User searchUserById(int id) throws Exception;

public void addGroup(Group group)throws Exception;

public void editGroup(Group group) throws Exception;

public List<Group> getAllGroup() throws Exception;

public void deleteGroup(int id) throws Exception;

public List<User> getUser() throws Exception;

//search function 

public List<CustomerContact> searchCustomerContactByCompanyScale(String scale) throws Exception;
	  
public List<CustomerContact> searchCustomerContactByCompanyName(String name) throws Exception;
	  
public List<CustomerContact> searchCustomerContactByCompanyScaleAndName(String scale,String name) throws Exception;
	 
}

