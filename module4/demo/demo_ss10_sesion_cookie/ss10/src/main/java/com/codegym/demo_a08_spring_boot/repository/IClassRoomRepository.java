package com.codegym.demo_a08_spring_boot.repository;

import com.codegym.demo_a08_spring_boot.model.ClassRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClassRoomRepository extends JpaRepository<ClassRoom, Integer> {
}
