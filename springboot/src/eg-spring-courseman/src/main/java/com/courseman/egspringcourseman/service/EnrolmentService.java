package com.courseman.egspringcourseman.service;

import com.courseman.egspringcourseman.model.Erolment;

import java.util.List;
import java.util.Optional;

public interface EnrolmentService {
    Erolment save(Erolment entity);

    List<Erolment> saveAll(List<Erolment> entities);

    Optional<Erolment> findById(Integer integer);

    boolean existsById(Integer integer);

    List<Erolment> findAll();

    List<Erolment> findAllById(List<Integer> integers);

    long count();

    void deleteById(Integer integer);

    void delete(Erolment entity);

    void deleteAllById(List<Integer> integers);

    void deleteAll(List<Erolment> entities);

    void deleteAll();
}
