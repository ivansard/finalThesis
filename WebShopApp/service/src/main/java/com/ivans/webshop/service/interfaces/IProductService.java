package com.ivans.webshop.service.interfaces;

import com.ivans.webshop.repository.entity.ProductEntity;
import com.ivans.webshop.repository.enums.ProductCategory;

import java.util.List;

public interface IProductService {

    List<ProductEntity> getAllProducts();

    List<ProductEntity> getProductsByCategory(ProductCategory category);

    List<ProductEntity> getProductsByCompanyName(String companyName);

    List<ProductEntity> getProductsByName(String productName);

    ProductEntity getProductById(Integer productId) throws Exception;

    ProductEntity updateProduct(ProductEntity product, Integer productId) throws Exception;

    void deleteProduct(Integer productId) throws Exception;
}
