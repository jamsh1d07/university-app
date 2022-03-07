package com.example.springboot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentDTO {

    private String firstName;
    private String lastName;
    private String home;
    private String city;
    private String street;
    private Integer group_id;
    private List<Integer> subjectIds;
}
