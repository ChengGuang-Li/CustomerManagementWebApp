package fit5042.tutex.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.Root;

import fit5042.tutex.repository.entities.Customer;
import fit5042.tutex.repository.entities.CustomerContact;
import fit5042.tutex.repository.entities.Group;
import fit5042.tutex.repository.entities.Industry;
import fit5042.tutex.repository.entities.User;

import javax.persistence.TypedQuery;

/**
 * 
 * @author ChengGuang Li
 *
 */
@Stateless
public class JPAContactAndCustomerRepositorylmpl implements ContactAndCustomerRepository {

	@PersistenceContext(unitName = "Assignment-ejbPU")
	private EntityManager entityManager;

	@Override
	public void addCustomer(Customer customer) throws Exception {
		// TODO Auto-generated method stub
		List<Customer> customers = entityManager.createNamedQuery(Customer.GET_ALL_QUERY_NAME).getResultList();
		customer.setCustomerId(customers.get(0).getCustomerId() + 1);
		entityManager.persist(customer);
	}

	@Override
	public Customer searchCustomerById(int customerId) throws Exception {
		// TODO Auto-generated method stub

		Customer customer = entityManager.find(Customer.class, customerId);
		return customer;
	}

	@Override
	public void removeCustomer(int customerId) throws Exception {
		// TODO Auto-generated method stub
		// Create a Criteria Builder
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		// Create a delete
		CriteriaDelete<Customer> delete = builder.createCriteriaDelete(Customer.class);
		// Create a root property
		Root<Customer> c = delete.from(Customer.class);
		// set where clause and execute
		delete.where(builder.equal(c.get("customerId"), customerId));
		// perform update
		entityManager.createQuery(delete).executeUpdate();
	}

