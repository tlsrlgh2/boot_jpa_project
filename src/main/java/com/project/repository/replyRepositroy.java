package com.project.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.dto.dto;
import com.project.model.board;
import com.project.model.reply;
import com.project.model.user;

public interface replyRepositroy extends JpaRepository<reply, Integer>{

	void save(dto dto);

}
