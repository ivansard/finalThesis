package com.ivans.webshop.repository.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "payments")
public class PaymentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Temporal(TemporalType.DATE)
    private Date paidDate;
    private double total;
    private String details;
//    @OneToOne(mappedBy = "payment")
//    private OrderEntity order;
    @ManyToOne
    @JoinColumn(name = "payment_details_id")
    private PaymentDetailsEntity paymentDetails;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getPaidDate() {
        return paidDate;
    }

    public void setPaidDate(Date paidDate) {
        this.paidDate = paidDate;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

//    public OrderEntity getOrder() {
//        return order;
//    }
//
//    public void setOrder(OrderEntity order) {
//        this.order = order;
//    }

    public PaymentDetailsEntity getPaymentDetails() {
        return paymentDetails;
    }

    public void setPaymentDetails(PaymentDetailsEntity paymentDetails) {
        this.paymentDetails = paymentDetails;
    }
}
