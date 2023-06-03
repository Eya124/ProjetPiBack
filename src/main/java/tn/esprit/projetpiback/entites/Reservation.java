package tn.esprit.projetpiback.entites;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idReservation;

    private int nbrParticipants;
    private String statusReservation;

    // !!!!!!!!! Ayed 31/05/2023 <3 !!!!!!!!!
    @JsonIgnore
    @ManyToMany(mappedBy = "reservations",cascade = CascadeType.REMOVE)
    private List<Evenement> evenements;

    @ManyToOne
    private User user;

    @OneToOne()
    private Reclamation reclamation;
}
