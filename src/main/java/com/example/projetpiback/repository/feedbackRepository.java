package com.example.projetpiback.repository;

import com.example.projetpiback.entites.feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface feedbackRepository extends JpaRepository<feedback, Integer> {
}
