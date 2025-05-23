package com.codewithase.springrestapi.service;

import com.codewithase.springrestapi.model.Product;
import com.codewithase.springrestapi.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // get all the product
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // get product by id
    // Optional -> id not exist in DB
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    // get products by category
    public List<Product> getProductByCategory(String categoryName) {
        return productRepository.findProductByCategory(categoryName);
    }

    //
    public List<Product> getProductsByPriceLessThanEqual(Double price) {
        return productRepository.findProductByPriceLessThanEqual(price);
    }

    public List<Product> getProductsByProductName(String name){
        return productRepository.findProductByNameContainingIgnoreCase(name);
    }

    // Crud Part Save and Delete
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public void deleteProduct(Product product) {
        productRepository.delete(product);
    }
}
