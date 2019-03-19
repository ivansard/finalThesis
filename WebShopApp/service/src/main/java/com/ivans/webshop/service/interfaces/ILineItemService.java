package com.ivans.webshop.service.interfaces;

import com.ivans.webshop.dto.LineItemDTO;
import com.ivans.webshop.repository.entity.LineItemEntity;

import java.util.List;

public interface ILineItemService {

    List<LineItemDTO> getLineItemsByOrderId(Integer orderId);

    List<LineItemDTO> getLineItemsByProductId(Integer productId);

    List<LineItemDTO> getLineItemsByProductName(String productName);

    LineItemDTO getLineItemById(Integer id) throws Exception;

    LineItemEntity updateLineItem(LineItemEntity lineItem, Integer id) throws Exception;

    void deleteLineItem(Integer id) throws Exception;
}
