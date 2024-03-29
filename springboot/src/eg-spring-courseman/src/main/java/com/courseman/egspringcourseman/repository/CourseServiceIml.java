package com.courseman.egspringcourseman.repository;

import com.courseman.egspringcourseman.model.Course;
import com.courseman.egspringcourseman.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceIml implements CourseService {
@Autowired
CourseRepository repository;

    @Override
    public Course save(Course entity) {
        return repository.save(entity);
    }

    @Override
    public List<Course> saveAll(List<Course> entities) {

        return (List<Course>) repository.saveAll(entities);
    }

    @Override
    public Optional<Course> findById(Integer integer) {
        return repository.findById(integer);
    }

    @Override
    public boolean existsById(Integer integer) {
        return repository.existsById(integer);
    }

    @Override
    public List<Course> findAll() {
        return (List<Course>) repository.findAll();
    }

    @Override
    public List<Course> findAllById(List<Integer> integers) {
        return (List<Course>) repository.findAllById(integers);
    }

    @Override
    public long count() {
        return repository.count();
    }

    @Override
    public void deleteById(Integer integer) {
        repository.deleteById(integer);
    }

    @Override
    public void delete(Course entity) {
        repository.delete(entity);
    }

    @Override
    public void deleteAllById(List<Integer> integers) {
        repository.deleteAllById(integers);
    }

    @Override
    public void deleteAll(List<Course> entities) {
        repository.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }
//    public List<Course> findByName(String q){
//        return repository.findByName(q);
//    }

}
