package com.graphql.SpringBootGraphql.controllers;

import com.graphql.SpringBootGraphql.models.Course;
import com.graphql.SpringBootGraphql.models.Student;
import com.graphql.SpringBootGraphql.models.graphql.InputStudent;
import com.graphql.SpringBootGraphql.service.CourseService;
import com.graphql.SpringBootGraphql.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private CourseService courseService;

    @QueryMapping(name = "findStudentById")
    public Student findById(@Argument(name = "studentId") String id){
        Long studentId = Long.parseLong(id);

        return studentService.findById(studentId);
    }

    @QueryMapping(name = "findAllStudents")
    public List<Student> findAll(){
        return studentService.findAll();
    }

    @MutationMapping
    public Student createStudent(@Argument InputStudent inputStudent){

        Course course = courseService.findById(Long.parseLong(inputStudent.getCourseId()));

        Student student = new Student();
        student.setName(inputStudent.getName());
        student.setLastName(inputStudent.getLastName());
        student.setAge(inputStudent.getAge());
        student.setCourse(course);

        studentService.createStudent(student);

        return student;
    }

    @MutationMapping(name = "deleteStudentById")
    public String deleteById(@Argument(name = "studentId") String id){
        studentService.deleteById(Long.parseLong(id));
        return "El estudiante con id " + id + " ha sido eliminado.";
    }
}
