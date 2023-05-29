package com.example.projetpiback.repository;

import com.example.projetpiback.entites.reclamation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface reclamationRepository extends JpaRepository<reclamation, Integer> {
}
