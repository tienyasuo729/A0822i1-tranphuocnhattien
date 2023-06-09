package com.codegym.demo_a08_spring_boot.service.impl;

import com.codegym.demo_a08_spring_boot.model.ClassRoom;
import com.codegym.demo_a08_spring_boot.repository.IClassRoomRepository;
import com.codegym.demo_a08_spring_boot.service.IClassRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassRoomService implements IClassRoomService {

    @Autowired
    private IClassRoomRepository iClassRoomRepository;

    @Override
    public List<ClassRoom> getAll() {
        return iClassRoomRepository.findAll();
    }
}
