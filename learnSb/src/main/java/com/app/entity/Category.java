package com.app.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity(name = "categories")
public class Category extends BaseEntity {

    @Column(name = "category_name", length = 30, unique = true)
    private String categoryName;
    @Column(length = 300)
    private String description;
    @OneToMany(mappedBy = "productCategory", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Product> products = new ArrayList<>();

    @Override
    public String toString() {
        return "Category ID " + getId() + " [categoryName=" + categoryName + ", description=" + description + "]";
    }

    //add a method(convenience/helper) to establish a bi dir asso. between entities
    public void addProduct(Product p) {
        //parent --> child
        products.add(p);
        //child --> parent
        p.setProductCategory(this);
    }

    //add a method(convenience/helper) to remove a bi dir asso. between entities
    public void removeProduct(Product p) {
        //parent ----X---> child
        products.remove(p);
        //child ----X----> parent
        p.setProductCategory(null);


    }
}
