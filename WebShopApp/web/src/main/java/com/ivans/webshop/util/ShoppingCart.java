package com.ivans.webshop.util;

import com.ivans.webshop.dto.LineItemDTO;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private List<LineItemDTO> lineItems = new ArrayList<>();

    public ShoppingCart() {
    }

    public List<LineItemDTO> getLineItems() {
        return lineItems;
    }

    public void setLineItems(List<LineItemDTO> lineItems) {
        this.lineItems = lineItems;
    }
}
