package com.example.toyproject.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.toyproject.model.YoutubeVideoInfo;
import com.example.toyproject.repository.YoutubeRepository;

@Controller

public class YoutubeController {
	@Autowired
	YoutubeRepository youtubeRepository;

	@GetMapping("/info.json")
	@ResponseBody
	public List<YoutubeVideoInfo> youtubecrjson(Model model) {

		List<YoutubeVideoInfo> list = youtubeRepository.findAll();
		return list;
	}

	@GetMapping("/info")
	public String youtubecr(Model model) {
		
		List<YoutubeVideoInfo> list = youtubeRepository.findAll();
		
		model.addAttribute("list", list);
		
		return "info/infolist";
	}
	
	@GetMapping("/{id}") // <-- id라는 명칭은 개발자가 임의로 만들어낸 명칭
	public String infodetail(@PathVariable("id") long id, Model model) {
		System.out.println("!@@@@@@ " + id);

		Optional<YoutubeVideoInfo> opt1 = youtubeRepository.findById(id);
		YoutubeVideoInfo board1 = opt1.get();
		System.out.println(board1);
		model.addAttribute("YoutubeInfo", board1);

		return "info/infodetail";
	}

	@GetMapping("/info2")
	public String pageinfo(Model model, @RequestParam(name = "page", defaultValue = "1") int page) {
		int startPage = (page - 1) / 10 * 10 + 1;
		int endPage = startPage + 9;
		
		PageRequest req = PageRequest.of(page - 1, 10, Sort.by(Direction.DESC, "id")); // 0페이지부터
		// 주소창에 http://localhost:8080/board/?page=10 확인

		Page<YoutubeVideoInfo> result = youtubeRepository.findAll(req);
		int totalPage = result.getTotalPages();
		if (endPage > totalPage) {
			endPage = totalPage;
		}
		List<YoutubeVideoInfo> list = result.getContent();
		model.addAttribute("list", list);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("page", page);
		return "info/infolist";
	}

}
