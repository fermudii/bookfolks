package com.generationc20.bookfolks.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generationc20.bookfolks.model.Chapter;

public interface ChapterRepository extends JpaRepository<Chapter, Integer> {

}
