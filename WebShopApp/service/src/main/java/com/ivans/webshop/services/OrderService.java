package com.ivans.webshop.services;

import com.ivans.webshop.repository.entity.OrderEntity;
import com.ivans.webshop.repository.enums.OrderStatus;
import com.ivans.webshop.repository.repo.OrderRepo;
import com.ivans.webshop.service.interfaces.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;

public class OrderService implements IOrderService {

    @Autowired
    private OrderRepo orderRepo;

    public List<OrderEntity> getAllOrders(){
        return orderRepo.findAll();
    }

    public OrderEntity getOrderById(Integer id) throws Exception {
        OrderEntity order = orderRepo.findById(id).orElse(null);
        if (order.equals(null)) {
            throw new Exception("Order with submitted ID does not exist");
        }
        return order;
    }

    public OrderEntity updateOrder(OrderEntity order, Integer id) throws Exception {
        OrderEntity orderInDb = orderRepo.findById(id).orElse(null);
        if (orderInDb.equals(null)) {
            throw new Exception("Line item with submitted ID does not exist");
        }
        order.setId(orderInDb.getId());
        return orderRepo.save(order);
    }

    public void deleteOrder(Integer id) throws Exception {
        OrderEntity orderInDb = orderRepo.findById(id).orElse(null);
        if (orderInDb.equals(null)) {
            throw new Exception("Line item with submitted ID does not exist");
        }
        orderRepo.deleteById(id);
    }

    public List<OrderEntity> getByOrderDate(LocalDate ordered){
        return orderRepo.findByOrdered(ordered);
    }

    public List<OrderEntity> getByShippedDate(LocalDate shipped){
        return orderRepo.findByShipped(shipped);
    }

    public List<OrderEntity> getByStatus(OrderStatus status){
        return orderRepo.findByStatus(status);
    }

    public List<OrderEntity> getByAccountId(Integer accountId){
        return orderRepo.findByAccountId(accountId);
    }

    public OrderEntity getByPaymentId(Integer paymentId) throws Exception {
        OrderEntity orderInDb = orderRepo.findByPaymentId(paymentId);
        if (orderInDb.equals(null)) {
            throw new Exception("Line item with submitted ID does not exist");
        }
        return orderInDb;
    }
}
