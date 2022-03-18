package com.project.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.service.userService;

@RestController
public class userApiController {

	@Autowired
	private userService userservice;
	
}
