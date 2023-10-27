/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author iceza
 */
public class ProductTable {

    public static List<Products> findAllProducts() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Project_ShoppingCartPU");
        EntityManager em = emf.createEntityManager();
        List<Products> products = null;
        products = (List<Products>) em.createNamedQuery("Products.findAll").getResultList(); 
        em.close();
        return products;
    }
    
    public static List<ProductsWithQuantity> findProductsByNameAsList(String[] names, String[] quantitys) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Project_ShoppingCartPU");
        EntityManager em = emf.createEntityManager();
        List<ProductsWithQuantity> products = new ArrayList<ProductsWithQuantity>();
        int count = 0;
        Cashier cashier = new Cashier();
//        try {
            for(int i = 0; i < names.length; i++) {
                Query query = em.createNamedQuery("Products.findByMovie");
                query.setParameter("movie", names[i]);
                List<Products> temp = (List<Products>) query.getResultList();
                if(!temp.isEmpty()){
                    while(quantitys[count].equals("")){
                        count++;
                    }
                    products.add(new ProductsWithQuantity(temp.get(0), Integer.parseInt(quantitys[count]), cashier.calculatePricePerProduct(Integer.parseInt(quantitys[count]), temp.get(0).getPrice())));
                    count++;
                }
            }
//        } catch (Exception e) {
//            throw new RuntimeException();
//        }
        em.close();
        return products;
    }

}
