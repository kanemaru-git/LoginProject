package jp.co.aforce.beans;

import java.io.Serializable;

@SuppressWarnings("serial")
public class RegisterBean implements Serializable{

	private String username;
	private String password;
	private String Emsg;
	private String gender;
	
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
	
	public String getEmsg() {
		return Emsg;
	}
	
	public void setEmsg(String emsg) {
		Emsg = emsg;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	

}
