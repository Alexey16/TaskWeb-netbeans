/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java;

import java.awt.Toolkit;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Алексей
 */
public class TaskExecute  {
    
    private static Toolkit toolkit = Toolkit.getDefaultToolkit();
    private static Timer timer = new Timer(false); 
    
    Journal journal;
    Controller jc = new Controller(journal, timer);
    
    //SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");

    public TaskExecute(String description, Date leadtime) throws IOException, ParseException {
        this.journal = new SimpleJournal("journal.txt");
        jc.addTask(description, leadtime);
        
        timer.addListen(new TimerListener() {
                    @Override
                    public void timesRun(Task task) {
                        toolkit.beep();
                        System.out.print(task.getDescriptionTask());
                        JOptionPane.showMessageDialog(null, task.getDescriptionTask());
                    }
                });
    }
    
}
