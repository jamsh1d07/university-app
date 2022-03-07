package com.example.springboot.service;

import com.example.springboot.dto.ApiResponse;
import com.example.springboot.dto.SubjectDTO;
import com.example.springboot.entity.Subject;
import com.example.springboot.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectService {
    @Autowired
    SubjectRepository subjectRepository;

    public List<Subject> getAll() {
        List<Subject> all = subjectRepository.findAll();
        return all;
    }

    public Subject getById(Integer id) {
        Optional<Subject> byId = subjectRepository.findById(id);
        return byId.get();
    }

    public ApiResponse add(SubjectDTO dto) {
        Subject subject = new Subject();
        subject.setName(dto.getName());
        Subject save = subjectRepository.save(subject);
        return new ApiResponse("Added!", true, save);

    }

    public ApiResponse edit(Integer id, SubjectDTO dto) {
        Optional<Subject> byId = subjectRepository.findById(id);
        Subject subject = byId.get();
        subject.setName(dto.getName());
        Subject save = subjectRepository.save(subject);
        return new ApiResponse("Edited!", true);

    }

    public ApiResponse delete(Integer id) {
        Optional<Subject> byId = subjectRepository.findById(id);
        subjectRepository.delete(byId.get());
        return new ApiResponse("Deleted!", true);
    }

}
