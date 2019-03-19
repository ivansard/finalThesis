package com.ivans.webshop.services;

import com.ivans.webshop.repository.entity.ProductEntity;
import com.ivans.webshop.repository.enums.ProductCategory;
import com.ivans.webshop.repository.repo.ProductRepo;
import com.ivans.webshop.service.interfaces.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {

    @Autowired
    private ProductRepo productRepo;


    @Override
    public List<ProductEntity> getAllProducts() {
        return productRepo.findAll();
    }

    @Override
    public List<ProductEntity> getProductsByCategory(ProductCategory category) {
        return productRepo.findByCategory(category);
    }

    @Override
    public List<ProductEntity> getProductsByCompanyName(String companyName) {
        return productRepo.findByCompanyName(companyName);
    }


    @Override
    public List<ProductEntity> getProductsByName(String productName) {
        return productRepo.findByName(productName);
    }

    @Override
    public ProductEntity getProductById(Integer productId) throws Exception {
        ProductEntity product = productRepo.findById(productId).orElse(null);
        if(product.equals(null)){
            throw new Exception("Product with submitted ID does not exist");
        }
        return product;
    }

    @Override
    public ProductEntity updateProduct(ProductEntity product, Integer productId) throws Exception {
        ProductEntity productInDb = productRepo.findById(productId).orElse(null);
        if (productInDb.equals(null)) {
            throw new Exception("Product with submitted ID does not exist");
        }
        product.setId(productInDb.getId());
        return productRepo.save(product);
    }

    @Override
    public void deleteProduct(Integer productId) throws Exception {
        ProductEntity productInDb = productRepo.findById(productId).orElse(null);
        if (productInDb.equals(null)) {
            throw new Exception("Product with submitted ID does not exist");
        }
        productRepo.deleteById(productId);
        return;
    }
}
