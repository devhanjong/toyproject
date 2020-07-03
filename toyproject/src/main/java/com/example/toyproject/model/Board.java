package com.example.toyproject.model;

import java.time.LocalDate;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters.LocalDateConverter;

import lombok.Data;

@Entity
@Data
public class Board {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Convert(converter = LocalDateConverter.class)
	private long bbsId;
	private String bbsTitle;
	private String bbsContent;
	private String AuthorMemberId; 		//게시글 생성자
	private LocalDate bbsCreateDate; 	//게시판 생성일자
	private int views; 					//게시글 조회수
	private int comments;				//게시글 댓글수
}