/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import java.util.HashMap;
import model.CartTable;
import model.Cashier;
import model.ProductsWithQuantity;
import model.ProductTable;
import model.Products;

/**
 *
 * @author iceza
 */
public class CentralController {
    private static HashMap<String, CentralController> controllerList = new HashMap<String, CentralController>();
    private List<ProductsWithQuantity> products;
    private int sumPrice;
    
    private CentralController() {
        sumPrice = 0;
    }
    
    public static CentralController getController(String sessionId){
        if(!controllerList.containsKey(sessionId)){
            controllerList.put(sessionId, new CentralController());
        }
        
        return controllerList.get(sessionId);
    }
    
    public void getCartData(String[] movies, String[] quantitys){
        products = ProductTable.findProductsByNameAsList(movies, quantitys);
        sumPrice = calculateSumPrice(products);
    }
    
    public List<ProductsWithQuantity> getProducts(){
        return products;
    }
    
    public int getSumPrice() {
        return sumPrice;
    }
    
    private int calculateSumPrice(List<ProductsWithQuantity> products) {
        return Cashier.calculatePriceAllProduct(products);
    }
    
    public void saveCart() {
        CartTable.insertCart(products);
    }
    
    public static List<Products> getAllProducts() {
        return ProductTable.findAllProducts();
    }
    
}
