package com.example.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //    @Length(min = 2, max = 4)
//    @Size(min = 2, max = 4)
    @Column(nullable = false)
    private String home;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String street;
}
