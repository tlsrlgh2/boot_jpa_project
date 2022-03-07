package com.cos.blog.controller.api;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cos.blog.config.auth.principalDetail;
import com.cos.blog.dto.ResponseDto;
import com.cos.blog.model.RoleType;
import com.cos.blog.model.board;
import com.cos.blog.model.user;
import com.cos.blog.service.boardService;
import com.cos.blog.service.userService;

@RestController //데이터만 리턴해줄경우 @RestController를 사용함
//@RequestMapping("blog")
public class boardApiController {
	
	@Autowired
	private boardService boardService;
	
	@PostMapping("/api/board")
	public ResponseDto<Integer> save(@RequestBody board board,@AuthenticationPrincipal principalDetail principal) {
		boardService.writesave(board,principal.getUser());
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
	}
	
	@DeleteMapping("/api/board/{id}")
	public ResponseDto<Integer> deleteById(@PathVariable int id) {
		System.out.println("delete mapping test");
		boardService.writedelete(id);
		
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
	}
	
	@PutMapping("/api/board/{id}")
	public ResponseDto<Integer> update(@PathVariable int id, @RequestBody board board) throws Exception {
		boardService.modify(id,board);

		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
	}
	
}
