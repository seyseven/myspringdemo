package com.example.myspringdemo.repository;

import com.example.myspringdemo.entity.Officer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OfficerRepository extends CrudRepository<Officer, Long> {

    /*
    public List<Officer>findByFullNameLike(String name);
    public List<Officer>findByDateOfBirthGreaterThan(Date date);
    public List<Officer>findByDateReceivedGreaterThan(Date date);
    public List<Officer>findByDateOfDismissalGreaterThan(Date date);
    public List<Officer>findByPositionLike(String name);
    public List<Officer>findByDepartmentLike(String name);
    */
    List<Officer> findByFullName(String name);
    //@Query("select of from Officer of where of.FullName = :FullName")
    //Officer findByFullName(@Param("FullName")String fullName);


}
