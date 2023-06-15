package tn.esprit.projetpiback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.projetpiback.entites.Post;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post,Integer> {

}
