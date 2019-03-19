package com.ivans.webshop.service.interfaces;

import com.ivans.webshop.repository.entity.OrderEntity;
import com.ivans.webshop.repository.enums.OrderStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public interface IOrderService {

    List<OrderEntity> getAllOrders();

    OrderEntity getOrderById(Integer id) throws Exception;

    OrderEntity updateOrder(OrderEntity order, Integer id) throws Exception;

    void deleteOrder(Integer id) throws Exception;

    List<OrderEntity> getByOrderDate(LocalDate ordered);

    List<OrderEntity> getByShippedDate(LocalDate shipped);

    List<OrderEntity> getByStatus(OrderStatus status);

    List<OrderEntity> getByAccountId(Integer accountId);

    OrderEntity getByPaymentId(Integer paymentId) throws Exception;
}
