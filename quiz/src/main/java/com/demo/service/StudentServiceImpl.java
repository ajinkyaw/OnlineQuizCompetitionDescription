package com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("StudentService")
public class StudentServiceImpl implements StudentService {

	@Autowired
    JDBCService jdbcService;

    @Override
    public void registerStudent(String username, String password) {
        // You can perform any necessary validation or business logic here
        jdbcService.registerStudent(username, password);
    }
}
