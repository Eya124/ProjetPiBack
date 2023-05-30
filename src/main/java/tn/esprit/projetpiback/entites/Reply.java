package tn.esprit.projetpiback.entites;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Reply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String content;

    private LocalDate createdAt;

    @ManyToOne
    @JoinColumn(name = "comment_id")
    private Commentaire commentaire;
}
