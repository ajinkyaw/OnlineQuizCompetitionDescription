package com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("TeacherService")
public class TeacherServiceImpl implements TeacherService {

	@Autowired
    JDBCService jdbcService;

    @Override
    public void registerTeacher(String username, String password) {
        // You can perform any necessary validation or business logic here
        jdbcService.registerTeacher(username, password);
    }
}
