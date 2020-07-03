package com.example.toyproject.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.toyproject.model.Board;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
	
	
	//Board테이블 기본키의 자료형Long
}