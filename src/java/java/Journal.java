/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java;

import java.io.IOException;
import java.util.List;

/**
 *
 * @author Алексей
 */
public interface Journal {

    public void load() throws IOException;

    public void save() throws IOException;

    public void append(Task task) throws IOException;

    public void insert(Task task, int pos) throws IOException;

    public void insertAfter(Task task, int id) throws IOException;

    public boolean delete(int id) throws IOException;

    public List<Task> getTasksView();

}
