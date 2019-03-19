package com.ivans.webshop.controllers;

import com.ivans.webshop.services.PaymentDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentDetailsController {

    @Autowired
    private PaymentDetailsService paymentDetailsService;
}
