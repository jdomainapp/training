package com.courseman.egspringcourseman.repository;

import com.courseman.egspringcourseman.model.Course;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
public interface CourseRepository extends CrudRepository<Course,Integer> {
//public  List<Course> findByName(String q);
}
