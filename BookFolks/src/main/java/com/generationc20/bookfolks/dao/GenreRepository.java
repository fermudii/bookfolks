package com.generationc20.bookfolks.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generationc20.bookfolks.model.Genre;

public interface GenreRepository extends JpaRepository<Genre, Integer>{

}
