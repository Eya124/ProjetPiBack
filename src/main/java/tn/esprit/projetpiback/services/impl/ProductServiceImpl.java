package tn.esprit.projetpiback.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.AllArgsConstructor;
import tn.esprit.projetpiback.entites.Product;
import tn.esprit.projetpiback.entites.User;
import tn.esprit.projetpiback.repository.ProductRepository;
import tn.esprit.projetpiback.repository.UsersRepository;
import tn.esprit.projetpiback.services.ProductService;
import tn.esprit.projetpiback.security.JWTGenerator;
import tn.esprit.projetpiback.security.SecurityConstants;

import java.util.Collections;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService{

    @Autowired
    private final ProductRepository productRepository;
    private final UsersRepository usersRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> getProductsByUserID(int idUser) {
        return productRepository.findProductbyUserId(idUser);
    }

    @Override
    public Product getProductById(Long pid) {
        return productRepository.findById(pid).orElse(null);
    }

    @Override
    public Product addProduct(Product product) { 
       return productRepository.save(product);
    }
    // private int extractUserIdFromJwtToken(String token) {
    //     Claims claims = Jwts.parser()
    //             .setSigningKey(SecurityConstants.JWT_SECRET)
    //             .parseClaimsJws(token)
    //             .getBody();
    //     String userId = claims.get("user_id", String.class);
    //     return Integer.parseInt(userId);
    // }

    // @Override
    // public void addProduct(Product product, String token) {
    //     int userId = extractUserIdFromJwtToken(token);
    //     User user = usersRepository.findById(userId).orElse(null);
    //     product.setUser(user);
    //     productRepository.save(product);
    // }

   

    @Override
    public void deleteProduct(Long pid) {
        productRepository.deleteById(pid);
    }
}
