package com.courseman.egspringcourseman.repository;

import com.courseman.egspringcourseman.model.Erolment;
import com.courseman.egspringcourseman.service.EnrolmentService;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnrolmentRepository extends CrudRepository<Erolment,Integer> {
    List<Erolment> findErolmentByIdstudent(String q);
    List<Erolment> findErolmentByIdstudentContaining(String q);
    List<Erolment> findByIdstudentLike(String q);
    List<Erolment> findErolmentsByIdstudentIs(Integer q);
    List<Erolment> findErolmentsByIdstudentEquals(Integer q);
}
