package com.than.model;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;

@Entity
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private int age;
    private String image;
    @Transient
    private MultipartFile fileImage;
    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    public Staff() {
    }

    public Staff(Long id, String name, int age, String image, Company company) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.image = image;
        this.company = company;
    }

    public Staff(Long id, String name, int age, String image, MultipartFile fileImage, Company company) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.image = image;
        this.fileImage = fileImage;
        this.company = company;
    }

    public Staff(Long id, String name, int age, MultipartFile fileImage, Company company) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.fileImage = fileImage;
        this.company = company;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public MultipartFile getFileImage() {
        return fileImage;
    }

    public void setFileImage(MultipartFile fileImage) {
        this.fileImage = fileImage;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
