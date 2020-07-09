package com.example.toyproject.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.toyproject.model.Board;
import com.example.toyproject.model.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
	
	public Comment findByCommentNoAndBoard(int commentNo, Board board);
	
//	@Query(nativeQuery = true, value = "select")
	public List<Comment> findByBoard(Board board);


}