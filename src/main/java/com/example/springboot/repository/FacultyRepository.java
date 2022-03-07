package com.example.springboot.repository;

import com.example.springboot.entity.Faculty;
import com.example.springboot.entity.University;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FacultyRepository extends
        JpaRepository<Faculty, Integer> {

    List<Faculty> findAllByUniversity_Name(String name);

}
