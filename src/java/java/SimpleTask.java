/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java;

import java.util.Date;

/**
 *
 * @author Алексей
 */
public class SimpleTask implements Task {


    private int id;
    private String description;
    private Date date;


    public SimpleTask(int id, String description, Date date) {

        this.id = id;
        this.description = description;
        this.date = date;
    }

    public SimpleTask(Task task) {

        this.id = task.getId();
        this.description = task.getDescriptionTask();
        this.date = task.getDateTask();

    }

    @Override
    public void setDateTask(Date date) {
        this.date = date;
    }

    @Override
    public void setDescriptionTask(String descriprion) {
        this.description = descriprion;
    }

    @Override
    public Date getDateTask() {
        return (Date) date.clone();
    }

    @Override
    public String getDescriptionTask() {
        return description;
    }

    @Override
    public int getId() {
        return id;
    }
}
