package org.intecbrussel.controller;

import org.intecbrussel.model.StudentModel;
import org.intecbrussel.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

    @Autowired
    private StudentService studentService;
    // met constructor ook mogelijk maar eentje kiezen

    @GetMapping
    public List<StudentModel> getStudents() {
        return studentService.getStudent();
    }

    @PostMapping("/savestudent")
    public void registerNewStudent(@RequestBody StudentModel student) {
        studentService.addNewStudent(student);
    }

    @DeleteMapping(path =  "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId) {
        studentService.deleteStudent(studentId);
    }



}
