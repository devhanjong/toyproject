package com.example.toyproject.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name = "tbl_members")
public class Member { 
	
	@Id
	private String uid;  //�쑀���븘�씠�뵒
	private String upw;  //�쑀�� 鍮꾨�踰덊샇
	private String uname;  //�쑀���씠由� 
	private String uemail;
	private int Enable;  //if 0 == disable ,, 1 = Enable
	private int failcount;
	
	
	@OneToMany(cascade = CascadeType.ALL , fetch = FetchType.EAGER)
	@JoinColumn(name= "member")
	private List<MemberRole> roles;  //�쉶�썝�쓽 沅뚰븳 
	
	@UpdateTimestamp
	private LocalDateTime updatedate;  //�쉶�썝�젙蹂� 理쒖쥌 �닔�젙�떆媛� 
}
