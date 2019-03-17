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
    private double discount;
    private double price;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity product;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderEntity order;

    public LineItemEntity() {
    }

    public LineItemEntity(Integer id, int quantity, double discount, double price, ProductEntity product, OrderEntity order) {
        this.setId(id);
        this.setQuantity(quantity);
        this.setDiscount(discount);
        this.setPrice(price);
        this.setProduct(product);
        this.setOrder(order);
    }

    public LineItemEntity(int quantity, double discount, double price, ProductEntity product, OrderEntity order) {
        this.setQuantity(quantity);
        this.setDiscount(discount);
        this.setPrice(price);
        this.setProduct(product);
        this.setOrder(order);
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

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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
