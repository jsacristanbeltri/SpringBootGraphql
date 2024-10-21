package com.graphql.SpringBootGraphql.repositories;

import com.graphql.SpringBootGraphql.models.Course;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, Long> {
}
