/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Алексей
 */
@Entity
@Table(name = "taskmanager")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Taskmanager.findAll", query = "SELECT t FROM Taskmanager t"),
    @NamedQuery(name = "Taskmanager.findByIdTask", query = "SELECT t FROM Taskmanager t WHERE t.idTask = :idTask"),
    @NamedQuery(name = "Taskmanager.findByName", query = "SELECT t FROM Taskmanager t WHERE t.name = :name"),
    @NamedQuery(name = "Taskmanager.findByDescription", query = "SELECT t FROM Taskmanager t WHERE t.description = :description"),
    @NamedQuery(name = "Taskmanager.findByLidetime", query = "SELECT t FROM Taskmanager t WHERE t.lidetime = :lidetime")})
public class Taskmanager implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_task")
    private Integer idTask;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "lidetime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lidetime;

    public Taskmanager() {
    }

    public Taskmanager(Integer idTask) {
        this.idTask = idTask;
    }

    public Taskmanager(Integer idTask, String name) {
        this.idTask = idTask;
        this.name = name;
    }

    public Integer getIdTask() {
        return idTask;
    }

    public void setIdTask(Integer idTask) {
        this.idTask = idTask;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getLidetime() {
        return lidetime;
    }

    public void setLidetime(Date lidetime) {
        this.lidetime = lidetime;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTask != null ? idTask.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Taskmanager)) {
            return false;
        }
        Taskmanager other = (Taskmanager) object;
        if ((this.idTask == null && other.idTask != null) || (this.idTask != null && !this.idTask.equals(other.idTask))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Taskmanager[ idTask=" + idTask + " ]";
    }
    
}
