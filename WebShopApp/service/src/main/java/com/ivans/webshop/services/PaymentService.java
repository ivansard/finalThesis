package com.ivans.webshop.services;

import com.ivans.webshop.repository.entity.PaymentEntity;
import com.ivans.webshop.repository.repo.PaymentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepo paymentRepo;

    public List<PaymentEntity> getEntitiesByPaymentDate(Date paymentDate){
        return paymentRepo.findAllByPaidDate(paymentDate);
    }

    public List<PaymentEntity> getAllByPaymentDateBetween(Date startDate, Date endDate){
        return paymentRepo.findAllByPaidDateBetween(startDate, endDate);
    }

    public List<PaymentEntity> getAllPayments(){
        return paymentRepo.findAll();
    }

    public PaymentEntity getPaymentById(Integer paymentId) throws Exception{
        PaymentEntity payment = paymentRepo.findById(paymentId).orElse(null);
        if(payment.equals(null)){
            throw new Exception("Payment with submitted ID does not exist");
        }
        return payment;
    }

    public PaymentEntity getPaymentByOrderId(Integer orderId) throws Exception{
        PaymentEntity payment = paymentRepo.findByOrderId(orderId);
        if(payment.equals(null)){
            throw new Exception("Payment with for submitted order does not exist");
        }
        return payment;
    }

    public PaymentEntity updatePayment(PaymentEntity payment, Integer paymentId) throws Exception {
        PaymentEntity paymentInDb = paymentRepo.findById(paymentId).orElse(null);
        if (paymentInDb.equals(null)) {
            throw new Exception("Payment with submitted ID does not exist");
        }
        payment.setId(paymentInDb.getId());
        return paymentRepo.save(payment);
    }

    public void deletePayment(Integer paymentId) throws Exception {
        PaymentEntity paymentInDb = paymentRepo.findById(paymentId).orElse(null);
        if (paymentInDb.equals(null)) {
            throw new Exception("Payment with submitted ID does not exist");
        }
        paymentRepo.deleteById(paymentId);
        return;
    }

}
