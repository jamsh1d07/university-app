package com.example.springboot.controller;

import com.example.springboot.dto.ApiResponse;
import com.example.springboot.dto.GroupDTO;
import com.example.springboot.repository.GroupRepository;
import com.example.springboot.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/group")
public class GroupController {
    @Autowired
    GroupService groupService;

    @PostMapping()
    public ApiResponse added(@RequestBody GroupDTO groupDTO) {
        return groupService.add(groupDTO);
    }

    @GetMapping("/all")
    public ApiResponse getAll() {
        return groupService.getAll();
    }

    @GetMapping("/{id}")
    public ApiResponse getById(@PathVariable Integer id) {
        return groupService.getById(id);
    }

    @PutMapping("/{id}")
    public ApiResponse edited(@PathVariable Integer id, @RequestBody GroupDTO groupDTO) {
        return groupService.edit(id, groupDTO);
    }

    @DeleteMapping("/{id}")
    public ApiResponse deleted(@PathVariable Integer id) {
        return groupService.delete(id);
    }

    @GetMapping("/byUniversityId/{universityId}")
    private ApiResponse getGroupsByUniversityId(@PathVariable Integer universityId) {
        return groupService.getGroupsByUniversityId(universityId);
    }

}
