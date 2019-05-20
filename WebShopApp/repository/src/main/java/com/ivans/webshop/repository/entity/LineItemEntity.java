package com.ivans.webshop.repository.entity;

import javax.persistence.*;

@Entity
@Table(name = "line_items")
public class LineItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private
    Integer id;
    private int quantity;
    private double totalPrice;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity product;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderEntity order;

    public LineItemEntity() {
    }

    public LineItemEntity(Integer id, int quantity, double totalPrice, ProductEntity product, OrderEntity order) {
        this.id = id;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.product = product;
        this.order = order;
    }

    public LineItemEntity(int quantity, double totalPrice, ProductEntity product, OrderEntity order) {
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.product = product;
        this.order = order;
    }

    public LineItemEntity(int quantity, double totalPrice, ProductEntity product) {
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.product = product;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public OrderEntity getOrder() {
        return order;
    }

    public void setOrder(OrderEntity order) {
        this.order = order;
    }
}
