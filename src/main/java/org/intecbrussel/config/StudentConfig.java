package org.intecbrussel.config;

import org.intecbrussel.model.StudentModel;
import org.intecbrussel.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration // Spring gaat op zoek naar methodes met @Bean binnen deze klasse en beheert de objecten
public class StudentConfig {

    @Bean // Spring moet een object maken van deze methode. Dit object komt in de Spring App Contex

    CommandLineRunner commandLineRunner(StudentRepository repository){ // Het wordt auto uitgevoerds
        return args -> { // Dit draait auto na app startup
            StudentModel mariam = new StudentModel("mariam", "mariam@gmail.com",
                    LocalDate.of(2000, Month.JANUARY, 5));
            StudentModel alex = new StudentModel("Alex", "alex@gmail.com",
                    LocalDate.of(2000, Month.JANUARY, 5));
            StudentModel john = new StudentModel("John", "john@gmail.com",
                    LocalDate.of(2000, Month.JANUARY, 5));
            StudentModel tony = new StudentModel("Tony", "tony@gmail.com",
                    LocalDate.of(2000,Month.JANUARY, 5));
            StudentModel jane = new StudentModel("Jane","jane@gmail.com",
                    LocalDate.of(2000,Month.JANUARY, 5));
            StudentModel jack = new StudentModel("Jack", "jack@gmail.com",
                    LocalDate.of(2000,Month.JANUARY, 5));

            repository.saveAll(List.of(mariam,alex,john,tony,jane,jack));

        };
    }
}
