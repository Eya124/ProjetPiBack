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
    private LocalDate firstlog;
    private LocalDate lastLog;
    private int nbrSignalement;
    private boolean interesse;
    @JsonIgnore
    @OneToMany(mappedBy = "userpost")
    private List<Post> posts;

    @ManyToOne()
    private Reclamation reclamation;

    @OneToMany(mappedBy = "usereve")
    private List<Evenement> evenements;

   // @JsonIgnore
   //  @OneToMany(mappedBy = "classe")
   // private List<coursClassroom> coursClassrooms;
   @OneToMany
   private List<Notification> notifications;

   // !!!!!!!!! Ayed 31/05/2023 <3 !!!!!!!!!
    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Reservation> reservations;


}
