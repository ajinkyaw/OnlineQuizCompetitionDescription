package com.demo.repository;

import org.springframework.stereotype.Repository;

@Repository
interface TeacherRepository{
    void registerTeacher(String username, String password);
}
