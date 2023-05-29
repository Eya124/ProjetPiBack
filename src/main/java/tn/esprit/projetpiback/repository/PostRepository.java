package tn.esprit.projetpiback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.projetpiback.entites.Post;

public interface PostRepository extends JpaRepository<Post,Integer> {
}
