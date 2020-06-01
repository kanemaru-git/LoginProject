package jp.co.aforce.beans;

import java.io.Serializable;

@SuppressWarnings("serial")
public class UserBean implements Serializable {

	private String user_id;
	private String username;
	private String password;
	private String gender;
	
	public UserBean() {}
	
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
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
	
//	public UserBean(String user_id,String username, String password, String gender) {
//		this.user_id = user_id;
//		this.username = username;
//		this.password = password;
//		this.gender = gender;
//	}
	
	
}
