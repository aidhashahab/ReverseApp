/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.warda.test;

import com.warda.model.Customer;
import com.warda.model.Product;
import com.warda.model.PurchaseOrder;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author user
 */
public class TestReverse {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ReverseApplicationPU");
        EntityManager em = emf.createEntityManager();

//        Query query = em.createNamedQuery("Customer.findAll");
//        List<Customer> cutomers = query.getResultList();
//        for (Customer c : cutomers) {
//            System.out.println(c.getName() + " di " + c.getCity());
//            for (PurchaseOrder po : c.getPurchaseOrderList()) {
//                System.out.println("PO: "+po.getSalesDate()+" : "+po.getProductId().getDescription());
//                
//            }
//        } siapa saja yg beli identity server
        
        Query query = em.createNamedQuery("Product.findByDescription");
        query.setParameter("description", "Identity Server");
        Product p=(Product) query.getSingleResult();
        List<PurchaseOrder> pos = p.getPurchaseOrderList();
        System.out.println("Customer yg beli : " +p.getDescription());
            for (PurchaseOrder po1 : pos) {
                System.out.println(po1.getCustomerId().getName());
                
            }
        
            
        

        //untuk mncari yg tinggal di new york
//        Query secondQuery = em.createNamedQuery("Customer.findByCity");
//        secondQuery.setParameter("city", "New York");

        em.close();
        emf.close();

        // TODO code application logic here
    }

}
