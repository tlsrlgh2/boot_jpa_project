package com.project.controller.api;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.model.board;
import com.project.model.user;
import com.project.service.boardService;

@RestController
public class boardApiController {

	@Autowired
	private boardService boardService;

	@PostMapping("/board/save")
	public String boardsave(@RequestBody board board,HttpServletRequest req) {
		HttpSession session = req.getSession();
		session.getAttribute("userid");
		boardService.save(board); 	// list에 작성자 이름 나오게 수정필요
		
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
