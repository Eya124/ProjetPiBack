package tn.esprit.projetpiback.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CentreDto {
    private  int id;
    private String name;
    private  String description;
    private  String ville;
}
