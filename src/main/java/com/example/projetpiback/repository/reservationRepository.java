package com.example.projetpiback.repository;

import com.example.projetpiback.entites.reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface reservationRepository extends JpaRepository<reservation, Integer> {
}
