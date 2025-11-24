package org.intecbrussel.repository;

import org.intecbrussel.model.StudentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository // Deze klasse praat met de database(onderdeel van dependency injection, onderdeel van Spring DATA jpa)
public interface StudentRepository extends JpaRepository<StudentModel,Long>  { // kan ook CrudRepository<StudentModel, Integer> gebruiken
    // Om sql te definieren die moet worden uitgevoerd voor een s

    @Query("SELECT s FROM StudentModel s WHERE s.email=?1")
    // Hiermee schrijf je je eigen SQL/JPQL( je kan meerdere voorwaarden combineren
    Optional<StudentModel> findStudentModelByEmail(String email);
    // Als je Optional gebruikt, dan geef je een veiliger antwoord terug
    //Optional.empty() -> niets gevonden
    //Optional.of(student) -> student gevonden
}
