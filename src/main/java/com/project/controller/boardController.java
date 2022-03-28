package com.project.controller;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.model.board;
import com.project.model.reply;
import com.project.repository.replyRepositroy;
import com.project.service.boardService;
import com.project.service.replyService;

@Controller
public class boardController {

	@Autowired
	private boardService boardservice;

	@Autowired
	private replyService replyService;
	
	@GetMapping({"index","/"})
	public String indexform() {

		return "index";
	}
	

	@GetMapping("/board/write")
	public String writeform() throws IOException {
		
		return "/board/write";
	}
	
	@GetMapping("/board/list")
	public void listform(Model model,@PageableDefault(size=2,sort = "id",direction = Sort.Direction.DESC) Pageable pageable) {
		System.out.println("listform............................1");
		model.addAttribute("boardlist", boardservice.listview(pageable));
		System.out.println("문제없음");
	}
	
	@GetMapping("/board/detail/{id}")
	public String detail(@PathVariable int id, Model model,HttpServletRequest request) throws Exception {
		System.out.println(id);
		HttpSession session = request.getSession();
		String userid = (String) session.getAttribute("userid");
		
		

		model.addAttribute("id", id);
		model.addAttribute("userid", userid);
		model.addAttribute("reply", replyService.getreply(id));
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
