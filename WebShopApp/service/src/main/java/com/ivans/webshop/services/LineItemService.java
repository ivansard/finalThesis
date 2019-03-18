package com.ivans.webshop.services;

import com.ivans.webshop.repository.entity.LineItemEntity;
import com.ivans.webshop.repository.repo.LineItemRepo;
import com.ivans.webshop.service.interfaces.ILineItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LineItemService implements ILineItemService {

    @Autowired
    private LineItemRepo lineItemRepo;

    @Override
    public List<LineItemEntity> getLineItemsByOrderId(Integer orderId) {
        List<LineItemEntity> lineItems = lineItemRepo.findByOrderId(orderId);
        return lineItems;
    }

    @Override
    public List<LineItemEntity> getLineItemsByProductId(Integer productId) {
        List<LineItemEntity> lineItems = lineItemRepo.findByProductId(productId);
        return lineItems;
    }

    @Override
    public List<LineItemEntity> getLineItemsByProductName(String productName) {
        List<LineItemEntity> lineItems = lineItemRepo.findByProductName(productName);
        return lineItems;
    }

    @Override
    public LineItemEntity getLineItemById(Integer id) throws Exception {
        LineItemEntity lineItem = lineItemRepo.findById(id).orElse(null);
        if (lineItem.equals(null)) {
            throw new Exception("Line item with submitted ID does not exist");
        }
        return lineItem;
    }

    @Override
    public LineItemEntity updateLineItem(LineItemEntity lineItem, Integer id) throws Exception {
        LineItemEntity lineItemInDb = lineItemRepo.findById(id).orElse(null);
        if (lineItemInDb.equals(null)) {
            throw new Exception("Line item with submitted ID does not exist");
        }
        lineItem.setId(lineItemInDb.getId());
        return lineItemRepo.save(lineItem);
    }


    @Override
    public void deleteLineItem(Integer id) throws Exception{
        LineItemEntity lineItemInDb = lineItemRepo.findById(id).orElse(null);
        if (lineItemInDb.equals(null)) {
            throw new Exception("Line item with submitted ID does not exist");
        }
        lineItemRepo.deleteById(id);
        return;
    }
}
