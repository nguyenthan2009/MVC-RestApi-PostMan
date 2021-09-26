package com.than.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.than.dto.ResponseMessage;
import com.than.model.Staff;
import com.than.service.IStaffService;
import org.aspectj.apache.bcel.classfile.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

@RestController
@PropertySource("classpath:upload_file.properties")
@RequestMapping("staff")
public class RestStaffController {
    @Value("${file-upload}")
    private String fileUpload;
    @Autowired
    IStaffService staffService;
    @PostMapping
    public ResponseEntity<?> createStaff(@RequestParam("fileImage") MultipartFile file,Staff staff){
        String fileName = file.getOriginalFilename();
        try {
            FileCopyUtils.copy(file.getBytes(),
                    new File(fileUpload +fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }

        staff.setImage(fileName);
        staffService.save(staff);

        return new ResponseEntity<>(new ResponseMessage("create success!"), HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<?> getListStaff(){
        return new ResponseEntity<>(staffService.findAll(), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStaff(@PathVariable Long id){
        Optional<Staff> staff = staffService.findById(id);
        if(!staff.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        staffService.deleteById(id);
        return new ResponseEntity<>(new ResponseMessage("Delete Success!"), HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateStaff(@PathVariable Long id,@RequestBody Staff staff,@RequestParam("fileImage") MultipartFile file){
        Optional<Staff> staff1 = staffService.findById(id);
        if(!staff1.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
     //   MultipartFile file = staff.getFileImage();
       String fileName = file.getOriginalFilename();
       try {
            FileCopyUtils.copy(file.getBytes(),
                    new File(fileUpload +fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        staff.setId(id);
        staff.setImage(fileName);
        staffService.save(staff);

        return new ResponseEntity<>(new ResponseMessage("Update Success!"), HttpStatus.OK);
    }
    @GetMapping("/search")
    public ResponseEntity<?> findAllByName(String name){
        return new ResponseEntity<>(staffService.findAllByNameContaining(name),HttpStatus.OK);
    }




}
