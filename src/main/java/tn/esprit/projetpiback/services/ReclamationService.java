package tn.esprit.projetpiback.services;


import tn.esprit.projetpiback.entites.Reclamation;
import tn.esprit.projetpiback.entites.User;

import java.util.List;

public interface ReclamationService {


    void ajouterReclamation(Reclamation rec,int iduser1,int iduser2);

    List<Reclamation> getAllReclamations();
}
