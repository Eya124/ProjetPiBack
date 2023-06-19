package tn.esprit.projetpiback.services;

import tn.esprit.projetpiback.entites.Commentaire;
import tn.esprit.projetpiback.entites.Post;

import java.util.List;

public interface PostService {
    void ajouterPost(Post p);
    void updatePost(Post p);
    List<Post> getAllPost();
    Post getByIdPost(Integer id);
    void deletePost(Integer id);
    void addCommentToPost(Integer idPost,Integer idUser, Commentaire commentaire);
    void addReplyToComment(Integer idCommentaire, Commentaire reply);
}
