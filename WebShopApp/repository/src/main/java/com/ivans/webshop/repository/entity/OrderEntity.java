package com.ivans.webshop.repository.entity;

import com.ivans.webshop.repository.enums.OrderStatus;
import net.bytebuddy.implementation.bytecode.constant.IntegerConstant;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDate ordered;
    private LocalDate shipped;
    private OrderStatus status;
    private double total;
    @OneToMany(mappedBy = "order")
    private List<LineItemEntity> lineItems = new ArrayList<LineItemEntity>();
    @OneToOne
    private PaymentEntity payment;
    @ManyToOne
    @JoinColumn(name = "account_id")
    private AccountEntity account;

    public OrderEntity() {
    }

    public OrderEntity(Integer id, LocalDate ordered, LocalDate shipped, OrderStatus status, double total, List<LineItemEntity> lineItems, PaymentEntity payment, AccountEntity account) {
        this.id = id;
        this.ordered = ordered;
        this.shipped = shipped;
        this.status = status;
        this.total = total;
        this.lineItems = lineItems;
        this.payment = payment;
        this.account = account;
    }

    public OrderEntity(LocalDate ordered, LocalDate shipped, OrderStatus status, double total, List<LineItemEntity> lineItems, PaymentEntity payment, AccountEntity account) {
        this.ordered = ordered;
        this.shipped = shipped;
        this.status = status;
        this.total = total;
        this.lineItems = lineItems;
        this.payment = payment;
        this.account = account;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public List<LineItemEntity> getLineItems() {
        return lineItems;
    }

    public void setLineItems(List<LineItemEntity> lineItems) {
        this.lineItems = lineItems;
    }

    public PaymentEntity getPayment() {
        return payment;
    }

    public void setPayment(PaymentEntity payment) {
        this.payment = payment;
    }
}
