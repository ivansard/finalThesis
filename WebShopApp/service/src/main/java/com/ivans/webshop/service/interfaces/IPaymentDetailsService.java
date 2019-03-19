package com.ivans.webshop.service.interfaces;

import com.ivans.webshop.dto.PaymentDetailsDTO;
import com.ivans.webshop.repository.entity.PaymentDetailsEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IPaymentDetailsService {

    List<PaymentDetailsDTO> getAllPaymentDetails();

    List<PaymentDetailsDTO> getPaymentDetailsByAccountId(Integer accountId);

    PaymentDetailsDTO getPaymentDetailsById(Integer id) throws Exception;

    List<PaymentDetailsDTO> getPaymentDetailsByCardNumber(String cardNumber);

    PaymentDetailsEntity updatePaymentDetails(PaymentDetailsEntity paymentDetails, Integer paymentDetailsId) throws Exception;

    void deletePaymentDetails(Integer paymentDetailsId) throws Exception;
}
