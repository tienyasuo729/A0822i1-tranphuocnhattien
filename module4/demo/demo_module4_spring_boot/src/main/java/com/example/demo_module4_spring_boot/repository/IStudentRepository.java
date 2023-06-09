package com.example.demo_module4_spring_boot.repository;

import com.example.demo_module4_spring_boot.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface IStudentRepository extends JpaRepository<Student, Integer> {
//    @Modifying
//    //    @Query(value = "select s from Student s where s.nameStudent like :name")
//    @Query(value = "select * from student  where name_student like :name", nativeQuery = true)
//    List<Student> findStudentByName(@Param(value = "name") String name);
}
