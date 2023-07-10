package tn.esprit.projetpiback.services;

import java.util.List;

import tn.esprit.projetpiback.entites.Product;

public interface ProductService {
    List<Product> getAllProducts() ;
    Product getProductById(Long pid);
    Product addProduct(Product product); 
    void deleteProduct(Long pid);
}
