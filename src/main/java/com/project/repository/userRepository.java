package com.project.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.project.model.reply;
import com.project.model.user;

public interface userRepository extends JpaRepository<user, Integer>{

	Optional<user> findAllByUseridAndPassword(String id,String pw);

	user findAllByUserid(String userid);

	@Transactional(readOnly = true)
	@Query(value = "select * from user where userid = ?1",nativeQuery = true)
	Optional<user> selectuserid(String userid);

}
