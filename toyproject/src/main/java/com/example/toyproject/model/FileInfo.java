package com.example.toyproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class FileInfo {
	@Id
	private int fId; 
    private String fileName;     //저장할 파일
    private String fileOriginalName;  //실제 파일
    private String fileUrl;



}