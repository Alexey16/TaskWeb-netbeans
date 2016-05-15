/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
/**
 *
 * @author Алексей
 */
public class TaskManager {

    private static Toolkit toolkit = Toolkit.getDefaultToolkit();
    private static Timer timer = new Timer(false);

    public static void main(String[] args) throws IOException, ParseException {
        Journal journal = new SimpleJournal("journal.txt");
        Controller jc = new Controller(journal,timer);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        String sdate = "05.02.2016 7:53:00";
        Date date1 = dateFormat.parse(sdate);

        System.out.println(date1);
        Date date = new Date();
        date.setSeconds(date.getSeconds()+2);

        System.out.println(date);

        jc.addTask("information", date1);

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
