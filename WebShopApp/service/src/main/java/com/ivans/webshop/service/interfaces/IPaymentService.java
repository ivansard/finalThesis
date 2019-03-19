package com.ivans.webshop.service.interfaces;

import com.ivans.webshop.repository.entity.PaymentEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public interface IPaymentService {


    List<PaymentEntity> getAllPayments();

    List<PaymentEntity> getPaymentsByPaymentDate(LocalDate date);

    List<PaymentEntity> getPaymentsByPaymentDetailsCardNumber(String cardNumber);

    PaymentEntity getPaymentById(Integer paymentId);

    PaymentEntity findByOrderId(Integer orderId);

    PaymentEntity updatePayment(PaymentEntity payment, Integer paymentId);

    void deletePayment(Integer paymentId);


}
