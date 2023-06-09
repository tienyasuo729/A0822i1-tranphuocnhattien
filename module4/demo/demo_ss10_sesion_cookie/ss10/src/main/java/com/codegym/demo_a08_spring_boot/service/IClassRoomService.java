package com.codegym.demo_a08_spring_boot.service;

import com.codegym.demo_a08_spring_boot.model.ClassRoom;

import java.util.List;

public interface IClassRoomService {
    List<ClassRoom> getAll();
}
