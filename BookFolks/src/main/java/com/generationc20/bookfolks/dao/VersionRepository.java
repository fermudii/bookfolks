package com.generationc20.bookfolks.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generationc20.bookfolks.model.Version;

public interface VersionRepository extends JpaRepository<Version, Integer>{

}
