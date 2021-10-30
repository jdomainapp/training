package com.courseman.egspringcourseman.repository;

import com.courseman.egspringcourseman.model.Student;
import com.courseman.egspringcourseman.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceIml implements StudentService {
    @Autowired
    StudentRepository repository;
    @Override
    public Student save(Student entity) {
        return repository.save(entity);
    }

    @Override
    public List<Student> saveAll(List<Student> entities) {

        return (List<Student>) repository.saveAll(entities);
    }

    @Override
    public Optional<Student> findById(Integer integer) {
        return repository.findById(integer);
    }

    @Override
    public boolean existsById(Integer integer) {
        return repository.existsById(integer);
    }

    @Override
    public List<Student> findAll() {
        return (List<Student>) repository.findAll();
    }

    @Override
    public List<Student> findAllById(List<Integer> integers) {
        return (List<Student>) repository.findAllById(integers);
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
    public void delete(Student entity) {
        repository.delete(entity);
    }

    @Override
    public void deleteAllById(List<Integer> integers) {
        repository.deleteAllById(integers);
    }

    @Override
    public void deleteAll(List<Student> entities) {
        repository.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }
}
