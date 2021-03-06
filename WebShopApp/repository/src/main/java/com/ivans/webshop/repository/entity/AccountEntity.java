package com.ivans.webshop.repository.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
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
    @Temporal(TemporalType.DATE)
    private Date opened = new Date();
    @Temporal(TemporalType.DATE)
    private Date closed;
    @OneToOne
    @JoinColumn(name = "user_id")
    private WebUserEntity user;
    @OneToOne(mappedBy = "account")
    private PaymentDetailsEntity paymentDetails;
    @OneToMany(mappedBy = "account", fetch = FetchType.EAGER)
    private List<OrderEntity> orders = new ArrayList<OrderEntity>();

    public AccountEntity() {
    }

    public AccountEntity(Integer id) {
        this.id = id;
    }

    public AccountEntity(String name, boolean isClosed, Date opened, Date closed, WebUserEntity user, PaymentDetailsEntity paymentDetails) {
        this.name = name;
        this.isClosed = isClosed;
        this.opened = opened;
        this.closed = closed;
        this.user = user;
        this.paymentDetails = paymentDetails;
    }

    public AccountEntity(Integer id, String name, boolean isClosed, Date opened, Date closed, WebUserEntity user, PaymentDetailsEntity paymentDetails) {
        this.id = id;
        this.name = name;
        this.isClosed = isClosed;
        this.opened = opened;
        this.closed = closed;
        this.user = user;
        this.paymentDetails = paymentDetails;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Date getOpened() {
        return opened;
    }

    public void setOpened(Date opened) {
        this.opened = opened;
    }

    public Date getClosed() {
        return closed;
    }

    public void setClosed(Date closed) {
        this.closed = closed;
    }

    public UserEntity getUser() {
        return user;
    }

    public PaymentDetailsEntity getPaymentDetails() {
        return paymentDetails;
    }

    public void setPaymentDetails(PaymentDetailsEntity paymentDetails) {
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
