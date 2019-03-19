package com.ivans.webshop.controllers;

import com.ivans.webshop.repository.entity.PaymentEntity;
import com.ivans.webshop.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.List;

@RestController
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping(value = "/payments/paymentDate/{paymentDate}")
    public List<PaymentEntity> getEntitiesByPaymentDate(@PathVariable Date paymentDate) {
        return paymentService.getEntitiesByPaymentDate(paymentDate);
    }

    @GetMapping(value = "/payments/paymentDate")
    public List<PaymentEntity> getAllByPaymentDateBetween(@RequestParam Date startDate, @RequestParam Date endDate) {
        return paymentService.getAllByPaymentDateBetween(startDate, endDate);
    }

    @GetMapping(value = "/payments")
    public List<PaymentEntity> getAllPayments() {
        return paymentService.getAllPayments();
    }

    @GetMapping(value = "/payments/{paymentId}")
    public PaymentEntity getPaymentById(@PathVariable Integer paymentId) {
        try {
            return paymentService.getPaymentById(paymentId);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Payment with submitted ID does not exist", ex);
        }
    }

    @GetMapping(value = "/payments/order/{orderId}")
    public PaymentEntity getPaymentByOrderId(@PathVariable Integer orderId) {
        try {
            return paymentService.getPaymentByOrderId(orderId);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Payment for submitted order does not exist", ex);
        }
    }

    @PostMapping(value = "/payments/{paymentId}")
    public PaymentEntity updatePayment(@RequestBody PaymentEntity payment, @PathVariable Integer paymentId) {
        try {
            return paymentService.updatePayment(payment, paymentId);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Payment with submitted ID does not exist", ex);
        }
    }

    public void deletePayment(Integer paymentId) {
        try {
            paymentService.deletePayment(paymentId);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Payment with submitted ID does not exist", ex);
        }
    }
}
