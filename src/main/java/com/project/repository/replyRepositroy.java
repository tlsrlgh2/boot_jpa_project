package com.project.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.project.dto.dto;
import com.project.model.board;
import com.project.model.reply;
import com.project.model.user;

public interface replyRepositroy extends JpaRepository<reply, Integer>{

	void save(dto dto);
	
	@Transactional(readOnly = true)
	@Query(value = "select * from reply where boardid = ?1",nativeQuery = true)
	List<reply> selectboardreply(int id);
	

}
