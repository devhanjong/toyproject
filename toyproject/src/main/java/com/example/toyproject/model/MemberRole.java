package com.example.toyproject.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity 
@Table(name = "tbl_members_roles")
public class MemberRole {
	//�쉶�썝�쓽 沅뚰븳遺��뿬 �럹�씠吏�
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long fno;  //踰덊샇 
	
	private String rolename;  //沅뚰븳�쓽 �씠由�
	
	 
}
