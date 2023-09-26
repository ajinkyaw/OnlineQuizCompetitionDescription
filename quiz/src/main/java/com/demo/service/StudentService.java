package com.demo.service;

import org.springframework.stereotype.Service;

@Service
interface StudentService {
    void registerStudent(String username, String password);
}
