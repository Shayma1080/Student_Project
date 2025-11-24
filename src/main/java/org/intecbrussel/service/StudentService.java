package org.intecbrussel.service;

import org.intecbrussel.model.StudentModel;
import org.intecbrussel.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // Geeft aan dat deze klasse de business logic bevat. Spring maakt auto een Bean van deze klass (Dependency injection
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired // zorgt dat Spring auto de juiste Bean kiest. Dit is de Dependency injection: Service heeft Repository nodig om te
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
        //Best practice: contructor injection (zoals hier)
    }

    public List<StudentModel> getStudent() {
        return studentRepository.findAll();
    }

}
