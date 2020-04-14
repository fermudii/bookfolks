package com.generationc20.bookfolks.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generationc20.bookfolks.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
