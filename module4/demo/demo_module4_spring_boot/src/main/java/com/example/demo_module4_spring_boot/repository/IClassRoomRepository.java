package com.example.demo_module4_spring_boot.repository;

import com.example.demo_module4_spring_boot.model.ClassRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface IClassRoomRepository extends JpaRepository<ClassRoom, Integer> {
}
