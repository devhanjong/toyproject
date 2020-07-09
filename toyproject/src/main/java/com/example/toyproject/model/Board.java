package com.example.toyproject.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters.LocalDateConverter;

import lombok.Data;

@Entity
@Data
public class Board {
	@Id
	@Convert(converter = LocalDateConverter.class)
	private long bbsId;
	private String bbsTitle;
	private String bbsContent;
	private String AuthorMember; 		//게시글생성자(ID)
	
	@CreationTimestamp
	private LocalDate bbsCreateDate; 	
	private int views; 				
	private int comments;			
	
	
	@Column(name="o_file_name", length =1000)
	private String oFileName;
	@Column(name="s_file_name", length =1000)
	private String sFileName ;
	
	@Column(name="s_file_url", length =1000)
	private String sFileURL ;

}