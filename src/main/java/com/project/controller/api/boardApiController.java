package com.project.controller.api;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.controller.userController;
import com.project.dto.dto;
import com.project.model.board;
import com.project.model.reply;
import com.project.model.user;
import com.project.service.boardService;
import com.project.service.userService;

@RestController
public class boardApiController {

	@Autowired
	private boardService boardService;
	
	@Autowired
	private userService userService;

	@PostMapping("/board/save")
	public String boardsave(@RequestBody board board,HttpServletRequest req) {
		HttpSession session = req.getSession();
		String userid = session.getAttribute("userid").toString();
		
		user user = userService.userinformation(userid);
		System.out.println(user);
		boardService.save(board,user); 	// list에 작성자 이름 나오게 수정필요
		
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
	
	@PostMapping("/board/reply")
	public void boardreply(@RequestBody dto dto,reply reply) throws Exception {
		System.out.println(dto);
		
		
		Optional<user> userchk = userService.selectid(dto.getUserid());
		if(userchk.isPresent()) {
			user user = userchk.get();
			
			board board = boardService.findboardid(dto.getBoardid());
			
			reply.setBoard(board);
			reply.setUser(user);
			reply.setContent(dto.getContent());

			boardService.replysave(reply);
			
		} else {
			throw new Exception();
		}
	}
}
