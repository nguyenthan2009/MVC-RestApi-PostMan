package com.than.service;

import com.than.model.Staff;
import com.than.repository.IStaffRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class StaffService implements  IStaffService{
    @Autowired
    IStaffRepo staffRepo;

    @Override
    public Iterable<Staff> findAll() {
        return staffRepo.findAll();
    }

    @Override
    public Optional<Staff> findById(Long id) {
        return staffRepo.findById(id);
    }

    @Override
    public void deleteById(Long id) {
         staffRepo.deleteById(id);
    }

    @Override
    public void save(Staff staff) {
       staffRepo.save(staff);
    }

    @Override
    public Iterable<Staff> findAllByNameContaining(String name) {
        return staffRepo.findAllByNameContaining(name);
    }
}
