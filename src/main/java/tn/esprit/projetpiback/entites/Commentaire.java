package tn.esprit.projetpiback.entites;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Commentaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCommentaire;
    private String content;

    private LocalDate createdAt;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;
    @ManyToOne
    private Commentaire parentComment;
    @OneToMany(mappedBy = "parentComment", cascade = CascadeType.ALL)
    private List<Commentaire> replies;
}