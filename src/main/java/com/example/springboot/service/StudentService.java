package com.example.springboot.service;

import com.example.springboot.dto.ApiResponse;
import com.example.springboot.dto.StudentDTO;
import com.example.springboot.entity.Address;
import com.example.springboot.entity.Group;
import com.example.springboot.entity.Student;
import com.example.springboot.entity.Subject;
import com.example.springboot.repository.AddressRepository;
import com.example.springboot.repository.GroupRepository;
import com.example.springboot.repository.StudentRepository;
import com.example.springboot.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    GroupRepository groupRepository;
    @Autowired
    SubjectRepository subjectRepository;

    public List<Student> getAll() {
        List<Student> all = studentRepository.findAll();
        return all;
    }

    public Student getOne(Integer id) {
        Optional<Student> byId = studentRepository.findById(id);
        return byId.get();
    }

    public ApiResponse delete(Integer id) {
        Optional<Student> byId = studentRepository.findById(id);

        studentRepository.delete(byId.get());
        return new ApiResponse("Deleted!", true);
    }

    public ApiResponse add(StudentDTO studentDTO) {
        Student student = new Student();
        student.setFirstName(studentDTO.getFirstName());
        student.setLastName(studentDTO.getLastName());

        List<Integer> subjectIds = studentDTO.getSubjectIds();
        List<Subject> subjects = new ArrayList<>();
        for (Integer subjectId : subjectIds) {
            Optional<Subject> byId = subjectRepository.findById(subjectId);
            subjects.add(byId.get());
        }


        student.setSubjects(subjects);
        Address address = new Address();
        address.setCity(studentDTO.getCity());
        address.setStreet(studentDTO.getStreet());
        address.setHome(studentDTO.getHome());
        addressRepository.save(address);
        student.setAddress(address);
        Optional<Group> byId = groupRepository.findById(studentDTO.getGroup_id());
        student.setGroup(byId.get());
        Student save = studentRepository.save(student);
        return new ApiResponse("Added", true);
    }


    public ApiResponse edit(Integer id, StudentDTO studentDTO) {
        Optional<Student> byId = studentRepository.findById(id);
        Student student = byId.get();
        student.setFirstName(studentDTO.getFirstName());
        student.setLastName(studentDTO.getLastName());

        List<Subject> allById = subjectRepository.findAllById(studentDTO.getSubjectIds());
        student.setSubjects(allById);

        Address address = student.getAddress();
        address.setHome(studentDTO.getHome());
        address.setCity(studentDTO.getCity());
        address.setStreet(studentDTO.getStreet());
        student.setAddress(address);

        Optional<Group> byId1 = groupRepository.findById(studentDTO.getGroup_id());

        student.setGroup(byId1.get());

        Student save = studentRepository.save(student);

        return new ApiResponse("Edited!", true);
    }
}
