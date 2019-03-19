package com.ivans.webshop.services;

import com.ivans.webshop.dto.OrderDTO;
import com.ivans.webshop.mappers.OrderMapper;
import com.ivans.webshop.repository.entity.OrderEntity;
import com.ivans.webshop.repository.enums.OrderStatus;
import com.ivans.webshop.repository.repo.OrderRepo;
import com.ivans.webshop.service.interfaces.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OrderService implements IOrderService {

    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private OrderMapper orderMapper;

    public List<OrderDTO> getAllOrders(){
        List<OrderEntity> orderEntities = orderRepo.findAll();
        List<OrderDTO> orderDtos = new ArrayList<OrderDTO>();
        for (OrderEntity orderEntity: orderEntities) {
            orderDtos.add(orderMapper.order2DTO(orderEntity));
        }
        return orderDtos;
    }

    public List<OrderDTO> getByOrderDate(LocalDate ordered){
        List<OrderEntity> orderEntities = orderRepo.findByOrdered(ordered);
        List<OrderDTO> orderDtos = new ArrayList<OrderDTO>();
        for (OrderEntity orderEntity: orderEntities) {
            orderDtos.add(orderMapper.order2DTO(orderEntity));
        }
        return orderDtos;
    }

    public List<OrderDTO> getByShippedDate(LocalDate shipped){
        List<OrderEntity> orderEntities = orderRepo.findByShipped(shipped);
        List<OrderDTO> orderDtos = new ArrayList<OrderDTO>();
        for (OrderEntity orderEntity: orderEntities) {
            orderDtos.add(orderMapper.order2DTO(orderEntity));
        }
        return orderDtos;
    }

    public List<OrderDTO> getByStatus(OrderStatus status){
        List<OrderEntity> orderEntities = orderRepo.findByStatus(status);
        List<OrderDTO> orderDtos = new ArrayList<OrderDTO>();
        for (OrderEntity orderEntity: orderEntities) {
            orderDtos.add(orderMapper.order2DTO(orderEntity));
        }
        return orderDtos;
    }

    public List<OrderDTO> getByAccountId(Integer accountId){
        List<OrderEntity> orderEntities = orderRepo.findByAccountId(accountId);
        List<OrderDTO> orderDtos = new ArrayList<OrderDTO>();
        for (OrderEntity orderEntity: orderEntities) {
            orderDtos.add(orderMapper.order2DTO(orderEntity));
        }
        return orderDtos;
    }

    public OrderDTO getOrderById(Integer id) throws Exception {
        OrderEntity order = orderRepo.findById(id).orElse(null);
        if (order.equals(null)) {
            throw new Exception("Order with submitted ID does not exist");
        }
        return orderMapper.order2DTO(order);
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

    public OrderDTO getByPaymentId(Integer paymentId) throws Exception {
        OrderEntity orderInDb = orderRepo.findByPaymentId(paymentId);
        if (orderInDb.equals(null)) {
            throw new Exception("Line item with submitted ID does not exist");
        }
        return orderMapper.order2DTO(orderInDb);
    }
}
