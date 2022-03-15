package com.project.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.model.board;
import com.project.service.boardService;

@RestController
public class boardApiController {

	@Autowired
	private boardService boardService;

	@PostMapping("/board/save")
	public String boardsave(@RequestBody board board) {
		boardService.save(board);
		
		return "index";
	}
	
	@PutMapping("/board/updatesave")
	public String updatesave(@RequestBody board board) throws Exception {
		boardService.update(board);
		System.out.println("update 완료");

		return "/board/list";
	}
	
	@DeleteMapping("/board/delete/{id}")
	public void boarddelete(@PathVariable int id) {
		System.out.println("delete.....................");
		boardService.board_delete(id);
		
	}
}
