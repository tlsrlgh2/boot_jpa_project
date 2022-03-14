package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.model.board;
import com.project.service.boardService;

@Controller
public class boardController {

	@Autowired
	private boardService boardService;

	@PostMapping("/board/test")
	public String test(@RequestBody board board) {

		System.out.println("test함수 ");
		boardService.save(board);

		System.out.println("체크테스트");
		System.out.println(board.getContent());
		System.out.println(board.getTitle());

		return "index";
	}

	@GetMapping("index")
	public String indexform() {

		return "index";
	}
	

	@GetMapping("/board/write")
	public String writeform() {

		return "/board/write";
	}

	@GetMapping("/board/list")
	public String listform() {

		return "/board/list";
	}

}
