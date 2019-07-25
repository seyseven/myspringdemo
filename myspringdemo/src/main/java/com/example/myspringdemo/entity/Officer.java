package com.example.myspringdemo.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="OFFICER")

public class Officer {

    @Id
    @GeneratedValue (generator = "increment")
    @GenericGenerator(name="increment",strategy ="increment")
    @Column(name="Id",nullable = false)
    private Long id;

    @Column(name="FullName")
    private String fullName;
    public Officer(){
    }
    public Officer(String fullName){
        this.fullName = fullName;
    }
    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id=id;
    }

    public String getFullName(){
        return fullName;
    }
    public void setFullName(String fullName) {this.fullName = fullName;}

    @Temporal(TemporalType.DATE)
    @Column(name = "DateOfBirth")
    private Date dateOfBirth;

    @Temporal(TemporalType.DATE)
    @Column(name="DateReceived")
    private Date dateReceived;

    @Temporal(TemporalType.DATE)
    @Column(name="DateOfDesmissal")
    private Date dateOfDismissal;

    @Column(name = "POSITION")
    private String position;

    @Column(name = "DEPARTMENT")
    private String department;


    public Date getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Date getDateReceived(){
        return dateReceived;
    }
    public void setDateReceived(Date dateReceived){
        this.dateReceived = dateReceived;
    }

    public Date getDateOfDismissal(){
        return dateOfDismissal;
    }
    public void setDateOfDismissal(Date dateOfDismissal){
        this.dateOfDismissal = dateOfDismissal;
    }

    public String getPosition(){
        return position;
    }
    public void setPosition(String position) {
        this.position = position;
    }

    public String getDepartment(){
        return department;
    }
    public void setDepartment(String department){
        this.department = department;
    }


}
