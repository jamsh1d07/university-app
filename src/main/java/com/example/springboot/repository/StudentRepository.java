package com.example.springboot.repository;

import com.example.springboot.entity.Student;
import com.example.springboot.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository
        extends JpaRepository<Student, Integer> {

}
