package com.example.myspringdemo.service;

import org.aspectj.weaver.Position;

import java.util.List;

//import javax.swing.text.Position;

public interface PositionService {
    Position addPosition (Position position);
    Position getByNameOfPosition(String nameOfPosition);
    Position editPosition(Position position);
    List<Position>getAll();

    List<Position> findByNameOfPosition(String nameOfPosition);
}
