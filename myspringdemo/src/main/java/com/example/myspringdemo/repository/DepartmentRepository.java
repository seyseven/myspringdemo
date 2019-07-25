package com.example.myspringdemo.repository;

import com.example.myspringdemo.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    List<Department> findByNameOfDepartmentStartsWithIgnoreCase(String nameOfDepartment);
}
