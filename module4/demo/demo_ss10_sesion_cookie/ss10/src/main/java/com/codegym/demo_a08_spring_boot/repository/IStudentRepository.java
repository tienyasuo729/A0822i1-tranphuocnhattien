package com.codegym.demo_a08_spring_boot.repository;

import com.codegym.demo_a08_spring_boot.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface IStudentRepository extends JpaRepository<Student, Integer> {

    @Modifying
    //    @Query(value = "select s from Student s where s.nameStudent like :name")
    @Query(value = "select * from student  where name_student like :name", nativeQuery = true)
    List<Student> findStudentByName(@Param(value = "name") String name);

    Page<Student> findAll(Pageable pageable);
}
