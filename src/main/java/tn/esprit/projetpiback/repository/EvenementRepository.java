package tn.esprit.projetpiback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.projetpiback.entites.Evenement;

public interface EvenementRepository extends JpaRepository<Evenement,Long> {
}
