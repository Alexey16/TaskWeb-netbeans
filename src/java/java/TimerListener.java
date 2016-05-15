/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java;

import java.util.EventListener;

/**
 *
 * @author Алексей
 */
public interface TimerListener extends EventListener {
    void timesRun(Task task);
}
