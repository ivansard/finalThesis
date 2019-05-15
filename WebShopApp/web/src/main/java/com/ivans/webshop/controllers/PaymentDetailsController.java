package com.ivans.webshop.controllers;

import com.ivans.webshop.dto.PaymentDetailsDTO;
import com.ivans.webshop.repository.entity.PaymentDetailsEntity;
import com.ivans.webshop.services.PaymentDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class PaymentDetailsController {

    @Autowired
    private PaymentDetailsService paymentDetailsService;

    @GetMapping(value = "/paymentDetails/account/{accountName}")
    public List<PaymentDetailsEntity> findAllByAccountName(@PathVariable String accountName) {
        return paymentDetailsService.findAllByAccountName(accountName);
    }

    @GetMapping(value = "/paymentDetails/cardNumber/{cardNumber}")
    public List<PaymentDetailsEntity> findAllByCardNumber(@PathVariable String cardNumber) {
        return paymentDetailsService.findAllByCardNumber(cardNumber);
    }

    @GetMapping(value = "/paymentDetails")
    public List<PaymentDetailsEntity> findAllPaymentDetails() {
        return paymentDetailsService.findAllPaymentDetails();
    }

    @GetMapping(value = "/paymentDetails/{paymentDetailsId}")
    public PaymentDetailsDTO getPaymentDetailsById(@PathVariable Integer paymentDetailsId) throws Exception {
        try {
            return paymentDetailsService.getPaymentDetailsById(paymentDetailsId);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Payment details with submitted ID do not exist", ex);
        }
    }

    @PutMapping(value = "/paymentDetails/{paymentDetailsId}")
    public PaymentDetailsEntity updatePaymentDetails(
            @RequestBody PaymentDetailsEntity paymentDetails,
            @PathVariable Integer paymentDetailsId) throws Exception {
        try {
            return paymentDetailsService.updatePaymentDetails(paymentDetails, paymentDetailsId);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Payment details with submitted ID do not exist", ex);
        }
    }

    @DeleteMapping(value = "/paymentDetails/{paymentDetailsId}")
    public void deletePaymentDetails(@PathVariable Integer paymentDetailsId) throws Exception {
        try {
            paymentDetailsService.deletePaymentDetails(paymentDetailsId);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Payment details with submitted ID do not exist", ex);
        }
    }
}
