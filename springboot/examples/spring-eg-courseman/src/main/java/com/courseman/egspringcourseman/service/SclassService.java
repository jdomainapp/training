package com.courseman.egspringcourseman.service;

import com.courseman.egspringcourseman.model.Sclass;

import java.util.List;
import java.util.Optional;

public interface SclassService {
    Sclass save(Sclass entity);

    List<Sclass> saveAll(List<Sclass> entities);

    Optional<Sclass> findById(Integer integer);

    boolean existsById(Integer integer);

    List<Sclass> findAll();

    List<Sclass> findAllById(List<Integer> integers);

    long count();

    void deleteById(Integer integer);

    void delete(Sclass entity);

    void deleteAllById(List<Integer> integers);

    void deleteAll(List<Sclass> entities);

    void deleteAll();

    List<Sclass> findByNamesclassContaining(String q);
}
