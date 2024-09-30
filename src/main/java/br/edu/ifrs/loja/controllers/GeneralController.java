package br.edu.ifrs.loja.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifrs.loja.models.Product;

@RestController
public class GeneralController {
    
    @PostMapping("product")
    public Product create(Product product){
        product.insert();
        return product;
    }

    @DeleteMapping("product")
    public Boolean delete(Product product){
        
        return true;
    }
}
