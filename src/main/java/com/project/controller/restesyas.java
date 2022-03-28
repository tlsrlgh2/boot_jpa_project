package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.project.model.reply;
import com.project.service.replyService;

@Controller
public class restesyas {

	@Autowired
	private replyService replyService;
	
//	@GetMapping("/user/usertest")
//	public void test(Model model) {
//		int id = 2;
//		
//		model.addAttribute("test", replyService.getreply(id));
//		reply reply = replyService.getreply(id);
//		
//		System.out.println(reply);
//	}
	
}
