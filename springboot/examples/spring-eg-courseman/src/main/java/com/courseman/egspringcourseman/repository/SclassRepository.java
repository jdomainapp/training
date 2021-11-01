package com.courseman.egspringcourseman.repository;

import com.courseman.egspringcourseman.model.Sclass;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SclassRepository extends CrudRepository<Sclass,Integer> {
    List<Sclass> findByNamesclassContaining(String q);
}
