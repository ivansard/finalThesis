package com.ivans.webshop.controllers;

import com.ivans.webshop.dto.OrderDTO;
import com.ivans.webshop.repository.entity.OrderEntity;
import com.ivans.webshop.repository.enums.OrderStatus;
import com.ivans.webshop.services.OrderService;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/orders")
    public List<OrderDTO> getAllOrders(){
        return orderService.getAllOrders();
    }

    @GetMapping("/orders/{orderId}")
    public OrderDTO getOrderById(@PathVariable Integer orderId) throws Exception {
        try{
            return orderService.getOrderById(orderId);
        } catch (Exception ex){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Order with submitted ID does not exist", ex);
        }
    }

    @PutMapping("/orders/{orderId}")
    public OrderEntity updateOrder(@RequestBody OrderEntity order, @PathVariable Integer orderId) throws Exception {
        try{
            return orderService.updateOrder(order, orderId);
        } catch (Exception ex){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Order with submitted ID does not exist", ex);
        }
    }

    @DeleteMapping("/orders/{orderId}")
    public void deleteOrder(@PathVariable Integer orderId) throws Exception {
        try{
            orderService.deleteOrder(orderId);
        } catch (Exception ex){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Order with submitted ID does not exist", ex);
        }
    }

    @GetMapping("/orders/ordered/{orderedDate}")
    public List<OrderDTO> getByOrderDate(@PathVariable LocalDate orderedDate){
        return orderService.getByOrderDate(orderedDate);
    }

    @GetMapping("/orders/shipped/{shippedDate}")
    public List<OrderDTO> getByShippedDate(@PathVariable LocalDate shippedDate){
        return orderService.getByShippedDate(shippedDate);
    }

    @GetMapping("/orders/status/{status}")
    public List<OrderDTO> getByStatus(@PathVariable OrderStatus status){
        return orderService.getByStatus(status);
    }

    @GetMapping("/orders/account/{accountId}")
    public List<OrderDTO> getByAccountId(@PathVariable Integer accountId){
        return orderService.getByAccountId(accountId);
    }

    @GetMapping("/orders/payment/{paymentId}")
    public OrderDTO getByPaymentId(@PathVariable Integer paymentId) throws Exception {
        try{
//            return orderService.getByPaymentId(paymentId);
            return null;
        } catch (Exception ex){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Order with submitted payment does not exist", ex);
        }
    }
}
