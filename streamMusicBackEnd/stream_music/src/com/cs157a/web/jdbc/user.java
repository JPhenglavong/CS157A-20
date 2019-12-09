package com.cs157a.web.jdbc;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Comparator;

public class user {
	private int id;
	private String username;
	private String firstName;
	private String lastName;
	private String password;
	private String email;
	private String time;
	private String profilePic;
	
	public user(String username, String firstName, String lastName, String email) {
		super();
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.setPassword("5f4dcc3b5aa765d61d8327deb882cf99");
		
		java.util.Date dt = new java.util.Date();
		java.text.SimpleDateFormat sdf = 
		new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String currentTime = sdf.format(dt);
		
		this.setTime(currentTime);
		this.setProfilePic("resource/images/profile/head.png");
	}
	
	public user(int id, String username, String firstName, String lastName, String email) {
		super();
		this.id = id;
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.setPassword("5f4dcc3b5aa765d61d8327deb882cf99");
		
		java.util.Date dt = new java.util.Date();
		java.text.SimpleDateFormat sdf = 
		new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String currentTime = sdf.format(dt);
		
		this.setTime(currentTime);
		this.setProfilePic("resource/images/profile/head.png");
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
	public String getProfilePic() {
		return profilePic;
	}

	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}
	
	
	@Override
	public String toString() {
		return "user [id=" + id + ", username=" + username + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + "]";
	}

    /**
     * Interface
     * @param ascending sorting order
     * @return an Interface
     */
    public static Comparator<user> comparatorByUserName(boolean ascending) {
        return (first, second) -> (ascending ? 1 : -1) * first.getUsername().compareTo(second.getUsername());
    }
    
    /**
     * Interface
     * @param ascending sorting order
     * @return an Interface
     */
    public static Comparator<user> comparatorByEmail(boolean ascending) {
        return (first, second) -> (ascending ? 1 : -1) * first.getEmail().compareTo(second.getEmail());
    }	

}
