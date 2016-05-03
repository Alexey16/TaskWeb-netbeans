/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.Abilities;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;


/**
 *
 * @author Алексей
 */
public class AbilitiesDAO {
    
    public AbilitiesDAO(){
    }
    
    public List<Abilities> findAll() {
        Query query = HibernateUtil.getSession().createQuery("SELECT a FROM Abilities a");
        List<Abilities> result = (List<Abilities>) query.list();
        
        return result;
    }
    
    
    public void save(Abilities obj) {
        
         Session session = HibernateUtil.getSession();
         session.beginTransaction();
         session.saveOrUpdate(obj);
         session.getTransaction().commit();
         HibernateUtil.closeSession();
         
     }
     
     public void delete(Abilities obj) {         
         
         HibernateUtil.closeSession();
         Session session = HibernateUtil.getSession();
         session.beginTransaction();
         session.delete(obj);
         session.getTransaction().commit(); 
         
     }
     
     public Abilities getById(int id) {
         Session session = HibernateUtil.getSession();
         Abilities result = (Abilities)session.get(Abilities.class, id);
         
         return result;
     }
    
}
