package com.jiwon.blogPrj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.jiwon.blogPrj.conf.auth.PrincipalDetail;
import com.jiwon.blogPrj.model.Board;
import com.jiwon.blogPrj.model.User;
import com.jiwon.blogPrj.service.BoardService;

@Controller
public class BoardController {
 
	@Autowired
	private BoardService boardService ;
	
	// 글 목록 select 되는 index 페이지
	@GetMapping({"/", ""})
	public String index(Model model, @PageableDefault(size=2, sort="id", direction=Sort.Direction.DESC)  Pageable pageable) { // 데이터 가져가야되서 model 사용
		model.addAttribute("boards", boardService.selectList(pageable)); // boards 변수로 값을 받아서 index.jsp로 넘긴다
		return "index"; // viewResolver 작동!! (model 정보 들고 jsp로 이동) 
	}
	
	@GetMapping("/board/{id}")
	public String findById(@PathVariable int id, Model model) {
		model.addAttribute("boardDetail", boardService.selectDetail(id)); // boards 변수로 값을 받아서 
		return "/board/detail"; // model 정보 들고 detail.jsp로 이동
	}
	
	// 글쓰기 수정
	@GetMapping("/board/{id}/updateform")
	public String updateForm(@PathVariable int id, Model model) { 
		model.addAttribute("boardDetail", boardService.selectDetail(id)); // 글 상세보기 상태에서 update api가 일어놔야되니깐, selectDetail 호출
		return "board/updateform";
	}
	
	// 글쓰기 저장
	@GetMapping("/board/saveForm")
	public String saveForm() { 
		return "board/saveform";
	}
	
	
	
}
