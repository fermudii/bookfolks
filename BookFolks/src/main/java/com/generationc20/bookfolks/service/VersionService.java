package com.generationc20.bookfolks.service;

import java.util.Optional;

import com.generationc20.bookfolks.model.Version;

public interface VersionService {

	Version save(Version version);
	Optional<Version> getById(Integer id);
	Version update(Integer id, Version version);
	void remove(Integer id);
}
