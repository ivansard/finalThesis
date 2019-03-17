package com.ivans.webshop.repository.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "accounts")
public class AccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private
    Integer id;
    private String name;
    private boolean isClosed = false;
    private LocalDate opened;
    private LocalDate closed;
    @OneToOne
    @JoinColumn(name = "user_id")
    private WebUserEntity user;
    @OneToMany(mappedBy = "account")
    private List<PaymentDetailsEntity> paymentDetails = new ArrayList<PaymentDetailsEntity>();
    @OneToMany(mappedBy = "account")
    private List<OrderEntity> orders = new ArrayList<OrderEntity>();

    public AccountEntity() {
    }

    public AccountEntity(String name, boolean isClosed, LocalDate opened, LocalDate closed, WebUserEntity user, List<PaymentDetailsEntity> paymentDetails, List<OrderEntity> orders) {
        this.name = name;
        this.isClosed = isClosed;
        this.opened = opened;
        this.closed = closed;
        this.user = user;
        this.paymentDetails = paymentDetails;
        this.orders = orders;
    }

    public AccountEntity(Integer id, String name, boolean isClosed, LocalDate opened, LocalDate closed, WebUserEntity user, List<PaymentDetailsEntity> paymentDetails, List<OrderEntity> orders) {
        this.id = id;
        this.name = name;
        this.isClosed = isClosed;
        this.opened = opened;
        this.closed = closed;
        this.user = user;
        this.paymentDetails = paymentDetails;
        this.orders = orders;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public UserEntity getUser() {
        return user;
    }

    public List<PaymentDetailsEntity> getPaymentDetails() {
        return paymentDetails;
    }

    public void setPaymentDetails(List<PaymentDetailsEntity> paymentDetails) {
        this.paymentDetails = paymentDetails;
    }

    public List<OrderEntity> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderEntity> orders) {
        this.orders = orders;
    }

    public void setUser(WebUserEntity user) {
        this.user = user;
    }
}
