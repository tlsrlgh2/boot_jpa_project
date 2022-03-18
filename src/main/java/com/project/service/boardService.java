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

import com.project.model.board;
import com.project.model.user;
import com.project.repository.boardRepository;

@Service
public class boardService {

	@Autowired
	private boardRepository boardrepository;
	

	@Transactional
	public void save(board board) {
		
		boardrepository.save(board);
		
	}
	@Transactional(readOnly = true)
	public Page<board> listview(Pageable pageable) {
		System.out.println("listform............................3");
		
		
		// .getContent로 들고와야 list타입으로 변환가능 아닐경우 page타입으로 받을수있음. 대신 content만 가져오고 다른 정보들을 가져올수없음
//		List<board> board = boardrepository.findAll(pageable).getContent();
		System.out.println("listform............................4");
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

}
