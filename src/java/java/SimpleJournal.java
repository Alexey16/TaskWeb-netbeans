/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 *
 * @author Алексей
 */
public class SimpleJournal implements Journal {
    private File file;
    private static final String ID_MARK = "#ID:";
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yy HH:mm:ss");

    private LinkedList<Task> tasks;

    private ListIterator<Task> searchById(int id) {
        ListIterator<Task> listItr = tasks.listIterator();
        while (listItr.hasNext()) {
            if (listItr.next().getId() == id) {
                return listItr;
            }
        }
        return null;
    }

    @Override
    public void load() throws IOException {
        tasks = new LinkedList<Task>();
        int lineNumber = 0;
        try {
            Scanner scan = new Scanner(new BufferedReader(new FileReader(file)));
            if(!scan.hasNext()){
                scan.close();
                return;
            }
            lineNumber++;
            String str = scan.nextLine();
            while (scan.hasNext()) {
                //parse id
                str = str.replaceAll(ID_MARK, "");
                str = str.replaceAll("\\s", "");
                int id = Integer.parseInt(str);

                //parse date
                lineNumber++;
                Date date = dateFormat.parse(scan.nextLine());

                //parse description
                StringBuilder description = new StringBuilder();
                boolean isFirstDescriptionLine = true;
                while (scan.hasNext()) {
                    lineNumber++;
                    str = scan.nextLine();
                    if (str.substring(0, ID_MARK.length()).equals(ID_MARK)) {
                        break;
                    }
                    if (isFirstDescriptionLine) {
                        description.append(str);
                    } else {
                        description.append('\n' + str);
                    }
                    isFirstDescriptionLine = false;
                }
                tasks.add(new SimpleTask(id, description.toString(), date));
            }

            scan.close();

        } catch (FileNotFoundException ex) {
            throw new IOException(ex);
        } catch (ParseException | NumberFormatException ex) {
            throw new IOException("Cannot parse values at line " + lineNumber + " in " + file.getName());
        }
    }

    @Override
    public void save() throws IOException {
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file, false)));
        for (Task task : tasks) {
            out.println(ID_MARK + ' ' + task.getId());
            out.println(dateFormat.format(task.getDateTask()));
            out.println(task.getDescriptionTask());
        }
        out.close();
    }

    @Override
    public void append(Task task) throws IOException {
        tasks.add(new SimpleTask(task));

        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file, true)));
        out.println(ID_MARK + ' ' + task.getId());
        out.println(dateFormat.format(task.getDateTask()));
        out.println(task.getDescriptionTask());
        out.close();
    }

    @Override
    public void insert(Task task, int pos) throws IOException {
        if (pos == tasks.size()) {
            append(task);
        } else {
            tasks.add(pos, new SimpleTask(task));
            save();
        }
    }

    @Override
    public void insertAfter(Task task, int id) throws IOException {
        ListIterator<Task> listItr = searchById(id);
        if (listItr == null) {
            throw new NoSuchElementException();
        }
        if (listItr.nextIndex() == tasks.size()) {
            append(task);
        } else {
            listItr.add(new SimpleTask(task));
            save();
        }
    }

    @Override
    public boolean delete(int id) throws IOException {
        ListIterator<Task> listItr = searchById(id);
        if (listItr == null) {
            return false;
        }
        listItr.remove();
        save();
        return true;
    }
    @Override
    public List<Task> getTasksView() {
        return java.util.Collections.unmodifiableList(tasks);
    }

    SimpleJournal(String fileName) throws IOException {
        file = new File(fileName);
        if (!file.exists()) {
            file.createNewFile();
        }
        load();
    }


}
