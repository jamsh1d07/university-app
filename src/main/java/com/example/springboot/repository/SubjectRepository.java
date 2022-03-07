package com.example.springboot.repository;

import com.example.springboot.entity.Address;
import com.example.springboot.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository
        extends JpaRepository<Subject, Integer> {

}
