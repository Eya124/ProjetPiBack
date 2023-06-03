package tn.esprit.projetpiback.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.projetpiback.entites.Reclamation;
import tn.esprit.projetpiback.entites.User;
import tn.esprit.projetpiback.repository.ReclamationRepository;
import tn.esprit.projetpiback.services.ReclamationService;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ReclamationServiceImp implements ReclamationService {
    private final ReclamationRepository reclamationRepository;
    @Override
    public void ajouterReclamation(Reclamation rec,int iduser1,int iduser2) {

        reclamationRepository.save(rec);
    }

    @Override
    public List<Reclamation> getAllReclamations() {
        return null;
    }
}
