package tn.esprit.projetpiback.repository;

import tn.esprit.projetpiback.entites.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface UsersRepository extends JpaRepository<User,Integer> {
    List<User> findAllByLastLog(LocalDate date);
    List<User> findAllByNomAndPrenom(String nom,String prenom);

}
