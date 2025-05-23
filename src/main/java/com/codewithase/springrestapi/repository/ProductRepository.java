package com.codewithase.springrestapi.repository;

import com.codewithase.springrestapi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    // find product by category
    List<Product> findProductByCategory(String name);

    // find products with price less or equal to maxprice
    List<Product> findProductByPriceLessThanEqual(Double maxprice);

    // find products containing name (case sensitive)
    List<Product> findProductByNameContainingIgnoreCase(String name);
}
