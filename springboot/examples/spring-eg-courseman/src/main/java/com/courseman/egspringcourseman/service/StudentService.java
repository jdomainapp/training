package com.courseman.egspringcourseman.service;

import com.courseman.egspringcourseman.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    Student save(Student entity);

    List<Student> saveAll(List<Student> entities);

    Optional<Student> findById(Integer integer);

    boolean existsById(Integer integer);

    List<Student> findAll();

    List<Student> findAllById(List<Integer> integers);

    long count();

    void deleteById(Integer integer);

    void delete(Student entity);

    void deleteAllById(List<Integer> integers);

    void deleteAll(List<Student> entities);

    void deleteAll();

    List<Student> findByNamestudentContaining(String q);
}
