package com.ivans.webshop.service.interfaces;

import com.ivans.webshop.dto.OrderDTO;
import com.ivans.webshop.repository.entity.OrderEntity;
import com.ivans.webshop.repository.enums.OrderStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public interface IOrderService {

    List<OrderDTO> getAllOrders();

    OrderDTO getOrderById(Integer id) throws Exception;

    OrderEntity updateOrder(OrderEntity order, Integer id) throws Exception;

    void deleteOrder(Integer id) throws Exception;

    List<OrderDTO> getByOrderDate(LocalDate ordered);

    List<OrderDTO> getByShippedDate(LocalDate shipped);

    List<OrderDTO> getByStatus(OrderStatus status);

    List<OrderDTO> getByAccountId(Integer accountId);

    OrderDTO getByPaymentId(Integer paymentId) throws Exception;
}
