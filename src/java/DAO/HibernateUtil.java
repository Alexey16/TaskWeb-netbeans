/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import org.hibernate.Session;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;




/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author Алексей
 */
public class HibernateUtil {
    private static final SessionFactory sessionFactory;
    private static Session session;
    
    static {
        sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        session = sessionFactory.openSession();
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    public static Session getSession() {
        if(session == null)
            session = sessionFactory.openSession();
        
        return session;
    }
    
    public static void closeSession() {
        session.close();
        session = null;
    }
    
}
