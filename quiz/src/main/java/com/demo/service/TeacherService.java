package com.demo.service;

import org.springframework.stereotype.Service;

@Service
interface TeacherService {
    void registerTeacher(String username, String password);
}
