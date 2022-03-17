package com.project.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.project.model.user;
import com.project.service.userService;

@Controller
public class userController {
	
	@Autowired
	private userService userservice;
	
	@GetMapping("/user/join")
	public void joinform() {
		
	}
	
	@GetMapping("/user/login")
	public String userlogin() {
		
		return "/user/login";
	}
	
	@PostMapping("/user/join")
	public void userjoin(@RequestBody user user,HttpServletRequest requset) {
		System.out.println(user+"체크.................");
		userservice.userjoin(user);
		
		
		// 로그인시 세션에 아이디 넘겨줌
		HttpSession session = requset.getSession();
		session.setAttribute("userid", user.getUserid());
		
	}
	
	@GetMapping("/user/logout")
	public String userlogout(HttpServletRequest requset) {
		
		//  세션삭제 = 로그아웃
		HttpSession session = requset.getSession();
		session.invalidate();
		
		return "index";
	}
	
	@PostMapping("/user/login")
	public void login(HttpServletRequest requset) {
		String id = requset.getParameter("userid");
		String pw = requset.getParameter("userpw");
		
		userservice.login(id,pw);
		
//		userservice.userjoin(user);
		
		
		// 로그인시 세션에 아이디 넘겨줌
//		HttpSession session = requset.getSession();
//		session.setAttribute("userid", user.getUserid());
		
	}
}
