package tn.esprit.projetpiback.entites;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

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
   // private int nbr_signalement;


    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Commentaire> commentaires;

    @ManyToOne
    User userpost;

    @OneToOne
    Feedback feedback;
}
