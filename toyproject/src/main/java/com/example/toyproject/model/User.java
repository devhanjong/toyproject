package com.example.toyproject.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import lombok.Data;

@Entity
@Data
public class User {
	@Id
	private String userID;
	private String userpassword;
	@Transient
	private String userpassword2;
	private String userName;
	private String userGender;
	private String userEmail;
	private String userEmailKey;
	
}
 