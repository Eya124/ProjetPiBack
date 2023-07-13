package tn.esprit.projetpiback.entites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Centre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private String name;
    private  String description;
    private  String ville;
    @OneToMany(mappedBy = "centre", cascade =  CascadeType.ALL)
    private List<Evenement> evenements;
}
