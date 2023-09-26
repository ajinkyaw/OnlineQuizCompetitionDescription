package com.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.service.JDBCService;

@Repository("TeacherRepository")
public class TeacherRepositoryImpl implements TeacherRepository{

	@Autowired
	JDBCService jdbcService;

    @Override
    public void registerTeacher(String username, String password) {
        // You can perform any necessary validation or business logic here
        jdbcService.registerTeacher(username, password);
    }
}

