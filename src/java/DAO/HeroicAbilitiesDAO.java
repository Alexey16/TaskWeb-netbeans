/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import Entity.HeroicAbilities;
import org.hibernate.Session;

/**
 *
 * @author Алексей
 */
public class HeroicAbilitiesDAO {
    
    public HeroicAbilitiesDAO(){
    }
    
    public List<HeroicAbilities> findAll() {
        return (List<HeroicAbilities>)HibernateUtil.getSession().createQuery("SELECT ha FROM HeroicAbilities ha").list();
    }
    
    public void save(HeroicAbilities obj) {
        
         Session session = HibernateUtil.getSession();
         session.beginTransaction();
         session.saveOrUpdate(obj);
         session.getTransaction().commit();
         HibernateUtil.closeSession();
         
     }
     
     public void delete(HeroicAbilities obj) {
         
         HibernateUtil.closeSession();
         Session session = HibernateUtil.getSession();
         session.beginTransaction();
         session.close();
         session.delete(obj);
         session.getTransaction().commit(); 
         
     }
     
     public HeroicAbilities getById(int id) {
         Session session = HibernateUtil.getSession();
         HeroicAbilities result = (HeroicAbilities)session.get(HeroicAbilities.class, id);
         
         return result;
     }
    
}
