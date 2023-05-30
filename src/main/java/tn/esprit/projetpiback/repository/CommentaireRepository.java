package tn.esprit.projetpiback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.projetpiback.entites.Commentaire;

public interface CommentaireRepository extends JpaRepository<Commentaire,Integer> {
}
