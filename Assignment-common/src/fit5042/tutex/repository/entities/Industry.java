package fit5042.tutex.repository.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.Table;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import java.util.Set;

/*@author chengguang li*/

@Entity
@Table(name = "Industry")
@NamedQueries({
    @NamedQuery(name = Industry.GET_ALL_QUERY_NAME, query = "SELECT i FROM Industry i order by i.id desc")})
public class Industry implements Serializable {
	public static final String GET_ALL_QUERY_NAME = "Industry.getAll";
	private int id;
	
	private String typeName;
	
    private Set<Customer> customers;
    

    public Industry() {
    	
    }


	public Industry(int id, String typeName, Set<Customer> customers) {
		super();
		this.id = id;
		this.typeName = typeName;
		this.customers = customers;
	}
	
	// getter and setter method 
	
		@Id
	    @GeneratedValue
	    @Column(name = "id")
		public int getId() {
			return id;
		}


		public void setId(int id) {
			this.id = id;
		}

		@Column(name = "typeName")
		public String getTypeName() {
			return typeName;
		}


		public void setTypeName(String typeName) {
			this.typeName = typeName;
		}

		@OneToMany(mappedBy = "industry")
		public Set<Customer> getCustomers() {
			return customers;
		}


		public void setCustomers(Set<Customer> customers) {
			this.customers = customers;
		}
	    
		
		@Override
		public String toString() {
			return typeName;
		}
	
}
