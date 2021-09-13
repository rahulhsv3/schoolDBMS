package com.brillio.myfirstrestservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

@RestController
@Component
public class MyRestController {

    @Autowired
    StudentDAO studentDAO;

    @Autowired
    Student1DAO student1DAO;

    @GetMapping("/")
    public String firstMethod()
    {
        return "Welcome to Spring boot Application";
    }

    @GetMapping("/student")
    public List<StudentDTo> getStudent()
    {
        return studentDAO.findAll();  //Does what getAllStudent method does in springMVC
    }
    @GetMapping("/student/{id}")
    public Optional<StudentDTo> getAnyStudent(@PathVariable String id)
    {
        return studentDAO.findById(id);
    }

    @GetMapping("/student/fname/{fname}")
    public Optional<StudentDTo> getStudentByFname(@PathVariable String fname)
    {
        return studentDAO.findByFname(fname);
    }

    @GetMapping("/student/name/{fname}/{lname}")
    public List<StudentDTo> getAnyStudentByName(@PathVariable String fname,@PathVariable String lname)
    {
        return studentDAO.findAllByFnameAndLname(fname,lname);
    }

    @GetMapping("/student/marks")
    public List<Student1DTO> getAllStudentsMarks()
    {
        return student1DAO.findAll();
    }

    @GetMapping("/student/getJoin")
    public List<String> getJoinDetails()
    {
        return student1DAO.getJoinDetails();
    }

}
