package com.ivans.webshop.repository.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "payment_details")
public class PaymentDetailsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String cardNumber;
    @Temporal(TemporalType.DATE)
    private Date expirationDate;
    private String securityCode;
    @OneToMany(mappedBy = "paymentDetails")
    private List<PaymentEntity> payments = new ArrayList<PaymentEntity>();
    @ManyToOne
    @JoinColumn(name = "account_id")
    private AccountEntity account;

    public PaymentDetailsEntity() {
    }

    public PaymentDetailsEntity(String cardNumber, Date expirationDate, String securityCode, List<PaymentEntity> payments, AccountEntity account) {
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
        this.securityCode = securityCode;
        this.payments = payments;
        this.account = account;
    }

    public PaymentDetailsEntity(Integer id, String cardNumber, Date expirationDate, String securityCode, List<PaymentEntity> payments, AccountEntity account) {
        this.id = id;
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
        this.securityCode = securityCode;
        this.payments = payments;
        this.account = account;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public AccountEntity getAccount() {
        return account;
    }

    public void setAccount(AccountEntity account) {
        this.account = account;
    }

    public String getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(String securityCode) {
        this.securityCode = securityCode;
    }

    public List<PaymentEntity> getPayments() {
        return payments;
    }

    public void setPayments(List<PaymentEntity> payments) {
        this.payments = payments;
    }
}
