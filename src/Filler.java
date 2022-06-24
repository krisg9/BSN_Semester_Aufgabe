import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Filler implements Runnable {
    private File tasksFile;

    public Filler(File tasksFile) {
        this.tasksFile = tasksFile;
    }

    public void addTask(int val1, int val2) {
        FileOutputStream fos;
        DataOutputStream dos;
        try {
            fos = new FileOutputStream(this.tasksFile);
            dos = new DataOutputStream(fos);
            Task t = new Task(val1, val2);
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