package com.project.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.model.user;
import com.project.service.UserSha256;
import com.project.service.userService;

@RestController
public class userApiController {

	@Autowired
	private userService userservice;

	
	@PutMapping("/user/modifty")
	public void modify(@RequestBody user user) {
		
		userservice.usermodyfy(user);
	}
}
