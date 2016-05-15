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
public interface Task {

    void setDateTask(Date date);

    void setDescriptionTask(String descriprion);

    Date getDateTask();

    String getDescriptionTask();

    int getId();

}
