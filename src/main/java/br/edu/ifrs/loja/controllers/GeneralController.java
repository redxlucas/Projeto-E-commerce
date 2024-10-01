package br.edu.ifrs.loja.controllers;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifrs.loja.models.Product;

@RestController
public class GeneralController {
    
    @PostMapping("/produto")
    public Product createProduct(Product product){
        product.insert();
        return product;
    }

    @GetMapping("/produto/{id}")
    public Product getProduct(@PathVariable int id){
        Product product = new Product();
        product.setId(id);
        product.get();
        return product;
    }

    @GetMapping("/produto")
    public ArrayList<Product> listAll(){
        return Product.getAll();
    }

    @PutMapping("/produto")
    public void updateProduct(Product product){
        product.update();
    }

    @DeleteMapping("/produto")
    public void deleteProduct(Product product){
        product.delete();
    }
}
