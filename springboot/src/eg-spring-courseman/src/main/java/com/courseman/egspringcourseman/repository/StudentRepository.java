package com.courseman.egspringcourseman.repository;

import com.courseman.egspringcourseman.model.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student,Integer> {
}
