package com.example.springboot.service;

import com.example.springboot.dto.ApiResponse;
import com.example.springboot.dto.UniversityDTO;
import com.example.springboot.entity.Address;
import com.example.springboot.entity.University;
import com.example.springboot.repository.AddressRepository;
import com.example.springboot.repository.UniversityRepository;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UniversityService {

    @Autowired
    UniversityRepository universityRepository;

    @Autowired
    AddressRepository addressRepository;


    public ApiResponse getAll() {
        List<University> all = universityRepository.findAll();
        return new ApiResponse("Get All", true, all);
    }

    public ApiResponse add(UniversityDTO universityDTO) {

        University university = new University();
        university.setName(universityDTO.getName());
        Address address = new Address();
        address.setCity(universityDTO.getCity());
        address.setStreet(universityDTO.getStreet());
        address.setHome(universityDTO.getHome());
        Address save1 = addressRepository.save(address);
        university.setAddress(save1);

        University save = universityRepository.save(university);
        return new ApiResponse("Added!", true);

    }

    public ApiResponse delete(Integer id) {
        Optional<University> byId = universityRepository.findById(id);
        universityRepository.delete(byId.get());
        return new ApiResponse("Deleted", true, byId.get());
    }

    public ApiResponse edit(Integer id, UniversityDTO universityDTO) {

        Optional<University> byId = universityRepository.findById(id);
        University university = byId.get();
        university.setName(universityDTO.getName());

        Address address = university.getAddress();

        address.setHome(universityDTO.getHome());
        address.setCity(universityDTO.getCity());
        address.setStreet(universityDTO.getStreet());
        university.setAddress(address);
        universityRepository.save(university);

        return new ApiResponse("Edited!", true);
    }

    public ApiResponse getById(Integer id) {
        Optional<University> byId = universityRepository.findById(id);
        return new ApiResponse("Get ByID", true, byId.get());
    }
}
