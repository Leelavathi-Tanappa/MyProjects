package com.java.springboot.controller;

import com.java.springboot.model.Product;
import com.java.springboot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService service;
    @GetMapping("/products")
    public List<Product> getProducts(){
        List<Product> products = service.getProducts();
        return products;
    }

    @PostMapping("/saveproduct")
    public Product saveProduct(@RequestBody Product p){
        service.saveProduct(p);
        return p;
    }

    @GetMapping("/product/id/{id}")
    public Product getProductById(@PathVariable int id){
        Product p =  service.getProductById(id);
        return p;
    }

    @GetMapping("/product/name/{name}")
    public Product getProductByName(@PathVariable String name){
       Product p = service.getProductByName(name);
       return p;
    }
    @DeleteMapping("/deleteproduct/{id}")
    public void deleteProduct(@PathVariable int id){
        service.deleteProduct(id);
    }
}
