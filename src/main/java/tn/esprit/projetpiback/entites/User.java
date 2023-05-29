package tn.esprit.projetpiback.entites;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;


@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUser;

    private String nom;
    private String prenom;
    private int telephone;
    private int age;
    private int cin;
    private String prenomPere;
    private int numPere;
    private String password;
    private String email;
    private String adresse;
    private LocalDate lastLog;
    private int nbrSignalement;

   // @JsonIgnore
  //  @OneToMany(mappedBy = "classe")
   // private List<coursClassroom> coursClassrooms;
}
