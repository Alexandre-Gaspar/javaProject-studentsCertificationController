package com.rocketseat.certification_nlw.modules.students.controllers.entities;

import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "students") // Para o banco de dados reconhecer que isso é uma tabela, ele converte essa classe em uma tabela
public class StudentEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID) // Gera um código do tipo UUID
    private UUID id;

    @Column(unique = true, nullable = false)
    private String email;
    
    @OneToMany(mappedBy = "studentEntity")
    private List<CertificationStudentEntity> CertificationStudentEntity;

    @CreationTimestamp
    private LocalDateTime createdAt;

}
