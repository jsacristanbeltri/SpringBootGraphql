package com.graphql.SpringBootGraphql.service;

import com.graphql.SpringBootGraphql.models.Course;
import com.graphql.SpringBootGraphql.repositories.CourseRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Transactional(readOnly = true)
    public Course findById(Long id) {
        return courseRepository.findById(id).orElseThrow();
    }

    @Transactional(readOnly = true)
    public List<Course> findAll() {
        return (List<Course>) courseRepository.findAll();
    }

    @Transactional
    public void createCourse(Course course) {
        courseRepository.save(course);
    }

    @Transactional
    public void deleteById(Long id) {
        courseRepository.deleteById(id);
    }
}
