package com.ivans.webshop.repository.entity;

import com.ivans.webshop.repository.enums.ProductCategory;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "products")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String imageUrl;
    private double price;
    private double tax;
    private double discount;
    @Enumerated(EnumType.STRING)
    @Column(length = 15 )
    private
    ProductCategory category;
    @ManyToOne
    @JoinColumn(name = "company_id") private
    CompanyEntity company;
    @OneToMany(mappedBy = "product") private
    List<LineItemEntity> lineItems = new ArrayList<LineItemEntity>();

    public ProductEntity() {
    }

    public ProductEntity(Integer id, String name, String imageUrl, double price, double tax, double discount, ProductCategory category, CompanyEntity company) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
        this.price = price;
        this.tax = tax;
        this.discount = discount;
        this.category = category;
        this.company = company;
    }

    public ProductEntity(String name, String imageUrl, double price, double tax, double discount, ProductCategory category, CompanyEntity company) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.price = price;
        this.tax = tax;
        this.discount = discount;
        this.category = category;
        this.company = company;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    public CompanyEntity getCompany() {
        return company;
    }

    public void setCompany(CompanyEntity company) {
        this.company = company;
    }

    public List<LineItemEntity> getLineItems() {
        return lineItems;
    }

    public void setLineItems(List<LineItemEntity> lineItems) {
        this.lineItems = lineItems;
    }
}
