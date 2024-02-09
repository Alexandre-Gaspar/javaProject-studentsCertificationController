package com.rocketseat.certification_nlw.modules.students.repositories;

import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rocketseat.certification_nlw.modules.students.controllers.entities.CertificationStudentEntity;

// @Repository is Opcional
public interface CertificationStudentRepository extends JpaRepository<CertificationStudentEntity, UUID>{

    /**
     * @param email
     * @param technology
     * @return
     */
    @Query("SELECT c FROM certifications c INNER JOIN c.studentEntity std WHERE std.email = :email AND c.technology = :technology")
    List<CertificationStudentEntity> findByStudentEmailAndTechnology(String email, String technology);
}
