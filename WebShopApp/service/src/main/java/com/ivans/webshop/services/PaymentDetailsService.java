package com.ivans.webshop.services;

import com.ivans.webshop.dto.PaymentDetailsDTO;
import com.ivans.webshop.mappers.PaymentDetailsMapper;
import com.ivans.webshop.repository.entity.PaymentDetailsEntity;
import com.ivans.webshop.repository.repo.PaymentDetailsRepo;
import com.ivans.webshop.service.interfaces.IPaymentDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PaymentDetailsService implements IPaymentDetailsService {

    @Autowired
    private PaymentDetailsRepo paymentDetailsRepo;
    @Autowired
    private PaymentDetailsMapper paymentDetailsMapper;

    public List<PaymentDetailsEntity> findAllByAccountName(String accountName){
        return paymentDetailsRepo.findAllByAccountName(accountName);
    }

    public List<PaymentDetailsEntity> findAllByCardNumber(String cardNumber){
        return paymentDetailsRepo.findAllByCardNumber(cardNumber);
    }

    public List<PaymentDetailsEntity> findAllPaymentDetails(){
        return paymentDetailsRepo.findAll();
    }


    public PaymentDetailsEntity updatePaymentDetails(PaymentDetailsEntity paymentDetails, Integer paymentDetailsId) throws Exception{
        PaymentDetailsEntity detailsInDb = paymentDetailsRepo.findById(paymentDetailsId).orElse(null);
        if (detailsInDb.equals(null)) {
            throw new Exception("Product with submitted ID does not exist");
        }
        paymentDetails.setId(detailsInDb.getId());
        return paymentDetailsRepo.save(paymentDetails);
    }

    @Override
    public PaymentDetailsEntity addPaymentDetails(PaymentDetailsEntity paymentDetails) {
        return paymentDetailsRepo.save(paymentDetails);
    }

    public void deletePaymentDetails(Integer paymentDetailsId) throws Exception {
        PaymentDetailsEntity productInDb = paymentDetailsRepo.findById(paymentDetailsId).orElse(null);
        if (productInDb.equals(null)) {
            throw new Exception("Product with submitted ID does not exist");
        }
        paymentDetailsRepo.deleteById(paymentDetailsId);
        return;
    }

    @Override
    public List<PaymentDetailsDTO> getAllPaymentDetails() {
        List<PaymentDetailsEntity> paymentDetailsEntities = paymentDetailsRepo.findAll();
        List<PaymentDetailsDTO> paymentDetailsDTOs = new ArrayList<PaymentDetailsDTO>();
        for (PaymentDetailsEntity paymentDetailsEntity: paymentDetailsEntities) {
            paymentDetailsDTOs.add(paymentDetailsMapper.paymentDetails2DTO(paymentDetailsEntity));
        }
        return paymentDetailsDTOs;
    }

    @Override
    public List<PaymentDetailsDTO> getPaymentDetailsByAccountId(Integer accountId) {
        List<PaymentDetailsEntity> paymentDetailsEntities = paymentDetailsRepo.findAllByAccountId(accountId);
        List<PaymentDetailsDTO> paymentDetailsDTOs = new ArrayList<PaymentDetailsDTO>();
        for (PaymentDetailsEntity paymentDetailsEntity: paymentDetailsEntities) {
            paymentDetailsDTOs.add(paymentDetailsMapper.paymentDetails2DTO(paymentDetailsEntity));
        }
        return paymentDetailsDTOs;
    }

    @Override
    public List<PaymentDetailsDTO> getPaymentDetailsByCardNumber(String cardNumber) {
        List<PaymentDetailsEntity> paymentDetailsEntities = paymentDetailsRepo.findAllByCardNumber(cardNumber);
        List<PaymentDetailsDTO> paymentDetailsDTOs = new ArrayList<PaymentDetailsDTO>();
        for (PaymentDetailsEntity paymentDetailsEntity: paymentDetailsEntities) {
            paymentDetailsDTOs.add(paymentDetailsMapper.paymentDetails2DTO(paymentDetailsEntity));
        }
        return paymentDetailsDTOs;
    }

    public PaymentDetailsDTO getPaymentDetailsById(Integer paymentDetailsId) throws Exception {
        PaymentDetailsEntity paymentDetails = paymentDetailsRepo.findById(paymentDetailsId).orElse(null);
        if(paymentDetails.equals(null)){
            throw new Exception("Product with submitted ID does not exist");
        }
        return paymentDetailsMapper.paymentDetails2DTO(paymentDetails);
    }
}
