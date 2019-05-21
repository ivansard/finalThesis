package com.ivans.webshop.services;

import com.ivans.webshop.dto.LineItemDTO;
import com.ivans.webshop.mappers.LineItemMapper;
import com.ivans.webshop.repository.entity.LineItemEntity;
import com.ivans.webshop.repository.repo.LineItemRepo;
import com.ivans.webshop.service.interfaces.ILineItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LineItemService implements ILineItemService {

    @Autowired
    private LineItemRepo lineItemRepo;
    @Autowired
    private LineItemMapper lineItemMapper;

    @Override
    public List<LineItemDTO> getLineItemsByOrderId(Integer orderId) {
        List<LineItemEntity> lineItemEntities = lineItemRepo.findByOrderId(orderId);
        List<LineItemDTO> lineItemDtos = new ArrayList<LineItemDTO>();
        for (LineItemEntity lineItemEntity: lineItemEntities) {
            lineItemDtos.add(lineItemMapper.lineItem2DTO(lineItemEntity));
        }
        return lineItemDtos;
    }

    @Override
    public List<LineItemDTO> getLineItemsByProductId(Integer productId) {
        List<LineItemEntity> lineItemEntities = lineItemRepo.findByProductId(productId);
        List<LineItemDTO> lineItemDtos = new ArrayList<LineItemDTO>();
        for (LineItemEntity lineItemEntity: lineItemEntities) {
            lineItemDtos.add(lineItemMapper.lineItem2DTO(lineItemEntity));
        }
        return lineItemDtos;
    }

    @Override
    public List<LineItemDTO> getLineItemsByProductName(String productName) {
        List<LineItemEntity> lineItemEntities = lineItemRepo.findByProductName(productName);
        List<LineItemDTO> lineItemDtos = new ArrayList<LineItemDTO>();
        for (LineItemEntity lineItemEntity: lineItemEntities) {
            lineItemDtos.add(lineItemMapper.lineItem2DTO(lineItemEntity));
        }
        return lineItemDtos;
    }

    @Override
    public LineItemDTO getLineItemById(Integer id) throws Exception {
        LineItemEntity lineItem = lineItemRepo.findById(id).orElse(null);
        if (lineItem.equals(null)) {
            throw new Exception("Line item with submitted ID does not exist");
        }
        return lineItemMapper.lineItem2DTO(lineItem);
    }

    @Override
    public LineItemEntity addLineItem(LineItemEntity lineItem) {
        return lineItemRepo.save(lineItem);
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
