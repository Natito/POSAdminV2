package com.puntodeventa.services.DAO;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author Fortunato Hernandez
 */
public class HibernateUtil {

    private static SessionFactory sessionFactory = null;
    private static final String pathProperties = System.getProperty("user.dir") + "/src/";

    static {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream(pathProperties + "config_db.properties"));
            sessionFactory = new AnnotationConfiguration().configure()
                    .addProperties(properties).buildSessionFactory();
        } catch (HibernateException he) {
            System.err.println("Initial SessionFactory creation failed:" + he);
            throw new ExceptionInInitializerError(he);
        } catch (IOException ex) {
            System.err.println("Add File Properties failed: " + ex);
        }
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }        
}
