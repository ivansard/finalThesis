package com.ivans.webshop.repository.repo;

import com.ivans.webshop.repository.entity.LineItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LineItemRepo extends JpaRepository<LineItemEntity, Integer> {

    List<LineItemEntity> findByOrderId(Integer orderId);

    List<LineItemEntity> findByProductId(Integer productId);

    List<LineItemEntity> findByProductName(String productName);

}
