package tn.esprit.projetpiback.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import tn.esprit.projetpiback.entites.Product;
import tn.esprit.projetpiback.services.ProductService;

@RestController
@RequestMapping("boutique")
@CrossOrigin(origins = "*")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/check")
    public String check(){
        return "Working...!";
    }

    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAll() {
        return new ResponseEntity<List<Product>>(productService.getAllProducts(), HttpStatus.OK);
    }


    @PostMapping("/add")
    public ResponseEntity<Product> addProduct(@RequestBody Product product)  throws IOException {
        Product user=productService.addProduct(product);
        return new ResponseEntity<Product>(user,HttpStatus.OK);
    }

    @GetMapping("/getproduct/{pid}")
    public ResponseEntity<Product> getById(@PathVariable Long pid) {
        return new ResponseEntity<Product>(productService.getProductById(pid), HttpStatus.OK);
    }

    @DeleteMapping("delete/{pid}")
    public void deleteProduct(@PathVariable Long pid) {
        productService.deleteProduct(pid);
    }
}
