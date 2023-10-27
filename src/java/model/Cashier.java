/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;

/**
 *
 * @author iceza
 */
public class Cashier {
    public static int calculatePriceAllProduct(List<ProductsWithQuantity> products) {
        int sumPrice = 0;
        
        for(int i = 0; i < products.size(); i++) {
            sumPrice += products.get(i).getProductTotalPrice();
        }
        
        return sumPrice;
    }
    
    public int calculatePricePerProduct(int quantity, int pricePerUnit) {
        return quantity * pricePerUnit;
    }
}
