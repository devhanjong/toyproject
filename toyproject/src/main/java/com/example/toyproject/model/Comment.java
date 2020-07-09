package com.example.toyproject.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int commentPrimeNo;
	
	private int commentNo;
	
	@ManyToOne
	@JoinColumn(name = "board_id")
	private Board board;
	
	private String content;
	private String userid;
	
	@UpdateTimestamp
	private LocalDateTime regdate;

}




