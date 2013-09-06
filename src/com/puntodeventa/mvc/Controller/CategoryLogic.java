/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puntodeventa.mvc.Controller;

import com.puntodeventa.mvc.Model.Category;
import com.puntodeventa.services.DAO.CategoryDAO;
import java.util.List;


/**
 *
 * @author Nato
 */
public class CategoryLogic {
    static CategoryDAO categoryDAO = new CategoryDAO();
    
    public List getCategory(){
        List<Category> listCategory;
        listCategory = categoryDAO.listCategory();
        return listCategory;
    }
    
    public Category categoryId(String categoryId){
        Category category;
        category = categoryDAO.selectCategory(categoryId);
        return category;
    }
    
}
