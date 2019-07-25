package com.example.myspringdemo.service;

import com.example.myspringdemo.entity.Department;

import java.util.List;

public interface DepartmentService {
    Department addDepartment(Department department);
    void delete (long id);
    Department getByNameOfDepartment(String FullName);
    Department editDepartment (Department department);
    List<Department> getAll();

}
