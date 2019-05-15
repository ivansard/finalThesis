package com.ivans.webshop.services;

import com.ivans.webshop.dto.ProductDTO;
import com.ivans.webshop.mappers.ProductMapper;
import com.ivans.webshop.repository.entity.ProductEntity;
import com.ivans.webshop.repository.enums.ProductCategory;
import com.ivans.webshop.repository.repo.ProductRepo;
import com.ivans.webshop.service.interfaces.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService implements IProductService {

    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private ProductMapper productMapper;


    @Override
    public List<ProductDTO> getAllProducts() {
        List<ProductEntity> productEntities = productRepo.findAll();
        List<ProductDTO> productDTOs = new ArrayList<ProductDTO>();
        for (ProductEntity productEntity: productEntities) {
            productDTOs.add(productMapper.product2DTO(productEntity));
        }
        return productDTOs;
    }

    @Override
    public List<ProductDTO> getProductsByCategory(ProductCategory category) {
        List<ProductEntity> productEntities = productRepo.findByCategory(category);
        List<ProductDTO> productDTOs = new ArrayList<ProductDTO>();
        for (ProductEntity productEntity: productEntities) {
            productDTOs.add(productMapper.product2DTO(productEntity));
        }
        return productDTOs;
    }

    @Override
    public List<ProductDTO> getProductsByCompanyName(String companyName) {
        List<ProductEntity> productEntities = productRepo.findByCompanyName(companyName);
        List<ProductDTO> productDTOs = new ArrayList<ProductDTO>();
        for (ProductEntity productEntity: productEntities) {
            productDTOs.add(productMapper.product2DTO(productEntity));
        }
        return productDTOs;
    }


    @Override
    public List<ProductDTO> getProductsByName(String productName) {
        List<ProductEntity> productEntities = productRepo.findByName(productName);
        List<ProductDTO> productDTOs = new ArrayList<ProductDTO>();
        for (ProductEntity productEntity: productEntities) {
            productDTOs.add(productMapper.product2DTO(productEntity));
        }
        return productDTOs;
    }

    @Override
    public ProductDTO getProductById(Integer productId) throws Exception {
        ProductEntity product = productRepo.findById(productId).orElse(null);
        if(product.equals(null)){
            throw new Exception("Product with submitted ID does not exist");
        }
        return productMapper.product2DTO(product);
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
