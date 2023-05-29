package tn.esprit.projetpiback.repository;

import tn.esprit.projetpiback.entites.Reclamation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReclamationRepository extends JpaRepository<Reclamation, Integer> {
}