	@Override
	public void editCustomer(Customer customer) throws Exception {
		// TODO Auto-generated method stub
		try {
			entityManager.merge(customer);
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	@Override
	public void addCustomerContact(CustomerContact cContact) throws Exception {
		// TODO Auto-generated method stub
		List<CustomerContact> contacts = entityManager.createNamedQuery(CustomerContact.GET_ALL_QUERY_NAME)
				.getResultList();
		cContact.setContactId(contacts.get(0).getContactId() + 1);
		entityManager.persist(cContact);

	}

	@Override
	public CustomerContact searchCustomerContactById(int contactId) throws Exception {
		// TODO Auto-generated method stub

		CustomerContact customerContact = entityManager.find(CustomerContact.class, contactId);
		return customerContact;
	}

	@Override
	public void removerCustomerContact(int contactId) throws Exception {
		// TODO Auto-generated method stub
		// Create a Criteria Builder
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		// Create a delete
		CriteriaDelete<CustomerContact> delete = builder.createCriteriaDelete(CustomerContact.class);
		// Create a root property
		Root<CustomerContact> c = delete.from(CustomerContact.class);
		// set where clause and execute
		delete.where(builder.equal(c.get("contactId"), contactId));
		// perform update
		entityManager.createQuery(delete).executeUpdate();

	}

	@Override
	public void editCustomerContact(CustomerContact cContact) throws Exception {
		// TODO Auto-generated method stub
		try {
			entityManager.merge(cContact);
		} catch (Exception ex) {
			System.out.println(ex);
		}

	}

	@Override
	public List<Customer> getAllCustomer() throws Exception {
		// TODO Auto-generated method stub
		// entityManager.clear();

		List<Customer> customerss = entityManager.createNamedQuery(Customer.GET_ALL_QUERY_NAME).getResultList();

		return customerss;
	}

	@Override
	public List<CustomerContact> getAllCustomerContact() throws Exception {
		// TODO Auto-generated method stub
		return entityManager.createNamedQuery(CustomerContact.GET_ALL_QUERY_NAME).getResultList();
	}

	@Override
	public Set<CustomerContact> searchCustomerContactByCustomer(Customer customer) throws Exception {
		customer = entityManager.find(Customer.class, customer.getCustomerId());
		customer.getCustomerContact().size();
		entityManager.refresh(customer);

		return customer.getCustomerContact();
	}

	/*
	 * Industry Method
	 */
	@Override
	public void addIndustry(Industry industry) throws Exception {

		List<Industry> industrys = entityManager.createNamedQuery(Industry.GET_ALL_QUERY_NAME).getResultList();
		industry.setId(industrys.get(0).getId() + 1);
		entityManager.persist(industry);

	}

	@Override
	public Industry searchIndustryById(int id) throws Exception {
		Industry industry = entityManager.find(Industry.class, id);
		return industry;

	}

	@Override
	public List<Industry> getAllIndustry() throws Exception {

		return entityManager.createNamedQuery(Industry.GET_ALL_QUERY_NAME).getResultList();

	}

	@Override
	public void removeIndustry(int id) throws Exception {
		// TODO Auto-generated method stub
		// Create a Criteria Builder
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		// Create a delete
		CriteriaDelete<Industry> delete = builder.createCriteriaDelete(Industry.class);
		// Create a root property
		Root<Industry> in = delete.from(Industry.class);
		// set where clause and execute
		delete.where(builder.equal(in.get("id"), id));
		// perform update
		entityManager.createQuery(delete).executeUpdate();

	}

	@Override
	public void editIndustry(Industry industry) throws Exception {

		try {
			entityManager.merge(industry);
		} catch (Exception ex) {
			System.out.println(ex);
		}

	}

	// Combination Search Functions

	@Override
	public List<CustomerContact> searchCustomerContactByName(String passName) throws Exception {

		List<CustomerContact> customerContact = new ArrayList<CustomerContact>();

		customerContact = entityManager.createNamedQuery(CustomerContact.GET_From_FirstName)
				.setParameter("firstName", passName).getResultList();
		return customerContact;
	}

	@Override
	public List<CustomerContact> searchCustomerContactByCombinationFields(String name, String gender) throws Exception {

		TypedQuery<CustomerContact> query = entityManager.createQuery(
				"SELECT c FROM CustomerContact c WHERE c.gender = :gender AND c.firstName = :firstName",
				CustomerContact.class);
		query.setParameter("gender", gender);
		query.setParameter("firstName", name);
		return query.getResultList();
	}

	@Override
	public List<CustomerContact> searchCustomerContactByGender(String passGender) throws Exception {
		// TODO Auto-generated method stub

		return entityManager.createNamedQuery(CustomerContact.GET_From_Gender).setParameter("gender", passGender)
				.getResultList();

	}

	// User methods including add / getAll / edit method

	@Override
	public void editUser(User user) throws Exception {
		try {
			entityManager.merge(user);
		} catch (Exception ex) {
			System.out.println(ex);
		}

	}

	@Override
	public void addUser(User user) throws Exception {

		List<User> users = entityManager.createNamedQuery(User.GET_ALL_QUERY_NAME).getResultList();
		user.setId(users.get(0).getId() + 1);
		entityManager.persist(user);

	}

	@Override
	public List<User> getAllUser() throws Exception {
		// TODO Auto-generated method stub
		return entityManager.createNamedQuery(User.GET_ALL_QUERY_NAME).getResultList();
	}

	@Override
	public void addGroup(Group group) throws Exception {
		// TODO Auto-generated method stub

		List<Group> groups = entityManager.createNamedQuery(Group.GET_ALL_QUERY_NAME).getResultList();
		group.setId(groups.get(0).getId() + 1);
		entityManager.persist(group);

	}

	// Search function
	@Override
	public List<CustomerContact> searchCustomerContactByCompanyScale(String scale) throws Exception {
		// TODO Auto-generated method stub
		List<CustomerContact> customerContact = new ArrayList<CustomerContact>();
		customerContact = entityManager.createQuery("Select ct From CustomerContact AS ct WHERE ct.customer.scale = :scale",CustomerContact.class)
				.setParameter("scale", scale)
				.getResultList();
		return customerContact;
	}

	@Override
	public List<CustomerContact> searchCustomerContactByCompanyName(String name) throws Exception {
		// TODO Auto-generated method stub
		List<CustomerContact> customerContact = new ArrayList<CustomerContact>();
		customerContact = entityManager.createQuery("Select ct From CustomerContact AS ct WHERE ct.customer.name = :name",CustomerContact.class)
				.setParameter("name", name)
				.getResultList();
		return customerContact;
	}

	@Override
	public List<CustomerContact> searchCustomerContactByCompanyScaleAndName(String scale, String name)
			throws Exception {
		// TODO Auto-generated method stub
		List<CustomerContact> customerContact = new ArrayList<CustomerContact>();
		customerContact = entityManager.createQuery("Select ct From CustomerContact AS ct WHERE ct.customer.name = :name AND ct.customer.scale = :scale",CustomerContact.class)
				.setParameter("name", name)
				.setParameter("scale", scale)
				.getResultList();
		return customerContact;
	}

	@Override
	public void deleteUser(int id) throws Exception {
		// TODO Auto-generated method stub
		// Create a Criteria Builder
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		// Create a delete
		CriteriaDelete<User> delete = builder.createCriteriaDelete(User.class);
		// Create a root property
		Root<User> u = delete.from(User.class);
		// set where clause and execute
		delete.where(builder.equal(u.get("id"), id));
		// perform update
		entityManager.createQuery(delete).executeUpdate();
		
	}

	@Override
	public void editGroup(Group group) throws Exception {
		try {
			entityManager.merge(group);
		} catch (Exception ex) {
			System.out.println(ex);
		}
		
	}

	@Override
	public List<Group> getAllGroup() throws Exception {
		// TODO Auto-generated method stub
		return entityManager.createNamedQuery(Group.GET_ALL_QUERY_NAME).getResultList();
	}

	@Override
	public void deleteGroup(int id) throws Exception {
		// TODO Auto-generated method stub
		// Create a Criteria Builder
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		// Create a delete
		CriteriaDelete<Group> delete = builder.createCriteriaDelete(Group.class);
		// Create a root property
		Root<Group> g = delete.from(Group.class);
		// set where clause and execute
		delete.where(builder.equal(g.get("id"), id));
		// perform update
		entityManager.createQuery(delete).executeUpdate();
		
	}

	@Override
	public User searchUserById(int id) throws Exception {
		User user = entityManager.find(User.class,id);
		return user;
	}

	@Override
	public List<User> getUser() throws Exception {

		TypedQuery<User> query = entityManager.createQuery("SELECT u FROM user u ",User.class);
		return query.getResultList();
	}

}
