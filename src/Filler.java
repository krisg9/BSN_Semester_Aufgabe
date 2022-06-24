import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Filler implements Runnable {

    private File tasksFile;
    private List<Task> taskList;

    public Filler(File tasksFile) {
        this.tasksFile = tasksFile;
        this.taskList = new ArrayList<>();
    }

    public void addTask(int val1, int val2) {
        FileOutputStream fos;
        DataOutputStream dos;
        try {
            fos = new FileOutputStream(this.tasksFile);
            dos = new DataOutputStream(fos);
            Task t = new Task(val1, val2);
            taskList.add(t);
            t.writeWithDOS(dos);
            // fos.close();
            // dos.close();
        } catch (IOException e) {
            System.err.println("File not found.");
        }
    }

    public File getTasksFile() {
        return tasksFile;
    }

    @Override
    public void run() {

    }
}