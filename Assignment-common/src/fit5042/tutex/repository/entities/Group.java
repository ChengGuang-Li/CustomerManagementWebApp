package fit5042.tutex.repository.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the GROUPS database table.
 * 
 */
@Entity
@Table(name="GROUPS")
@NamedQuery(name=Group.GET_ALL_QUERY_NAME, query="SELECT g FROM Group g order by g.id desc")
public class Group implements Serializable {
	private static final long serialVersionUID = 1L;
    
	public static final String GET_ALL_QUERY_NAME = "Group.findAll";
	
	@Id
	private int id;

	private String groupname;

	private String username;

	public Group() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGroupname() {
		return this.groupname;
	}

	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}