package com.ivans.webshop.dto;

import java.time.LocalDate;
import java.util.List;

public class AccountDTO {

    private String name;
    private boolean isClosed;
    private LocalDate opened;
    private LocalDate closed;
    private List<OrderDTO> orders;
    private List<PaymentDetailsDTO> paymentDetails;

    public List<PaymentDetailsDTO> getPaymentDetails() {
        return paymentDetails;
    }

    public void setPaymentDetails(List<PaymentDetailsDTO> paymentDetails) {
        this.paymentDetails = paymentDetails;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isClosed() {
        return isClosed;
    }

    public void setClosed(boolean closed) {
        isClosed = closed;
    }

    public LocalDate getOpened() {
        return opened;
    }

    public void setOpened(LocalDate opened) {
        this.opened = opened;
    }

    public LocalDate getClosed() {
        return closed;
    }

    public void setClosed(LocalDate closed) {
        this.closed = closed;
    }

    public List<OrderDTO> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderDTO> orders) {
        this.orders = orders;
    }
}
