package tn.esprit.projetpiback.entites;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPost;

    private String link_piecejointe;
    private String link;
    private String description;
    private String adresse;
    private LocalDate Date;
    private int nbr_participant;
    private String type_logement;
    private String nbr_likes;
    private int nbr_signalement;
}
