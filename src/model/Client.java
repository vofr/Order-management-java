package model;

import java.io.Serializable;

public class Client implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2187053659640625361L;
	private static int idUNIV=1;
	private int id;
	private String username;
	private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public int getNrOrders() {
		return nrOrders;
	}
	private int nrOrders;
	public Client(String username, String password) {
		this.id=idUNIV;
		idUNIV++;
		this.username=username;
		this.password=password;
		this.nrOrders=0;
	}
	public String toString() {
		return "username=" + username + " password=" + password ;
	}

}
