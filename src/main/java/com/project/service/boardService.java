package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.model.board;
import com.project.repository.boardrepository;

@Service
public class boardService {

	@Autowired
	private boardrepository boardrepository;
	

	@Transactional
	public void save(board board) {
		System.out.println("save함수 ");
		System.out.println(board.toString());
		boardrepository.save(board);
		System.out.println("save함수END ");
		
	}
}
