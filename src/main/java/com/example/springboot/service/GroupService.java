package com.example.springboot.service;

import com.example.springboot.dto.ApiResponse;
import com.example.springboot.dto.GroupDTO;
import com.example.springboot.entity.Faculty;
import com.example.springboot.entity.Group;
import com.example.springboot.repository.FacultyRepository;
import com.example.springboot.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroupService {
    @Autowired
    GroupRepository groupRepository;
    @Autowired
    FacultyRepository facultyRepository;

    public ApiResponse add(GroupDTO groupDTO) {

        Group group = new Group();
        group.setName(groupDTO.getName());
        Optional<Faculty> byId = facultyRepository.findById(groupDTO.getFaculty_id());

        group.setFaculty(byId.get());
        groupRepository.save(group);

        return new ApiResponse("Added!", true);
    }

    public ApiResponse getAll() {
        return new ApiResponse("list", true, groupRepository.findAll());
    }

    public ApiResponse getById(Integer id) {
        Optional<Group> byId = groupRepository.findById(id);
        return new ApiResponse("Get ByID", true, byId.get());
    }

    public ApiResponse edit(Integer id, GroupDTO groupDTO) {
        Optional<Group> byId = groupRepository.findById(id);
        Group group = byId.get();

        group.setName(groupDTO.getName());
        Optional<Faculty> byId1 = facultyRepository.findById(groupDTO.getFaculty_id());
        Faculty faculty = byId1.get();
        group.setFaculty(faculty);
        Group save = groupRepository.save(group);
        return new ApiResponse("Edited!", true);
    }

    public ApiResponse delete(Integer id) {
        Optional<Group> byId = groupRepository.findById(id);
        return new ApiResponse("Deleted!", true, byId.get());
    }

    public ApiResponse getGroupsByUniversityId(Integer universityId) {

        List<Group> groupsByUniversityIdNative = groupRepository.getGroupsByUniversityIdNative(universityId);
        List<Group> groupsByUniversityId = groupRepository.getGroupsByUniversityId(universityId);
        List<Group> allByFaculty_id = groupRepository.findAllByFaculty_Id(universityId);
        return new ApiResponse("Mana", true, groupsByUniversityIdNative);
    }
}
