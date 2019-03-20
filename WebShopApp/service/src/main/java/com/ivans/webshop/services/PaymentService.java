package com.ivans.webshop.services;

import com.ivans.webshop.dto.PaymentDTO;
import com.ivans.webshop.mappers.PaymentMapper;
import com.ivans.webshop.repository.entity.PaymentEntity;
import com.ivans.webshop.repository.repo.PaymentRepo;
import com.ivans.webshop.service.interfaces.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PaymentService implements IPaymentService {

    @Autowired
    private PaymentRepo paymentRepo;
    @Autowired
    private PaymentMapper paymentMapper;


    public List<PaymentDTO> getAllByPaymentDateBetween(Date startDate, Date endDate){
        List<PaymentEntity> paymentEntities = paymentRepo.findAllByPaidDateBetween(startDate, endDate);
        List<PaymentDTO> paymentDTOs = new ArrayList<>();
        for (PaymentEntity paymentEntity: paymentEntities) {
            paymentDTOs.add(paymentMapper.payment2DTO(paymentEntity));
        }
        return paymentDTOs;
    }

    public List<PaymentDTO> getAllPayments(){
        List<PaymentEntity> paymentEntities = paymentRepo.findAll();
        List<PaymentDTO> paymentDTOs = new ArrayList<>();
        for (PaymentEntity paymentEntity: paymentEntities) {
            paymentDTOs.add(paymentMapper.payment2DTO(paymentEntity));
        }
        return paymentDTOs;
    }

    @Override
    public List<PaymentDTO> getPaymentsByPaymentDate(Date paymentDate) {
        List<PaymentEntity> paymentEntities = paymentRepo.findAllByPaidDate(paymentDate);
        List<PaymentDTO> paymentDTOs = new ArrayList<>();
        for (PaymentEntity paymentEntity: paymentEntities) {
            paymentDTOs.add(paymentMapper.payment2DTO(paymentEntity));
        }
        return paymentDTOs;
    }

    @Override
    public List<PaymentDTO> getPaymentsByPaymentDetailsCardNumber(String cardNumber) {
        List<PaymentEntity> paymentEntities = paymentRepo.findByPaymentDetailsCardNumber(cardNumber);
        List<PaymentDTO> paymentDTOs = new ArrayList<>();
        for (PaymentEntity paymentEntity: paymentEntities) {
            paymentDTOs.add(paymentMapper.payment2DTO(paymentEntity));
        }
        return paymentDTOs;
    }

    public PaymentDTO getPaymentById(Integer paymentId) throws Exception{
        PaymentEntity payment = paymentRepo.findById(paymentId).orElse(null);
        if(payment.equals(null)){
            throw new Exception("Payment with submitted ID does not exist");
        }
        return paymentMapper.payment2DTO(payment);
    }

    @Override
    public PaymentDTO getByOrderId(Integer orderId) throws Exception {
        PaymentEntity payment = paymentRepo.findByOrderId(orderId);
        if(payment.equals(null)){
            throw new Exception("Payment with submitted ID does not exist");
        }
        return paymentMapper.payment2DTO(payment);
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
