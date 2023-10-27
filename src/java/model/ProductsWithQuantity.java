/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author iceza
 */
public class ProductsWithQuantity extends Products {
    private int quantity;
    private int productTotalPrice;
    
    public ProductsWithQuantity(Products product, int quantity, int productTotalPrice) {
        super(product.getId(), product.getMovie(), product.getRating(), product.getYearcreate(), product.getPrice());
        this.quantity = quantity;
        this.productTotalPrice = productTotalPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getProductTotalPrice() {
        return productTotalPrice;
    }

    public void setProductTotalPrice(int productTotalPrice) {
        this.productTotalPrice = productTotalPrice;
    }
     
    
    
}
