package tn.esprit.projetpiback.services;

import java.util.List;

import tn.esprit.projetpiback.entites.Product;

public interface ProductService {
    List<Product> getAllProducts() ;
    List<Product> getProductsByUserID(int idUser);
    Product getProductById(Long pid);
    // void addProduct(Product product, String token); 
    Product addProduct(Product product); 
    void deleteProduct(Long pid);
}
