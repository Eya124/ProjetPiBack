package tn.esprit.projetpiback.repository;

import tn.esprit.projetpiback.entites.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<User,Integer> {
}
