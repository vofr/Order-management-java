package model;

import java.io.Serializable;

public class Admin implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4027253435517096650L;

	private String username;
	private String password;
	@Override
	public String toString() {
		return "username=" + username + " password=" + password ;
	}
	public String getPassword() {
		return password;
	}
	public Admin(String username, String password) {
		this.username=username;
		this.password=password;
	}
	public String getUsername() {
		return username;
	}
}
