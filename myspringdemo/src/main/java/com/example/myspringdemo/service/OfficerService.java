package com.example.myspringdemo.service;

import com.example.myspringdemo.entity.Officer;

import java.sql.Date;
import java.util.List;

public interface OfficerService {
    Officer addOfficer(Officer officer);
    void delete (long id);
    Officer getByFullName(String FullName);
    Officer editOfficer (Officer officer);
    List<Officer> getAll();

    List<Officer>findByFullName(String FullName);
    List<Officer>findByDateOfBirthGreaterThan(Date date);
    List<Officer>findByDateReceivedGreaterThan(Date date);
    List<Officer>findByDateOfDismissalGreaterThan(Date date);
    List<Officer>findByPositionLike(String name);
    List<Officer>findByDepartmentLike(String name);


    void save(Officer o1);
}
