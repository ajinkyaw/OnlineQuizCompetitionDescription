package com.demo.repository;

import org.springframework.stereotype.Repository;

@Repository
interface StudentRepository{
    void registerStudent(String username, String password);
}
