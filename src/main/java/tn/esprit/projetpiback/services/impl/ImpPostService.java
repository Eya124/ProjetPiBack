package tn.esprit.projetpiback.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.projetpiback.entites.*;
import tn.esprit.projetpiback.repository.CommentaireRepository;
import tn.esprit.projetpiback.repository.NotificationRepository;
import tn.esprit.projetpiback.repository.PostRepository;
import tn.esprit.projetpiback.repository.UsersRepository;
import tn.esprit.projetpiback.services.PostService;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ImpPostService implements PostService {

    private final PostRepository postRepository;
    private final CommentaireRepository commentaireRepository;
    private final UsersRepository usersRepository;
    private final NotificationRepository notificationRepository;

    @Override
    public void ajouterPost(Post p) {
        postRepository.save(p);
        List<User> usersInteresses = usersRepository.findUsersInteresses();
        for (User user : usersInteresses) {
            Notification notification = Notification.builder()
                    .content("Un nouveau post a été ajouté : " + p.getDescription())
                    .createdAt(LocalDate.now())
                    .type(NotificationType.NOUVEAU_POST)
                    // Autres informations pertinentes
                    .build();

            notification.setUser(user);
            notificationRepository.save(notification);
            user.getNotifications().add(notification);
        }
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

    @Override
    public void addCommentToPost(Integer idPost, Commentaire commentaire) {
        // Logique pour ajouter le commentaire au post
        Post post = postRepository.findById(idPost).orElse(null);
        if (post != null) {
            commentaire.setPost(post);
            post.getCommentaires().add(commentaire);
            postRepository.save(post);
        }

        // Création et association d'une notification pour les utilisateurs intéressés
        Post postN = commentaire.getPost();
        List<User> usersInteresses = usersRepository.findUsersInteresses();
        for (User user : usersInteresses) {
            Notification notification = Notification.builder()
                    .content("Un nouveau commentaire a été ajouté au post : " + post.getDescription())
                    .createdAt(LocalDate.now())
                    .type(NotificationType.NOUVEAU_COMMENTAIRE)
                    // Autres informations pertinentes
                    .build();

            notification.setUser(user);
            notificationRepository.save(notification);
            user.getNotifications().add(notification);
        }
    }

    @Override
    public void addReplyToComment(Integer idCommentaire, Reply reply) {
        Commentaire commentaire = commentaireRepository.findById(idCommentaire).orElse(null);
        if (commentaire != null) {
            reply.setCommentaire(commentaire);
            commentaire.getReplies().add(reply);
            commentaireRepository.save(commentaire);
        }
        // Logique pour ajouter la réponse au commentaire

        // Création et association d'une notification pour les utilisateurs intéressés
        Commentaire commentaireN = reply.getCommentaire();
        List<User> usersInteresses = usersRepository.findUsersInteresses();
        for (User user : usersInteresses) {
            Notification notification = Notification.builder()
                    .content("Une nouvelle réponse a été ajoutée à un commentaire")
                    .createdAt(LocalDate.now())
                    .type(NotificationType.NOUVELLE_REPONSE)
                    // Autres informations pertinentes
                    .build();

            notification.setUser(user);
            notificationRepository.save(notification);
            user.getNotifications().add(notification);
        }
    }
}
