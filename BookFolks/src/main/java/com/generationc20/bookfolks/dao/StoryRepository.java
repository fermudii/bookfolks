package com.generationc20.bookfolks.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generationc20.bookfolks.model.Story;

public interface StoryRepository extends JpaRepository<Story, Integer>{

}
