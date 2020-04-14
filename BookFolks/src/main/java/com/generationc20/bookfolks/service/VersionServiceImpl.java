package com.generationc20.bookfolks.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generationc20.bookfolks.dao.VersionRepository;
import com.generationc20.bookfolks.model.Version;

@Service
public class VersionServiceImpl implements VersionService {

	@Autowired
	private VersionRepository repository;
	
	@Override
	public Version save(Version version) {
		return repository.save(version);
	}
	
	@Override
	public Optional<Version> getById(Integer id) {
		return repository.findById(id);
	}
	
	@Override
	public Version update(Integer id, Version version) {
		//NotTerminated
		return null;
	}
	
	@Override
	public void remove(Integer id) {
		repository.deleteById(id);
		
	}
}
