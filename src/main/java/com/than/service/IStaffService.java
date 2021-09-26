package com.than.service;

import com.than.model.Staff;

import java.util.List;
import java.util.Optional;

public interface IStaffService {
    Iterable<Staff> findAll();
    Optional<Staff> findById(Long id);
    void deleteById(Long id);
    void save(Staff staff);
    Iterable<Staff> findAllByNameContaining(String name);
}
