package com.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.model.user;
import com.project.repository.userRepository;

@Service
public class userService {

	@Autowired
	private userRepository userrepository;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Transactional
	public void userjoin(user user) {
//		System.out.println(user.getPassword()+".........................................23");
//		비밀번호 암호화
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		System.out.println(user.getPassword());
		userrepository.save(user);
		System.out.println("save완료");
		
	}

	public void login(String id, String pw) {
		
		System.out.println(passwordEncoder.encode(pw)+"비밀번호 암호화");
		
		// 아이디 있는지 체크
		Optional<user> user = userrepository.findAllByUserid(id);
		System.out.println(user);
		
		System.out.println("아디체크 완료");
		
		// 비밀번호 체크
		user = userrepository.findAllByPassword(pw + "비밀번호 체크");
		System.out.println(user);
		
//		$2a$10$HOOibY4UHDdrvOI6Nmk/UuB763e/gdCkwuPxOX4pnPjr.hsQo8ts6
		
	}
}
