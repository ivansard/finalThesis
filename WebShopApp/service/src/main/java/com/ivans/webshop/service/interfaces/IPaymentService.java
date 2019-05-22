package com.ivans.webshop.service.interfaces;

import com.ivans.webshop.dto.PaymentDTO;
import com.ivans.webshop.repository.entity.PaymentEntity;
import com.ivans.webshop.services.PaymentDetailsService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public interface IPaymentService {


    List<PaymentDTO> getAllPayments();

    List<PaymentDTO> getPaymentsByPaymentDate(Date date);

    List<PaymentDTO> getPaymentsByPaymentDetailsCardNumber(String cardNumber);

    PaymentDTO getPaymentById(Integer paymentId) throws Exception;

//    PaymentDTO getByOrderId(Integer orderId) throws Exception;

    PaymentEntity updatePayment(PaymentEntity payment, Integer paymentId) throws Exception;

    void deletePayment(Integer paymentId) throws Exception;


}
