package tn.esprit.projetpiback.entites;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;


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
    private Long telephone;
    private int age;
    private Long cin;
    private String prenomPere;
    private int numPere;
    private String password;
    private String email;
    private String adresse;
    private LocalDate Firstlog;
    private LocalDate lastLog;
    private int nbrSignalement;
    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Post> posts;

   // @JsonIgnore
  //  @OneToMany(mappedBy = "classe")
   // private List<coursClassroom> coursClassrooms;
}
