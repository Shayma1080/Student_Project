package org.intecbrussel.service;

import org.intecbrussel.model.StudentModel;
import org.intecbrussel.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // Geeft aan dat deze klasse de business logic bevat. Spring maakt auto een Bean van deze klass (Dependency injection mogelijk)
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired // zorgt dat Spring auto de juiste Bean kiest. Dit is de Dependency injection: Service heeft Repository nodig om te werken.
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
        //Best practice: contructor injection (zoals hier)
    }

    public List<StudentModel> getStudent() {
        return studentRepository.findAll();
    }

    public void addNewStudent(StudentModel student) {
        Optional<StudentModel> optionalStudent = studentRepository.findStudentModelByEmail(student.getEmail());
        if(optionalStudent.isPresent()) {
            throw new IllegalStateException("Student already exists");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);
        if(!exists) {
            throw new IllegalStateException("Student id" + studentId + " does not exist");
        }
        studentRepository.deleteById(studentId);
    }

}
//de methoden komt van jpa repository
