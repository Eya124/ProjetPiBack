package tn.esprit.projetpiback.repository;

import org.springframework.data.jpa.repository.Query;
import tn.esprit.projetpiback.entites.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface UsersRepository extends JpaRepository<User,Integer> {
    List<User> findAllByLastLog(LocalDate date);
    List<User> findAllByNomAndPrenom(String nom,String prenom);
    List<User> findAllByFirstlogBetween(LocalDate d1 , LocalDate d2);

    @Query("SELECT u FROM User u WHERE u.interesse = true")
    List<User> findUsersInteresses();

}
