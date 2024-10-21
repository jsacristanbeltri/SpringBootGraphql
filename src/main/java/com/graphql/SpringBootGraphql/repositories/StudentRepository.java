package com.graphql.SpringBootGraphql.repositories;

import com.graphql.SpringBootGraphql.models.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long>{
}
