package tn.esprit.projetpiback.entites;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
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

    private Date daterec;
    private Boolean Status;
    private Boolean archive;



    @JsonIgnore
    @OneToOne
    private User userarec;

    @ManyToOne
    private User userrec;


}
