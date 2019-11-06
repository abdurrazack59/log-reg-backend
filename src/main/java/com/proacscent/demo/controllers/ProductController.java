package com.proacscent.demo.controllers;

import com.proacscent.demo.entities.Product;
import com.proacscent.demo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;


    @PostMapping(value = "/save")
    public String saveProduct(@RequestBody Product product){
        productRepository.save(product);
        return "Save Successful";
    }

    @GetMapping(value = "/getProduct")
    public Product getProduct(@RequestParam long id){
        Product product = productRepository.getOne(id);
        return product;
    }

    @PutMapping(value = "/updateProduct")
    public String updateProduct(@RequestParam long id,@RequestBody Product product){
        product.setId(id);
        productRepository.save(product);
        return "Product with "+id+" updated Successfully";
    }
}
