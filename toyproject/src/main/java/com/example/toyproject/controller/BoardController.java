package com.example.toyproject.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.toyproject.model.Board;
import com.example.toyproject.model.Member;
import com.example.toyproject.repository.BoardRepository;

@RequestMapping("/board") // 하나의 주소로 만들어주는거 /board랑 /write합쳐서 => /board/write로 주소가 지정된다
@Controller
public class BoardController {
	@Autowired
	BoardRepository boardRepository;
	@Autowired
	HttpSession session;
	@RequestMapping("/board") // 하나의 주소로 만들어주는거 /board랑 /write합쳐서 => /board/write로 주소가 지정된다	
	
	
	
	

	@GetMapping("/{id}")
	public String boardView(Model model, @PathVariable("id") long id) {
		Optional<Board> data = boardRepository.findById(id);
		Board board = data.get();
		System.out.println(board);
		model.addAttribute("board", board);// k,v
		return "board/detail";
	}
	// 뭘 수정할지 조회해야
	@GetMapping("/{id}") // <-- id라는 명칭은 개발자가 임의로 만들어낸 명칭 localhost:8080/board/20
	public String boardDetail(Model model, @PathVariable("id") long id) {
		System.out.println("!@@@" + id);
		// jpa로 해당 아이디 게시물을 조회해야
		Optional<Board> opt = boardRepository.findById(id); // 옵셔널클래스컬렉션타입 데이터타입은 보드
		Board board = opt.get();
		System.out.println(board);
		model.addAttribute("board", board);
		return "board/detail";
	}

	
	

	@GetMapping("/write") // board패키지 만들어주고 "/board/wrtie
	public String boardWrite() {
		return "/board/write";
	}
	@PostMapping("/write") 
	@ResponseBody
	public String boardWritePost(@ModelAttribute Board board) {
		System.out.println(board);
		/* 로그인 여부 확인 (세션의 값 확인) */
		Member member = (Member) session.getAttribute("member_info");
		if (member == null) { // 로그인 X
			return "0";
		} else { // 로그인 O
			String memberId = member.getMemberID();
			board.setAuthorMemberId(memberId);
			boardRepository.save(board);
		}
		return "1";
	}

	

	@GetMapping("/update/{id}")
	public String boardUpdate(Model model, @PathVariable("id") long id) {
		// jpa로 해당 아이디 게시물을 조회해야
		Optional<Board> data = boardRepository.findById(id);
		Board board = data.get();
		model.addAttribute("board", board);
		return "board/update";
	}
	@PostMapping("/update/{id}")
	public String boardUpdatePost(@ModelAttribute Board board, @PathVariable("id") long id) {
		Member member = (Member) session.getAttribute("member_info");
		String memberId = member.getMemberID();
		board.setAuthorMemberId(memberId);
		board.setBbsId(id);
		boardRepository.save(board);
		return "redirect:/board/" + id;
	}



	@GetMapping("/delete/{id}")
	public String boardDelete(@PathVariable("id") long id) {
		// jpa로 해당 아이디 게시물을 조회해야
		boardRepository.deleteById(id);
		return "redirect:/board/";
	}

	
	@GetMapping("/") 
	public String board(Model model, @RequestParam(name = "page", defaultValue = "1") int page) {
//		int startPage = (page - 1) / 10 * 10 + 1;
//		int endPage = startPage + 9;
//		
//		PageRequest req = PageRequest.of(page - 1, 10, Sort.by(Direction.DESC, "id")); // 0페이지부터
//		// 주소창에 http://localhost:8080/board/?page=10 확인
//
//		Page<Board> result = boardRepository.findAll(req);
//		int totalPage = result.getTotalPages();
//		if (endPage > totalPage) {
//			endPage = totalPage;
//		}
//		List<Board> list = result.getContent();
//		model.addAttribute("list", list);
//		model.addAttribute("startPage", startPage);
//		model.addAttribute("endPage", endPage);
//		model.addAttribute("totalPage", totalPage);
//		model.addAttribute("page", page);
		return "board/list";
	}

}