/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puntodeventa.mvc.Model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Nato
 */
@Entity
@Table(name="vt.Category")
public class Category implements Serializable{
    @Id
    @Column(name="Id_category")
    private String id_category;
    @Column(name="Category")
    private String category;

    public Category() {
    }

    public Category(String id_category, String category) {
        this.id_category = id_category;
        this.category = category;
    }

    /**
     * @return the id_category
     */
    public String getId_category() {
        return id_category;
    }

    /**
     * @param id_category the id_category to set
     */
    public void setId_category(String id_category) {
        this.id_category = id_category;
    }

    /**
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(String category) {
        this.category = category;
    }
}
