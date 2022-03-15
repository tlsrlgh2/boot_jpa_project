package com.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
		boardrepository.save(board);
		System.out.println("save함수END ");
		
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

	

}
