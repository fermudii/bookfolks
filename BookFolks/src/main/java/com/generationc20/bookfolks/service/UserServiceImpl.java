package com.generationc20.bookfolks.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generationc20.bookfolks.dao.UserRepository;
import com.generationc20.bookfolks.model.User;


@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository repository;
	
	@Override
	public User save(User user) {
		return repository.save(user);
	}
	
	@Override
	public List<User> getAll() {
		return repository.findAll();
	}
	
	@Override
	public Optional<User> getById(Integer id) {
		return repository.findById(id);
	}
	
	@Override
	public User update(Integer id, User user) {
		User userDB = getById(id).get();
		userDB.setName(user.getName());
		userDB.setLastName(user.getLastName());
		userDB.setAge(user.getAge());
		userDB.setGender(user.getGender());
		userDB.setDescription(user.getDescription());
		userDB.setEmail(user.getEmail());
		userDB.setUrlImage(user.getUrlImage());
		return repository.save(userDB);
		
	}
	
	@Override
	public void remove(Integer id) {
		repository.deleteById(id);
		
	}
}
