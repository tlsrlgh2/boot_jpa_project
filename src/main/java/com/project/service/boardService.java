package com.project.service;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.project.dto.dto;
import com.project.model.board;
import com.project.model.reply;
import com.project.model.user;
import com.project.repository.boardRepository;
import com.project.repository.replyRepositroy;
import com.project.repository.userRepository;

@Service
public class boardService {

	@Autowired
	private boardRepository boardrepository;
	
	@Autowired
	private replyRepositroy replyrepositroy;

	@Transactional
	public void save(board board, user user) {
		board.setUser(user);
		boardrepository.save(board);
		
	}
	@Transactional(readOnly = true)
	public Page<board> listview(Pageable pageable) {
		System.out.println("listform............................3");
		return boardrepository.findAll(pageable);
		
	}

	@Transactional(readOnly = true)
	public board boarddetail(int id) throws Exception {
		System.out.println(boardrepository.findById(id) +"찾은 아이디 ");
		
		Optional<board> boardchk = boardrepository.findById(id);
		if(boardchk.isPresent()) {
			board board = boardchk.get();
			return board;
		}else {
			throw new Exception();
		}
	}

	@Transactional
	public void update(board board) throws Exception {
		System.out.println("board_update..............");
		Optional<com.project.model.board> getid = boardrepository.findById(board.getId());
		System.out.println(getid);
		if(getid.isPresent()) {
			boardrepository.save(board);
		}else {
			 throw new Exception();
		}
		
		
	}

	public void board_delete(int id) {
		
		boardrepository.deleteById(id);
		
	}
	
	public board findboardid(int parseInt) {
		System.out.println("1111111111111");
		
		return  boardrepository.findAllById(parseInt);
	}
	
	public reply replysave(reply reply) {
		System.out.println(reply + "reply save 안착");
		
		
//		reply.setBoard();
		
		return replyrepositroy.save(reply);
		
	}

}
