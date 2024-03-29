package com.SpringCRUD.example.repository;

import com.SpringCRUD.example.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findByName(String name);

    List<Product> findByQuantity(int quantity);
}
