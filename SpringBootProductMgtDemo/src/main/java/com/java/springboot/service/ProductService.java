package com.java.springboot.service;

import com.java.springboot.model.Product;
import com.java.springboot.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository dao;
    public List<Product> getProducts() {
        return dao.findAll();
    }

    public void saveProduct(Product p) {
        dao.save(p);
    }

    public Product getProductById(int id) {
        return dao.findById(id).orElse(new Product());
    }

    public Product getProductByName(String name) {
        return dao.findByName(name);
    }
    public void deleteProduct(int id) {
        dao.deleteById(id);
    }


}
