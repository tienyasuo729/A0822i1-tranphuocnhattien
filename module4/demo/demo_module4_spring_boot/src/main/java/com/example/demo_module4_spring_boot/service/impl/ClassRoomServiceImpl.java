package com.example.demo_module4_spring_boot.service.impl;

import com.example.demo_module4_spring_boot.model.ClassRoom;
import com.example.demo_module4_spring_boot.repository.IClassRoomRepository;
import com.example.demo_module4_spring_boot.service.IClassRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassRoomServiceImpl implements IClassRoomService {
    @Autowired
    private IClassRoomRepository iClassRoomRepository;

    public ClassRoomServiceImpl(IClassRoomRepository iClassRoomRepository) {
        this.iClassRoomRepository = iClassRoomRepository;
    }

    @Override
    public List<ClassRoom> getAll() {
        return iClassRoomRepository.findAll();
    }
}
