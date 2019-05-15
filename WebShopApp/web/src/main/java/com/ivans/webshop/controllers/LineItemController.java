package com.ivans.webshop.controllers;

import com.ivans.webshop.dto.LineItemDTO;
import com.ivans.webshop.repository.entity.LineItemEntity;
import com.ivans.webshop.services.LineItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class LineItemController {

    @Autowired
    private LineItemService lineItemService;

    @GetMapping(value = "/lineItems/order/{id}")
    public List<LineItemDTO> getLineItemsByOrderId(@PathVariable("id") Integer id) {
        return lineItemService.getLineItemsByOrderId(id);
    }

    @GetMapping(value = "/lineItems/product/{id}")
    public List<LineItemDTO> getLineItemsByProductId(@PathVariable("id") Integer id) {
        return lineItemService.getLineItemsByProductId(id);
    }

    @GetMapping(value = "/lineItems/product/name/{productName}")
    public List<LineItemDTO> getLineItemsByProductName(@PathVariable("productName") String productName) {
        return lineItemService.getLineItemsByProductName(productName);
    }

    @GetMapping(value = "/lineItems/{id}")
    public LineItemDTO getLineItemById(@PathVariable("id") Integer id) {
        try {
            return lineItemService.getLineItemById(id);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Line item with submitted ID does not exist", ex);
        }
    }

    @PutMapping(value = "/lineItems/{id}")
    public LineItemEntity updateLineItem(@PathVariable("id") Integer id, @RequestBody LineItemEntity lineItem) {
        try {
            return lineItemService.updateLineItem(lineItem, id);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Line item with submitted ID does not exist", ex);
        }
    }

    @DeleteMapping(value = "/lineItems/{id}")
    public void deleteLineItem(@PathVariable("id") Integer id) {
        try {
            lineItemService.deleteLineItem(id);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Line item with submitted ID does not exist", ex);
        }
    }
}
