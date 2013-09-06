/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puntodeventa.services.DAO;

import com.puntodeventa.global.Util.TagHelper;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;

/**
 *
 * @author Nato Hdez
 */
public class ConnectedByHibernate {
    private Session session;    
    
    public Connection getConectionJDBC() {
        Connection con;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            con = session.connection();
            return con;
        } catch (Exception ex) {
            con = null;
            return con;
        }
    }
    
    public boolean getConectionByUser(String user, String password){
        try {
            String url = TagHelper.getTag("conn.url");
            Connection con = DriverManager.getConnection(url, user, password);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ConnectedByHibernate.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
