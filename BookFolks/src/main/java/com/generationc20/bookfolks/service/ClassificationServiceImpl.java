package com.generationc20.bookfolks.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generationc20.bookfolks.dao.ClassificationRepository;
import com.generationc20.bookfolks.model.Classification;

@Service
public class ClassificationServiceImpl implements ClassificationService {

	@Autowired
	private ClassificationRepository repository;
	
	@Override
	public Classification save(Classification classification) {
		return repository.save(classification);
	}
	@Override
	public Optional<Classification> getById(Integer id) {
		return repository.findById(id);
	}
	
	@Override
	public Classification update(Integer id, Classification classification) {
		//NotTerminated
		return null;
	}
	
	@Override
	public void remove(Integer id) {
		repository.deleteById(id);
	}
	
	
}
