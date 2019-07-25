package com.example.myspringdemo.entity;

import javax.persistence.*;

@Entity
@Table(name="HISTORY")

public class History {

    @Id
    @GeneratedValue
    @Column(name="Id",nullable = false)
    private Long id;
/*
    @Temporal(TemporalType.DATE)
    @Column(name="TimeIn",nullable = false)
    private DateTimeAtCreation timeIn;

    @Temporal(TemporalType.DATE)
    @Column(name="TimeOut", nullable = false)
    private DateTimeAtCompleted timeOut;
*/
    @Column(name = "REASON")
    private String reason;
}
