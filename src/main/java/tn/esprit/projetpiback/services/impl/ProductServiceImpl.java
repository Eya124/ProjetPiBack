package tn.esprit.projetpiback.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import tn.esprit.projetpiback.entites.Product;
import tn.esprit.projetpiback.repository.ProductRepository;
import tn.esprit.projetpiback.services.ProductService;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long pid) {
        return productRepository.findById(pid).orElse(null);
    }

    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }
    
    @Override
    public void deleteProduct(Long pid) {
        productRepository.deleteById(pid);
    }
}
