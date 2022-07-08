import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

public class Filler {
    // storing tasks
    private Queue<Task> buffer;
    // not needed?
    //private String filePath;

    private final String filename = "testfile.txt";

    // not needed?
    //private Path filepath;

    public Filler() {
        buffer = new ConcurrentLinkedDeque<>();
    }

    public void addToBuffer(int val1, int val2) {
        buffer.add(new Task(val1, val2));
    }

    public void addToFile() throws InterruptedException {
        FileOutputStream fos;
        DataOutputStream dos;
        while (true) {
            try {
                fos = new FileOutputStream(filename);
                dos = new DataOutputStream(fos);
                Task t;
                if (!buffer.isEmpty()) {
                    t = buffer.remove();
                    t.writeWithDOS(dos);
                    fos.close();
                    dos.close();
                    Path filepath = Paths.get(System.getProperty("user.dir") + "/" + filename);
                    Path targetPath = Paths.get(System.getProperty("user.dir") + "/Read" + "/" + filename + System.currentTimeMillis());
                    // moves file with one task to another folder (different name because of timestamp)
                    Files.move(filepath, targetPath);
                    Thread.sleep(50);
                    /*
                    sleep otherwise it throws ioe, because it is constantly looking for
                    the file even when it is moved and some producers cant write
                    */
                }
            } catch (IOException ioe) {
                // System.err.println("Filler: File not found.");
                // dont print anything
            }
        }
    }
}