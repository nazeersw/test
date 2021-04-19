package com.hawaya.socialnetwork.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "USER")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	
	@Column(name = "FIRST_NAME",length=64)
	private String firstName;

	@Column(name = "LAST_NAME",length=64)	
	private String lastName;

	
	@Column(name = "EMAIL_ADDRESS",length=64,unique = true, nullable = false)	
	private String email;
	
	@Column(name= "PASSWORD",length=64, nullable = false)
	private String password;

	@Column(name= " PROFILE_PIC_URL",length=200)
	private String profilePicUrl;

	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private Set<Post> posts;


	public Long getID() {
		return id;
	}

	public void setID(Long id) {
		this.id = id;
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

	public String getProfilePicUrl() {
		return profilePicUrl;
	}

	public void setProfilePicUrl(String profilePicUrl) {
		this.profilePicUrl = profilePicUrl;
	}

	
	

		
	
	
}
