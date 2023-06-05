package tn.esprit.projetpiback.entites;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Reclamation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idReclamation;
    private String object;
    private String description;

    @OneToMany(mappedBy = "reclamation")
    private List<User> users;

    @OneToOne()
    private Reservation reservation;

}
