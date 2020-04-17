package com.generationc20.bookfolks.service;

import java.util.List;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import com.generationc20.bookfolks.model.User;

public interface UserService {

	User save(User user);
	List<User> getAll();
	Optional<User> getById(Integer id);
	User update(Integer id, User user/*, MultipartFile multipartFile*/);
	void remove(Integer id);
}
