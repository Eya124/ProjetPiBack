package tn.esprit.projetpiback.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import tn.esprit.projetpiback.entites.Commentaire;
import tn.esprit.projetpiback.entites.Post;
import tn.esprit.projetpiback.entites.User;
import tn.esprit.projetpiback.repository.CommentaireRepository;
import tn.esprit.projetpiback.repository.PostRepository;
import tn.esprit.projetpiback.repository.UsersRepository;
import tn.esprit.projetpiback.services.CommentaireService;
import tn.esprit.projetpiback.services.PostService;

import java.time.LocalDate;

@Service
@Validated
@RequiredArgsConstructor
public class ImpCommentaireService implements CommentaireService {

    private final PostRepository postRepository;
    private final CommentaireRepository commentaireRepository;
    private final UsersRepository usersRepository;

    @Override
    public void ajouterCommentaire(Commentaire c, Integer idUser, Integer idPost) {
        c.setCreatedAt(LocalDate.now());

        // Récupérer le post associé à l'ID
        Post post = postRepository.findById(idPost).orElse(null);
        if (post != null) {
            c.setPost(post);

            // Récupérer l'utilisateur associé à l'ID
            User user = usersRepository.findById(idUser).orElse(null);
            if (user != null) {
                c.setUsercommentaire(user);

                // Enregistrer le commentaire
                commentaireRepository.save(c);

                // Ajouter le commentaire à la liste des commentaires du post
                post.getCommentaires().add(c);
                postRepository.save(post);
            }
        }
    }
}
