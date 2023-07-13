package tn.esprit.projetpiback.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tn.esprit.projetpiback.entites.User;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EvenementDto {
    private Long idEvenement;
    private String title ;
    private Date dateDebut;
    private Date dateFin;
    private int nbrMaxParticipants;
    private int nbrParticipants;

    private User usereveIdUser;
    private int centreId;

    private String centreName;
}
