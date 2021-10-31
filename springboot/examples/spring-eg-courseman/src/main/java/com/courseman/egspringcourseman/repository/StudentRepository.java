package com.courseman.egspringcourseman.repository;

import com.courseman.egspringcourseman.model.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRepository extends CrudRepository<Student,Integer> {
    List<Student> findByNamestudentContaining(String q);
}
