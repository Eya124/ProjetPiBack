package tn.esprit.projetpiback.entites;

import java.util.Date;

import javax.persistence.*;

import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pid;

    private String pname;
    private String pcategory;
    private Date pdatepost = new Date(System.currentTimeMillis());
    private String description;
    private String pcity;
    private double pcoin;

    @Column(columnDefinition = "MEDIUMTEXT")
    private String image;
}
