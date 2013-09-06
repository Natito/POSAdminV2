/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puntodeventa.mvc.Controller;

import com.puntodeventa.global.Entity.Product;
import com.puntodeventa.services.DAO.ProductDAO;

/**
 *
 * @author Nato
 */
public class ProductLogic {
    static ProductDAO productDAO = new ProductDAO();
    
    public Product getProduct(String id_product){
        Product product = null;
        product = productDAO.selectProduct(id_product);
        return product;
    }
}
