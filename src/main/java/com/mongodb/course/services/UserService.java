package com.mongodb.course.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongodb.course.domain.User;
import com.mongodb.course.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository respository;
	
	public List<User> findAll() {
		return respository.findAll();
	}
}
