package com.courseman.egspringcourseman.service;

import com.courseman.egspringcourseman.model.Course;

import java.util.List;
import java.util.Optional;

public interface CourseService {
    Course save(Course entity);

    List<Course> saveAll(List<Course> entities);

    Optional<Course> findById(Integer integer);

    boolean existsById(Integer integer);

    List<Course> findAll();

    List<Course> findAllById(List<Integer> integers);

    long count();

    void deleteById(Integer integer);

    void delete(Course entity);

    void deleteAllById(List<Integer> integers);

    void deleteAll(List<Course> entities);

    void deleteAll();

    List<Course> findCoursesByNamecourseContaining(String s);

}
