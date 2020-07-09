package com.example.toyproject.controller;
 
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.toyproject.Service.CommentService;
import com.example.toyproject.model.Comment;
import com.example.toyproject.model.Member;

import ch.qos.logback.core.Context;
 
@Controller
@RequestMapping("/comment")
public class CommentController {
	
	@Autowired
    CommentService mCommentService;
	
	@Autowired
	HttpSession session;
    
    
    @RequestMapping("/list") //댓글 리스트
    @ResponseBody
    private List<Comment> mCommentList(@RequestParam long BoardNo) throws Exception{
       System.out.println("@!%!@%!@%#@");
    	System.out.println("#$%"+BoardNo);
        return mCommentService.commentListService(BoardNo);
    }
    
    @RequestMapping("/insert") //댓글 작성 
    @ResponseBody
    private int mCommentInsert(@RequestParam long boardNo, @RequestParam String content ) throws Exception{
    	Comment comment = new Comment();
        
        comment.setContent(content);
        if((String) session.getAttribute("userid")==null) {
        	comment.setUserid("손님");
        }
        else {
        	comment.setUserid((String) session.getAttribute("userid"));
        }
        
        //댓글 넘버 추가하기 
        
        return mCommentService.commentInsertService(comment, boardNo);
    }
    
    @RequestMapping("/update") //댓글 수정  
    @ResponseBody
    private int mCommentUpdateProc(@RequestParam int commentPrimeNo, @RequestParam String content) throws Exception{
        
    	
        
        
        return mCommentService.commentUpdateService(commentPrimeNo, content);
    }
    
    @RequestMapping("/delete/{commentPrimeNo}") //댓글 삭제  
    @ResponseBody
    private int mCommentDelete(@PathVariable int commentPrimeNo) throws Exception{
    	
    	return mCommentService.commentDeleteService(commentPrimeNo);
    } 
    
}
 


