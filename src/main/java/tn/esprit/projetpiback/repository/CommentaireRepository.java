package tn.esprit.projetpiback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.projetpiback.entites.Commentaire;
import tn.esprit.projetpiback.entites.Post;

import java.util.List;

@Repository
public interface CommentaireRepository extends JpaRepository<Commentaire,Integer> {
    List<Commentaire> findAllByPostIdPost(Integer id);
    @Query("SELECT c FROM Commentaire c WHERE c.post.idPost = :postId AND c.archive = false")
    List<Commentaire> getCommentaireByPostNotArchive(int postId);
}
