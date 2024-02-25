package com.SpringCRUD.example.controller;

import com.SpringCRUD.example.entity.Product;
import com.SpringCRUD.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/addproduct")
    public Product addProduct(@RequestBody Product product){

        return productService.saveProduct(product);
    }

    @PostMapping("/addproducts")
    public List<Product> addProducts(@RequestBody List<Product> products){

        return  productService.saveProducts(products);
    }

    @GetMapping("/products")
    public List<Product> findAllProducts(){

        return productService.getProducts();
    }

    @GetMapping("/product/{id}")
    public Product getProductById(@PathVariable int id){

        return productService.getProductById(id);
    }

    @GetMapping("/product/{name}")
    public List<Product> findProductByName(@PathVariable String name){

        return productService.getProductByName(name);
    }


    @PutMapping("/update")
    public Product updateProduct(@RequestBody Product product){

        return productService.updateProduct(product);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(int id){

        return productService.deleteProduct(id);
    }






}
