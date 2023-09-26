package com.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.service.JDBCService;

@Repository("StudentRepository")
public class StudentRepositoryImpl implements StudentRepository{

	@Autowired
	JDBCService jdbcService;

    @Override
    public void registerStudent(String username, String password) {
        // You can perform any necessary validation or business logic here
        jdbcService.registerStudent(username, password);
    }
}

