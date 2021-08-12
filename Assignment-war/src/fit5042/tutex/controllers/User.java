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
@Named(value = "user")
public class User implements Serializable{
	private int id;

	private String password;

	private String username;
	
	
    //default constructor 
    public User() {
		
	}


	public User(int id, String password, String username) {
		super();
		this.id = id;
		this.password = password;
		this.username = username;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", password=" + password + ", username=" + username + "]";
	}

}
