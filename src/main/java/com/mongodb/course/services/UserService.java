package com.mongodb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongodb.course.domain.User;
import com.mongodb.course.dto.UserDTO;
import com.mongodb.course.repositories.UserRepository;
import com.mongodb.course.services.exceptions.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository respository;
	
	public List<User> findAll() {
		return respository.findAll();
	}
	
	public User findById(String id) {
		Optional<User> obj = respository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public User insert(User obj) {
		return respository.insert(obj);
	}

	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}
}
