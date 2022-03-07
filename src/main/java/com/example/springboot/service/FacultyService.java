package com.example.springboot.service;

import com.example.springboot.dto.ApiResponse;
import com.example.springboot.dto.FacultyDTO;
import com.example.springboot.entity.Faculty;
import com.example.springboot.entity.University;
import com.example.springboot.repository.FacultyRepository;
import com.example.springboot.repository.GroupRepository;
import com.example.springboot.repository.UniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacultyService {

    @Autowired
    FacultyRepository facultyRepository;


    @Autowired
    UniversityRepository universityRepository;

    public ApiResponse add(FacultyDTO dto) {

        Faculty faculty = new Faculty();
        faculty.setName(dto.getName());

        Optional<University> byId = universityRepository.findById(dto.getUnv_id());
        University university = byId.get();
        faculty.setUniversity(university);
        facultyRepository.save(faculty);
        return new ApiResponse("Added!", true);

    }

    public List<Faculty> getAll() {
        List<Faculty> all = facultyRepository.findAll();
        return all;
    }

    public ApiResponse delete(Integer id) {
        Optional<Faculty> byId = facultyRepository.findById(id);
        facultyRepository.delete(byId.get());
        return new ApiResponse("Delete", true, byId.get());
    }

    public ApiResponse edit(Integer id, FacultyDTO facultyDTO) {

        Optional<Faculty> byId = facultyRepository.findById(id);

        Faculty faculty = byId.get();

        faculty.setName(facultyDTO.getName());
        Optional<University> byId1 = universityRepository.findById(facultyDTO.getUnv_id());
        faculty.setUniversity(byId1.get());

        Faculty save = facultyRepository.save(faculty);

        return new ApiResponse("Mana", true);
    }

    public ApiResponse getByUnv(Integer id) {
        return new ApiResponse("Get ById", true, facultyRepository.findById(id));
    }

}
