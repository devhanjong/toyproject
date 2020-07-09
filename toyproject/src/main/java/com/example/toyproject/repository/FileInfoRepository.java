package com.example.toyproject.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.toyproject.model.Board;
import com.example.toyproject.model.FileInfo;

@Repository
public interface FileInfoRepository extends JpaRepository<FileInfo, Long> {
	
	

}
