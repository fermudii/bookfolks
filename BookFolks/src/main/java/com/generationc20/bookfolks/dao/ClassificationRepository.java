package com.generationc20.bookfolks.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generationc20.bookfolks.model.Classification;

public interface ClassificationRepository extends JpaRepository<Classification, Integer> {

}
