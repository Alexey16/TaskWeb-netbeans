/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import Entity.Universes;
import org.hibernate.Session;

/**
 *
 * @author Алексей
 */
public class UniversesDAO {
    
    public UniversesDAO(){
    }
    
    public List<Universes> findAll(){
        return (List<Universes>) HibernateUtil.getSession().createQuery("SELECT u FROM Universes u").list();
    }
    
    public void save(Universes obj) {
        
         Session session = HibernateUtil.getSession();
         session.beginTransaction();
         session.saveOrUpdate(obj);
         session.getTransaction().commit();
         HibernateUtil.closeSession();
         
     }
     
     public void delete(Universes obj) {
         
         HibernateUtil.closeSession();
         Session session = HibernateUtil.getSession();
         session.beginTransaction();
         session.delete(obj);
         session.getTransaction().commit(); 
         
     }
     
     public Universes getById(int id) {
         Session session = HibernateUtil.getSession();
         Universes result = (Universes)session.get(Universes.class, id);
         
         return result;
     }
    
}
