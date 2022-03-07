package com.example.springboot.controller;

import com.example.springboot.dto.ApiResponse;
import com.example.springboot.dto.UniversityDTO;
import com.example.springboot.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/university")
public class UniversityController {

    @Autowired
    UniversityService universityService;


    @GetMapping()
    public ApiResponse getPage() {
        return universityService.getAll();
    }

    @PostMapping
    public ApiResponse addUniversity(@RequestBody UniversityDTO universityDTO) {
        return universityService.add(universityDTO);
    }

    @GetMapping("/{id}")
    public ApiResponse edit(@PathVariable Integer id) {
        return universityService.getById(id);
    }

    @PutMapping("/{id}")
    public ApiResponse editPage(@PathVariable Integer id, @RequestBody UniversityDTO universityDTO) {
        return universityService.edit(id, universityDTO);
    }

    @DeleteMapping("/{id}")
    public ApiResponse deleted(@PathVariable Integer id) {
        return universityService.delete(id);
    }

}
