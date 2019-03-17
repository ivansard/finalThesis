package com.ivans.webshop.controllers;

import com.ivans.webshop.services.LineItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LineItemController {

    @Autowired
    private LineItemService lineItemService;
}
