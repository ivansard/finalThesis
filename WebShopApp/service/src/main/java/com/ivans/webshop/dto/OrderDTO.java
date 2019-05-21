package com.ivans.webshop.dto;

import com.ivans.webshop.repository.enums.OrderStatus;

import java.time.LocalDate;
import java.util.List;

public class OrderDTO {

    private LocalDate ordered;
    private LocalDate shipped;
    private OrderStatus status;
    private double total;
    private List<LineItemDTO> lineItems;
//    private PaymentDTO payment;

    public LocalDate getOrdered() {
        return ordered;
    }

    public void setOrdered(LocalDate ordered) {
        this.ordered = ordered;
    }

    public LocalDate getShipped() {
        return shipped;
    }

    public void setShipped(LocalDate shipped) {
        this.shipped = shipped;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public List<LineItemDTO> getLineItems() {
        return lineItems;
    }

    public void setLineItems(List<LineItemDTO> lineItems) {
        this.lineItems = lineItems;
    }

//    public PaymentDTO getPayment() {
//        return payment;
//    }
//
//    public void setPayment(PaymentDTO payment) {
//        this.payment = payment;
//    }
}
