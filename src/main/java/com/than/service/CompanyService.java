package com.than.service;

import com.than.model.Company;
import com.than.repository.ICompanyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CompanyService implements ICompanyService{
    @Autowired
    ICompanyRepo companyRepo;

    @Override
    public Iterable<Company> findAll() {
        return companyRepo.findAll();
    }

    @Override
    public Optional<Company> findById(Long id) {
        return companyRepo.findById(id);
    }

    @Override
    public void deleteById(Long id) {
       companyRepo.deleteById(id);
    }

    @Override
    public void save(Company company) {
        companyRepo.save(company);
    }

    @Override
    public Iterable<Company> findAllByNameContaining(String name) {
        return companyRepo.findAllByNameContaining(name);
    }
}
