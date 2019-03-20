package com.ivans.webshop.service.interfaces;

import com.ivans.webshop.dto.ProductDTO;
import com.ivans.webshop.repository.entity.ProductEntity;
import com.ivans.webshop.repository.enums.ProductCategory;

import java.util.List;

public interface IProductService {

    List<ProductDTO> getAllProducts();

    List<ProductDTO> getProductsByCategory(ProductCategory category);

    List<ProductDTO> getProductsByCompanyName(String companyName);

    List<ProductDTO> getProductsByName(String productName);

    ProductDTO getProductById(Integer productId) throws Exception;

    ProductEntity updateProduct(ProductEntity product, Integer productId) throws Exception;

    void deleteProduct(Integer productId) throws Exception;
}
