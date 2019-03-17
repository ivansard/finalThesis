package com.ivans.webshop.service.interfaces;

import com.ivans.webshop.repository.entity.ProductEntity;
import com.ivans.webshop.repository.enums.ProductCategory;

import java.util.List;

public interface IProductService {

    List<ProductEntity> getAllProducts();

    List<ProductEntity> getProductsByCategory(ProductCategory category);

    List<ProductEntity> getProductsByCompany(Integer companyId);

    List<ProductEntity> getProductsByName(String productName);

    ProductEntity getProductById(Integer productId) throws Exception;

    ProductEntity updateProduct(ProductEntity product, Integer productId);

    void deleteProduct(Integer productId);
}
