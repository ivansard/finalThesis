package com.ivans.webshop.repository.repo;

import com.ivans.webshop.repository.entity.OrderEntity;
import com.ivans.webshop.repository.enums.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface OrderRepo extends JpaRepository<OrderEntity, Integer> {


    List<OrderEntity> findByOrdered(LocalDate ordered);

    List<OrderEntity> findByShipped(LocalDate shipped);

    List<OrderEntity> findByStatus(OrderStatus status);

    List<OrderEntity> findByAccountId(Integer accountId);

//    OrderEntity findByPaymentId(Integer paymentId);


}
