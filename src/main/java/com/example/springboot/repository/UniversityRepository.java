package com.example.springboot.repository;

import com.example.springboot.entity.University;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UniversityRepository extends
        JpaRepository<University, Integer> {

    Optional<University> findByName(String name);

    boolean existsByName(String name);

    Optional<University> findByAddressNotNull();

    List<University> findAllByName(String name);

}
