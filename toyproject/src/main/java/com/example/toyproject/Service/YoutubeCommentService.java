package com.example.toyproject.Service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.toyproject.model.Board;
import com.example.toyproject.model.Comment;
import com.example.toyproject.repository.BoardRepository;
import com.example.toyproject.repository.CommentRepository;

@Service
public class YoutubeCommentService {

	@Autowired
	CommentRepository CR;
	@Autowired
	BoardRepository BR;
	@Autowired
	HttpSession session;

	public List<Comment> YoutubecommentListService(long boardNo) throws Exception {
		Board board = BR.findById(boardNo).get();
		List<Comment> commentlist = CR.findByBoard(board);
		return commentlist;
	}

	public int YoutubecommentInsertService(Comment comment, long boardNo) throws Exception {
		int result = 1;
		Board board = BR.findById(boardNo).get();
		Comment com = CR.findByCommentNoAndBoard(comment.getCommentNo(), board);
		comment.setBoard(board);
		if (com != null) {
			result = 0; 
			// 예외설정하기 이미있는댓글
		}

		return YoutubecommentInsert(comment, result, boardNo);
	}

	public int YoutubecommentUpdateService(int commentPrimeNo, String content) throws Exception {
		Comment comment = CR.findById(commentPrimeNo).get();
		int result = 0;
		if (comment.getUserid().equals(session.getAttribute("userid"))) {
			comment.setContent(content);
			CR.save(comment);
			result = 1;
		}
		else if(session.getAttribute("authority")!=null) {
			comment.setContent(content);
			CR.save(comment);
			result = 1;
		}
		return result;
	}

	public int YoutubecommentDeleteService(int commentPrimeNo) throws Exception {
		Comment comment = CR.findById(commentPrimeNo).get();
		int result = 0;
		if (comment.getUserid().equals(session.getAttribute("userid"))) {
			CR.deleteById(commentPrimeNo);
			result = 1;
		}
		else if(session.getAttribute("authority")!=null) {
			CR.deleteById(commentPrimeNo);
			result = 1;
		}
		
		return result;
	}

	///////////////////////////////////////////////////////////////////////////

	public int YoutubecommentInsert(Comment comment, int result, long boardNo) {
		Board boardinfo = BR.findById(boardNo).get();
		int commentcount = boardinfo.getComments().size();
		// 1이면 성공 0이면 실패
		if (result == 0) {
			return result;
		}
		if (commentcount == 0) {
			comment.setCommentNo(1);
		}
		comment.setCommentNo(commentcount + 1);
		result = 1;
		CR.save(comment);

		return result;
	}
//    public int commentUpdate(Comment comment) {
//    	
//    }
//    public int commentDelete() {
//    	
//    }

}
