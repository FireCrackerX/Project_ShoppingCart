/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author iceza
 */
public class CartTable {
    public static void insertCart(List<ProductsWithQuantity> products) {
        int lastCartId = getLastCartId()+1 ;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Project_ShoppingCartPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            for(int i = 0; i < products.size(); i++) {
                Shoppingcart cart = new Shoppingcart(lastCartId, products.get(i).getId(), products.get(i).getQuantity());
                em.persist(cart);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    
    private static int getLastCartId() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Project_ShoppingCartPU");
        EntityManager em = emf.createEntityManager();
        List<Shoppingcart> cartList = (List<Shoppingcart>) em.createNamedQuery("Shoppingcart.findAll").getResultList();
        int maxId = 0;
        for(int i = cartList.size()-1 ; i >= 0; i--) {
            if(cartList.get(i).getShoppingcartPK().getCartId() > maxId){
                maxId = cartList.get(i).getShoppingcartPK().getCartId();
            }
        }
        em.close();
        return maxId;
    }
}
