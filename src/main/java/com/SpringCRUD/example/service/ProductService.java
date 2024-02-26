package com.SpringCRUD.example.service;

import com.SpringCRUD.example.entity.Product;
import com.SpringCRUD.example.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;


    public Product saveProduct(Product product){

        return productRepository.save(product);
    }

    public List<Product> saveProducts(List<Product> products){

        return productRepository.saveAll(products);
    }

    public List<Product> getProducts(){

        return productRepository.findAll();
    }

    public Product getProductById(int id){

        return productRepository.findById(id).orElse(null);
    }

    public List<Product> getProductByName(String name){

        return productRepository.findByName(name);
    }

    public List<Product> getProductByQuantity(int quantity) {

        return productRepository.findByQuantity(quantity);
    }


    public String deleteProduct(int id){

        productRepository.deleteById(id);
        return "Product Has been removed" + id;
    }

    public Product updateProduct(Product product){
        Product existingProduct=productRepository.findById(product.getId()).orElse(null);
        existingProduct.setName(product.getName());
        existingProduct.setQuantity(product.getQuantity());
        existingProduct.setPrice(product.getPrice());
        return productRepository.save(existingProduct);
    }

    public int getSumOfQuantitiesByProductName(String name) {
        List<Product> products = productRepository.findByName(name);
        if (products.isEmpty()) {
            return 0; // No product found
        } else {
            int sum = 0;
            for (Product product : products) {
                sum += product.getQuantity();
            }
            return sum;
        }
    }



}
