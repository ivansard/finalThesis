package com.ivans.webshop.services;

import com.ivans.webshop.repository.repo.PaymentDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentDetailsService {

    @Autowired
    private PaymentDetailsRepo paymentDetailsRepo;
}
