package com.courseman.egspringcourseman.repository;

import com.courseman.egspringcourseman.model.Erolment;
import com.courseman.egspringcourseman.service.EnrolmentService;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnrolmentRepository extends CrudRepository<Erolment,Integer> {
}
