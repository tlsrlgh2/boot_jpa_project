package com.project.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.model.user;
import com.project.repository.userRepository;

@Service
public class userService {

	@Autowired
	private userRepository userrepository;

	@Transactional
	public void userjoin(user user) {
//		System.out.println(user.getPassword()+".........................................23");
//		비밀번호 암호화
		user.setPassword(UserSha256.encrypt(user.getPassword()));
		System.out.println(user.getPassword());
		userrepository.save(user);
		System.out.println("save완료");
		
	}
	
	@Transactional(readOnly = true)
	public void loginchk(String id, String pw, HttpServletRequest requset) {
		
		// 															찾은결과가 없을경우 예외처리
		user user = userrepository.findAllByUseridAndPassword(id, pw).orElseGet(()->{
			System.out.println("로그인 실패");
			return new user();
		});
		
		HttpSession session = requset.getSession();
		session.setAttribute("userid", user.getUserid());
	}

	public user userinformation(String userid) {
		
		
		return userrepository.findAllByUserid(userid);
	}

	public void usermodyfy(user user) {
		System.out.println(user);
		user.setPassword(UserSha256.encrypt(user.getPassword()));
		userrepository.save(user);
		
	}

	public Optional<user> selectid(String userid) {
		
		return userrepository.selectuserid(userid);
	}
	
}
