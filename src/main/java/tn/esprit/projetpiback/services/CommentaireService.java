package tn.esprit.projetpiback.services;

import tn.esprit.projetpiback.entites.Commentaire;
import tn.esprit.projetpiback.entites.Post;

public interface CommentaireService {
    void ajouterCommentaire (Commentaire c, Integer idUser, Integer idPost);
}
