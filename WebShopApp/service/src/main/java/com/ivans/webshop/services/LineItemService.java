package com.ivans.webshop.services;

import com.ivans.webshop.repository.repo.LineItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LineItemService {

    @Autowired
    private LineItemRepo lineItemRepo;
}
