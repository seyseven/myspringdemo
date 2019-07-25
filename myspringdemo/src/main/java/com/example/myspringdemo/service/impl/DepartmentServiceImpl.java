package com.example.myspringdemo.service.impl;

import com.example.myspringdemo.repository.DepartmentRepository;
import com.example.myspringdemo.entity.Department;
import com.example.myspringdemo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;


    @Override
    public Department addDepartment(Department department) {
        return null;
    }

    @Override
    public void delete(long id) {

    }

    @Override
    public Department getByNameOfDepartment(String FullName) {
        return null;
    }

    @Override
    public Department editDepartment(Department department) {
        return null;
    }

    @Override
    public List<Department> getAll() {
        return null;
    }
}
