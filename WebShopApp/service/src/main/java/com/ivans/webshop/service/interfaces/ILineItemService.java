package com.ivans.webshop.service.interfaces;

import com.ivans.webshop.repository.entity.LineItemEntity;

import java.util.List;

public interface ILineItemService {

    List<LineItemEntity> getLineItemsByOrderId(Integer orderId);

    List<LineItemEntity> getLineItemsByProductId(Integer productId);

    List<LineItemEntity> getLineItemsByProductName(String productName);

    LineItemEntity getLineItemById(Integer id) throws Exception;

    LineItemEntity updateLineItem(LineItemEntity lineItem, Integer id) throws Exception;

    void deleteLineItem(Integer id) throws Exception;
}
