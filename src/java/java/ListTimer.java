/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java;

/**
 *
 * @author Алексей
 */
public interface ListTimer {

    void addListen(TimerListener listener);

    void schedule(Task task);

    void removeTask(int id);
}
