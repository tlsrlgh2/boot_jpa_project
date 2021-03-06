package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.model.board;
import com.project.model.reply;
import com.project.model.user;

public interface boardRepository extends JpaRepository<board, Integer> {

	board findAllById(int parseInt);

}
