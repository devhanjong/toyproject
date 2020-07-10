package com.example.toyproject.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class YoutubeVideoInfo {
	@Id
	private long id;
	private String description;
	private String thumbnailUrl;
	private String title; 		//게시글 생성자
	private String videoId; 	//게시판 생성일자
	
	
}