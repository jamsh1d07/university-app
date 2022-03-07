package com.example.springboot.repository;

import com.example.springboot.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository
        extends JpaRepository<Address, Integer> {

}
