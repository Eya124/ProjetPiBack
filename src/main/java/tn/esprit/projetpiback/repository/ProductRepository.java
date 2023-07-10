package tn.esprit.projetpiback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.projetpiback.entites.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
