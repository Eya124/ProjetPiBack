package tn.esprit.projetpiback.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.projetpiback.entites.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("SELECT p FROM Product p JOIN p.user u WHERE u.idUser = :userID")
    List<Product> findProductbyUserId(@Param("userID") int userID);
}
