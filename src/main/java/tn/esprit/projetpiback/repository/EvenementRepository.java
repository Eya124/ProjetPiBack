package tn.esprit.projetpiback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.projetpiback.entites.Evenement;
import java.util.Date;
import java.util.List;
public interface EvenementRepository extends JpaRepository<Evenement,Long> {




// sl7ha ayed kent hka "findAllUserIdUser"
    //findByUsereveIdUser
    List<Evenement> findAllByUsereveIdUser (int iduser);
}
