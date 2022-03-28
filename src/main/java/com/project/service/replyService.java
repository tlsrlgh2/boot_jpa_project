package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.model.board;
import com.project.model.reply;
import com.project.repository.replyRepositroy;

@Service
public class replyService {

	@Autowired
	private replyRepositroy replyrepositroy;

	@Transactional(readOnly = true)
	public List<reply> getreply(int id) {
		System.out.println("여기까지");
		List<reply> reply = replyrepositroy.selectboardreply(id);
		System.out.println(reply);
		
		return reply;
		
	}

}
