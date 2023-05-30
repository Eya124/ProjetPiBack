package tn.esprit.projetpiback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.projetpiback.entites.Commentaire;

@Repository
public interface CommentaireRepository extends JpaRepository<Commentaire,Integer> {
}
