package com.example.toyproject.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class YoutubeVideoInfo {
	@Id
	
	private long Id;
	private String description;
	private String thumbnailUrl;
	private String title; 		//게시글 생성자
	private String videoId; 	//게시판 생성일자
	
}