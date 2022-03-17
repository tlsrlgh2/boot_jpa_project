package com.project.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.model.user;

public interface userRepository extends JpaRepository<user, Integer>{

	Optional<user> findAllByUserid(String id);
	Optional<user> findAllByPassword(String pw);

}
