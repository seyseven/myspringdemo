package com.example.myspringdemo.entity;

import javax.persistence.*;

@Entity
@Table(name = "DEPARTMENT")

public class Department {

    @Id
    @GeneratedValue
    //@Column(name = "Id",nullable = false)
    private Long id;
    //@Column(name = "NameOfDepartment",length = 100,nullable = false)
    private String nameOfDepartment;

    public Department(String nameOfDepartment, String s){

    }

    public Department(String nameOfDepartment){
        this.nameOfDepartment = nameOfDepartment;
    }

    public Long getId(){
        return id;
    }
    //public void setId(Long id){this.id=id;}

    public String getNameOfDepartment(){
        return nameOfDepartment;
    }
    public void setNameOfDepartment(String nameOfDepartment){
        this.nameOfDepartment = nameOfDepartment;
    }

    @Override
    public String toString(){
        return String.format("Department[id=%d, nameOfDepartment]",id, nameOfDepartment);
    }
}
