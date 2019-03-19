package com.ivans.webshop.service.interfaces;

import com.ivans.webshop.repository.entity.PaymentDetailsEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IPaymentDetailsService {

    List<PaymentDetailsEntity> getAllPaymentDetails();

    List<PaymentDetailsEntity> getPaymentDetailsByAccountId(Integer accountId);

    PaymentDetailsEntity getPaymentDetailsById(Integer id);

    PaymentDetailsEntity getPaymentDetailsByCardNumber(String cardNumber);

    PaymentDetailsEntity updatePaymentDetails(PaymentDetailsEntity paymentDetails, Integer paymentDetailsId);

    void deletePaymentDetails(Integer paymentDetailsId);
}
