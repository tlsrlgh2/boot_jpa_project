package com.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.AccessType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
public class user {

	@Id
	@Column(name = "user_count")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int user_count;
	
	@Column(name = "userid",unique = true)
	private String userid;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "email")
	private String email;

	@Column(name = "phone")
	private String phone;
	
	@Column(name = "address")
	private String address;
	
}
