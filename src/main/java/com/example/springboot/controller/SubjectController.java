package com.example.springboot.controller;

import com.example.springboot.dto.ApiResponse;
import com.example.springboot.dto.SubjectDTO;
import com.example.springboot.entity.Subject;
import com.example.springboot.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subject")
public class SubjectController {

    @Autowired
    SubjectService subjectService;

    @GetMapping
    public List<Subject> getAll() {
        return subjectService.getAll();
    }

    @GetMapping("/{id}")
    public Subject getById(@PathVariable Integer id) {
        return subjectService.getById(id);
    }

    @PostMapping
    public ApiResponse add(@RequestBody SubjectDTO subjectDTO) {
        return subjectService.add(subjectDTO);
    }

    @PutMapping("/{id}")
    public ApiResponse edit(@PathVariable Integer id, @RequestBody SubjectDTO subjectDTO) {
        return subjectService.edit(id, subjectDTO);
    }

    @DeleteMapping("/{id}")
    public ApiResponse delete(@PathVariable Integer id) {
        return subjectService.delete(id);
    }
}
