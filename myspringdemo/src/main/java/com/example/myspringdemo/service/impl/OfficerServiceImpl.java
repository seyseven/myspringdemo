package com.example.myspringdemo.service.impl;

import com.example.myspringdemo.repository.OfficerRepository;
import com.example.myspringdemo.entity.Officer;
import com.example.myspringdemo.service.OfficerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class OfficerServiceImpl implements OfficerService {

    @Autowired
    private OfficerRepository officerRepository;

    @Override
    public Officer addOfficer(Officer officer){
        Officer savedOfficer = officerRepository.save(officer);
        return savedOfficer;
    }

    @Override
    public void delete(long id) {
        officerRepository.deleteById(id);
    }

    @Override
    public Officer getByFullName(String FullName) {
        return (Officer) officerRepository.findByFullName(FullName);
    }

    @Override
    public Officer editOfficer(Officer officer) {
        return officerRepository.save(officer);
    }

    @Override
    public List<Officer> getAll() {
        return (List<Officer>) officerRepository.findAll();
    }


    @Override
    public List<Officer> findByFullName(String FullName) {
        return null;
    }
    @Override
    public List<Officer> findByDateOfBirthGreaterThan(Date date) {
        return null;
    }
    @Override
    public List<Officer> findByDateReceivedGreaterThan(Date date) {
        return null;
    }
    @Override
    public List<Officer> findByDateOfDismissalGreaterThan(Date date) {
        return null;
    }
    @Override
    public List<Officer> findByPositionLike(String name) {
        return null;
    }
    @Override
    public List<Officer> findByDepartmentLike(String name) {
        return null;
    }

    @Override
    public void save(Officer o1) {

    }
}
