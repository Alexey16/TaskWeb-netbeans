/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Taskmanager;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import java.TaskExecute;
import java.io.IOException;
import java.text.ParseException;

/**
 *
 * @author Алексей
 */
public class TaskmanagerDAO {
    
    TaskExecute te;
    
     public TaskmanagerDAO(){
    }
    
    public List<Taskmanager> findAll() {
        Query query = HibernateUtil.getSession().createQuery("SELECT t FROM Taskmanager t");
        List<Taskmanager> result = (List<Taskmanager>) query.list();
        return result;
    }
    
     public List<Taskmanager> findTaskByName(String name){
        String qS = "SELECT t FROM Taskmanager t WHERE t.nametask = :taskName";
        Query query = HibernateUtil.getSession().createQuery(qS);
        query.setParameter("taskName", name);
        List<Taskmanager> result = (List<Taskmanager>) query.list();
        return result;
    }
    
    public List<Taskmanager> findTaskByDescription(String name){
        String qS = "SELECT t FROM Taskmanager t WHERE t.description = :taskDesc";
        Query query = HibernateUtil.getSession().createQuery(qS);
        query.setParameter("taskDesc", name);
        List<Taskmanager> result = (List<Taskmanager>) query.list();
        return result;
    }
    
    
    public List<Taskmanager> findTaskByDate(String name){
        String qS = "SELECT t FROM Taskmanager t WHERE t.lideTime = :taskTime";
        Query query = HibernateUtil.getSession().createQuery(qS);
        query.setParameter("taskTime", name);
        List<Taskmanager> result = (List<Taskmanager>) query.list();
        return result;
    }
    
    public void save(Taskmanager tm, String description, Date date) throws IOException, ParseException{
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.saveOrUpdate(tm);
        session.getTransaction().commit(); 
        HibernateUtil.closeSession();
        te = new TaskExecute(description,date);
    }
    
    public void delete(Taskmanager obj) {
        HibernateUtil.closeSession();
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.delete(obj);
        session.getTransaction().commit(); 
     }
    
    public Taskmanager getById(int id) {
         Session session = HibernateUtil.getSession();
         Taskmanager result = (Taskmanager)session.get(Taskmanager.class, id);
         
         return result;
     }
    
}
