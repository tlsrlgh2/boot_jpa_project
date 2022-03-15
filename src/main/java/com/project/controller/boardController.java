package com.project.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.model.board;
import com.project.service.boardService;

@Controller
public class boardController {

	@Autowired
	private boardService boardservice;

	@GetMapping("index")
	public String indexform() {

		return "index";
	}
	

	@GetMapping("/board/write")
	public String writeform() {

		return "/board/write";
	}
	
	@GetMapping("/board/list")
	public String listform(Model model,@PageableDefault(size=1,sort = "id",direction = Sort.Direction.DESC) Pageable pageable) {
		System.out.println("listform............................1");
		boardservice.listview(pageable);
		model.addAttribute("boardlist", boardservice.listview(pageable));
		System.out.println(boardservice.listview(pageable)+"...............................");
		System.out.println("문제없음");
		return "/board/list";
	}
	
	@GetMapping("/board/detail/{id}")
	public String detail(@PathVariable int id, Model model) throws Exception {
		System.out.println(id);
		model.addAttribute("boarddetail",boardservice.boarddetail(id));
		
		return "/board/detail";
	}
	
	@GetMapping("/board/detail/{id}/update")
	public String updateform(@PathVariable int id, Model model) throws Exception {
		System.out.println(id);
		model.addAttribute("updateform",boardservice.boarddetail(id));
		
		return "/board/updateform";
	}
	
	
}
