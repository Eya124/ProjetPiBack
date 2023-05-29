package tn.esprit.projetpiback.services;

import tn.esprit.projetpiback.entites.Post;

import java.util.List;

public interface PostService {
    void ajouterPost(Post p);
    void updatePost(Post p);
    List<Post> getAllPost();
    Post getByIdPost(Integer id);
    void deletePost(Integer id);
}
