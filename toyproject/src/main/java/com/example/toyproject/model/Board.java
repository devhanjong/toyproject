package com.example.toyproject.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters.LocalDateConverter;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Board {
	@Id
	@Convert(converter = LocalDateConverter.class)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long bbsId; 
	private String bbsTitle;
	
	@Column(length = 2048)
	private String bbsContent;
	
	
	@ManyToOne
	@JoinColumn(name =  "member_id")
	private Member member;
	 
	@UpdateTimestamp
	private LocalDate bbsCreateDate; 	//게시판 생성일자
	
	 
	private int views;  					//게시글 조회수
	
	
	//보드 -> 댓글 매핑 양방향 
	@JsonIgnore
	@OneToMany(mappedBy = "board")
	private List<Comment> comments = new ArrayList<>();
	 

}