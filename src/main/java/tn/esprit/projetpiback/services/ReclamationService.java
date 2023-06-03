package tn.esprit.projetpiback.services;


import tn.esprit.projetpiback.entites.Reclamation;

import java.util.List;

public interface ReclamationService {


    void ajouterReclamation(Reclamation rec);

    List<Reclamation> getAllReclamations();
}
