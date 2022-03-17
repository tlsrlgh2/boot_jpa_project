package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.model.board;

public interface boardRepository extends JpaRepository<board, Integer> {

}
