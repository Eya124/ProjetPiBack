package tn.esprit.projetpiback.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.projetpiback.entites.Post;
import tn.esprit.projetpiback.repository.PostRepository;
import tn.esprit.projetpiback.services.PostService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ImpPostService implements PostService {

    private final PostRepository postRepository;

    @Override
    public void ajouterPost(Post p) {
        postRepository.save(p);
    }

    @Override
    public void updatePost(Post p) {
        postRepository.save(p);
    }

    @Override
    public List<Post> getAllPost() {
        return postRepository.findAll();
    }

    @Override
    public Post getByIdPost(Integer id) {
        return postRepository.findById(id).orElse(null);
    }

    @Override
    public void deletePost(Integer id) {
        postRepository.deleteById(id);
    }
}
