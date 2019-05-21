package com.ivans.webshop.util;

import com.ivans.webshop.dto.LineItemDTO;
import com.ivans.webshop.repository.entity.LineItemEntity;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private List<LineItemEntity> lineItems = new ArrayList<>();

    public ShoppingCart() {
    }

    public List<LineItemEntity> getLineItems() {
        return lineItems;
    }

    public void setLineItems(List<LineItemEntity> lineItems) {
        this.lineItems = lineItems;
    }
}
