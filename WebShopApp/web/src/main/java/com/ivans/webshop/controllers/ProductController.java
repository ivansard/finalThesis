package com.ivans.webshop.controllers;

import com.ivans.webshop.repository.entity.CompanyEntity;
import com.ivans.webshop.repository.entity.ProductEntity;
import com.ivans.webshop.repository.enums.ProductCategory;
import com.ivans.webshop.services.CompanyService;
import com.ivans.webshop.services.ProductService;
import org.apache.tomcat.jni.Error;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CompanyService companyService;


    @GetMapping(value = "/products")
    public List<ProductEntity> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping(value = "/products/search/category/{cat}")
    public List<ProductEntity> getProductsByCategory(@PathVariable String cat) {
        ProductCategory category = ProductCategory.valueOf(cat);
        return productService.getProductsByCategory(category);
    }

    @GetMapping(value = "/products/search/company/{companyName}")
    public List<ProductEntity> getProductsByCompany(@PathVariable String companyName) {
        return productService.getProductsByCompanyName(companyName);
    }

    @GetMapping(value = "/products/search/name/{productName}")
    public List<ProductEntity> getProductsByName(@PathVariable String productName) {
            return productService.getProductsByName(productName);
    }

    @GetMapping(value = "/products/{productId}")
    public ProductEntity getProductById(@PathVariable Integer productId) {
        try{
            return productService.getProductById(productId);
        } catch (Exception ex){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product with submitted ID does not exist", ex);
        }
    }

    @PutMapping(value = "/products/{productId}")
    public ProductEntity updateProduct(@RequestBody ProductEntity product, @PathVariable Integer productId) {
        try{
            return productService.updateProduct(product, productId);
        } catch (Exception ex){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product with submitted ID does not exist", ex);
        }
    }

    @DeleteMapping(value = "/products/{productId}")
    public void deleteProduct(@PathVariable Integer productId) {
        try{
            productService.deleteProduct(productId);
        } catch (Exception ex){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product with submitted ID does not exist", ex);
        }
    }
}
