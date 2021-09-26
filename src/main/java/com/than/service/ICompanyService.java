package com.than.service;

import com.than.model.Company;
import com.than.model.Staff;

import java.util.Optional;

public interface ICompanyService {
    Iterable<Company> findAll();
    Optional<Company> findById(Long id);
    void deleteById(Long id);
    void save(Company company);
    Iterable<Company> findAllByNameContaining(String name);
}
