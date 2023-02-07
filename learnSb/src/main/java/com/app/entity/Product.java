package com.app.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "products")
public class Product extends BaseEntity {
    @Column(name = "product_name", length = 30, unique = true)
    private String productName;
    private double price;
    private String description;
    @Column(name = "in_stock")
    private boolean inStock;
    // many to one Product *-----> 1Category
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category productCategory;

    @Override
    public String toString() {
        return "Product ID " + getId() + " [productName=" + productName + ", price=" + price + ", description="
                + description + ", inStock=" + inStock + "]";
    }
}
