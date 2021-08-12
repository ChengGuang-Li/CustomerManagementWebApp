package fit5042.tutex.repository.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the USERS database table.
 * 
 */
@Entity
@Table(name="USERS")
@NamedQuery(name= User.GET_ALL_QUERY_NAME, query="SELECT u FROM User u order by u.id desc")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	public static final String GET_ALL_QUERY_NAME = "User.findAll";
	@Id
	private int id;

	private String password;

	private String username;

	public User() {
		
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}