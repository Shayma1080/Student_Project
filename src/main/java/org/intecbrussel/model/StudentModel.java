package org.intecbrussel.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table
public class StudentModel {
    @Id
//    De @SequenceGenerator-annotatie definieert een primaire sleutelgenerator
    @SequenceGenerator( // table maken:
            name = "student_sequence", // de sequence in de database heet: student_sequence
            sequenceName = "student_sequence", // Spring bewaart een generator met de naam: student_sequence
            allocationSize = 1 // elke nieuwe ID wordt met 1 verhoogd
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE, // gebruik een sequence
            generator = "student_sequence" // gebruik de sequence die we hierboven gedefinieerd hebben
    )

    private long id;
    private String name;
    private String surname;
    private String email;
    private LocalDate dob;

    @Transient
    // Dit veld wordt NIET opgeslagen in de database
    // Geen kolom voor dit veld in de tabel
    private Integer age;

    public StudentModel() {}

    public StudentModel(String name, String surname, String email) {
        name = name;
        this.surname = surname;
        this.email = email;
    }

    public StudentModel(String name, String email, LocalDate dob) {
        this.name = name;
        this.email = email;
        this.dob = dob;
    }

    public StudentModel(long id, String name, String surname, String email, LocalDate dob, Integer age) {
        this.id = id;
        name = name;
        this.surname = surname;
        this.email = email;
        this.dob = dob;
        this.age = age;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof StudentModel that)) return false;
        return id == that.id && Objects.equals(name, that.name) && Objects.equals(surname, that.surname) && Objects.equals(email, that.email) && Objects.equals(dob, that.dob) && Objects.equals(age, that.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, email, dob, age);
    }

    @Override
    public String toString() {
        return "StudentModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                ", age=" + age +
                '}';
    }
}
