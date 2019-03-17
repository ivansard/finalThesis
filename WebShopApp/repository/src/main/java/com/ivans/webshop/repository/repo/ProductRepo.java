package com.ivans.webshop.repository.repo;


import com.ivans.webshop.repository.entity.ProductEntity;
import com.ivans.webshop.repository.enums.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<ProductEntity, Integer> {

    List<ProductEntity> findByCategory(ProductCategory category);

    List<ProductEntity> findByName(String productName);

    List<ProductEntity> findByCompany(Integer companyId);

}
