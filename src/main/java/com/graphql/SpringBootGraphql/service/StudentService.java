package com.graphql.SpringBootGraphql.service;

import com.graphql.SpringBootGraphql.models.Student;
import com.graphql.SpringBootGraphql.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Transactional(readOnly = true)
    public Student findById(Long id) {
        return studentRepository.findById(id).orElseThrow();
    }

    @Transactional(readOnly = true)
    public List<Student> findAll() {
        return (List<Student>) studentRepository.findAll();
    }

    @Transactional
    public void createStudent(Student student) {
        studentRepository.save(student);
    }

    @Transactional
    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }
}
