package com.example.myspringdemo.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name="POSITIONS")

public class Positions {

    @Id
    @GeneratedValue (generator = "increment")
    @GenericGenerator(name="increment",strategy ="increment")
    @Column(name="Id",nullable = false)
    private Long id;

    @Column(name="NameOfPosition",length = 100,nullable = false)
    private  String nameOfPosition;

    public Positions (String nameOfPosition){
        this.nameOfPosition = nameOfPosition;
    }
    public String getNameOfPosition(){
        return nameOfPosition;
    }
    public void setNameOfPosition(String nameOfPosition){this.nameOfPosition = nameOfPosition;}

    @Column(name="HoursRate",length = 50,nullable = false)
    private int hoursRate;

}
