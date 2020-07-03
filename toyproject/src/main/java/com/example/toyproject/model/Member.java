package com.example.toyproject.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import lombok.Data;

@Entity
@Data
public class Member {
	@Id
	private String memberID;
	private String memberPassword;
	private String memberName;
	private String memberEmail;
	private String accessAutority;//권한레벨
	
	
	
}
 