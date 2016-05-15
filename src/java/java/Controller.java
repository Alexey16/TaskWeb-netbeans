/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java;

import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Алексей
 */
public class Controller implements Journalling {

    private int lastId = -1;
    private Journal journal;
    private Timer timer;
    private List<Task> tasks;

    @Override
    public void addTask( String description, Date date) {
        try {
            Task task = new SimpleTask(++lastId, description, date);
            int i = 0;
            for (i = 0; i < tasks.size(); i++) {
                if (tasks.get(i).getDateTask().after(date)) {
                    break;
                }
            }
            journal.insert(task, i);
            timer.schedule(task);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean deleteTask(Task task) {
        try {
            if (journal.delete(task.getId())) {
                timer.removeTask(task.getId());
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    Controller(Journal journal, Timer timer) {
        this.journal = journal;
        this.tasks = journal.getTasksView();
        this.timer = timer;
        Date currentTime = new Date();
        for (Task task : tasks) {
            if (lastId < task.getId()) {
                lastId = task.getId();
            }
            if (currentTime.before(task.getDateTask())) {
                timer.schedule(task);
            }
        }
    }
}
