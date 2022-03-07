package com.example.springboot.controller;

import com.example.springboot.dto.ApiResponse;
import com.example.springboot.dto.FacultyDTO;
import com.example.springboot.entity.Faculty;
import com.example.springboot.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Access;
import java.util.List;

@RestController
@RequestMapping("/faculty")
public class FacultyController {

    @Autowired
    FacultyService facultyService;

    @PostMapping
    public ApiResponse save(@RequestBody FacultyDTO facultyDTO) {
        return facultyService.add(facultyDTO);
    }

    @GetMapping
    public List<Faculty> getAll() {
        return facultyService.getAll();
    }

    @DeleteMapping("/{id}")
    public ApiResponse delete(@PathVariable Integer id) {
        return facultyService.delete(id);
    }

    @GetMapping("/{id}")
    public ApiResponse getByUniversityName(@PathVariable Integer id) {
        return facultyService.getByUnv(id);
    }

    @PutMapping("/{id}")
    public ApiResponse edited(@PathVariable Integer id, @RequestBody FacultyDTO facultyDTO) {
        return facultyService.edit(id, facultyDTO);
    }

}
