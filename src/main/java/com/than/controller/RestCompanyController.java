package com.than.controller;

import com.than.dto.ResponseMessage;
import com.than.model.Company;
import com.than.model.Staff;
import com.than.service.ICompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("company")
public class RestCompanyController {
    @Autowired
    ICompanyService companyService;
    @GetMapping
    public ResponseEntity<?> getListCompany(){
        return new ResponseEntity<>(companyService.findAll(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> createCompany(@RequestBody Company company){
        companyService.save(company);
        return new ResponseEntity<>(new ResponseMessage("create success!"), HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateCompany(@PathVariable Long id, @RequestBody Company company){
        Optional<Company> company1 = companyService.findById(id);
        if(!company1.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        company.setId(id);
        companyService.save(company);
        return new ResponseEntity<>(new ResponseMessage("Update Success!"), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCompany(@PathVariable Long id){
        Optional<Company> staff = companyService.findById(id);
        if(!staff.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        companyService.deleteById(id);
        return new ResponseEntity<>(new ResponseMessage("Delete Success!"), HttpStatus.OK);
    }
    @GetMapping("/search")
    public ResponseEntity<?> findAllByName( String name){
        return new ResponseEntity<>(companyService.findAllByNameContaining(name),HttpStatus.OK);
    }
}
