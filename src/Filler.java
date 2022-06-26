import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Filler {
    private List<Task> buffer;
    private String filePath;
    private String filename = "testfile.txt";
    private Path filepath;

    public Filler() {
        buffer = new ArrayList<>();
    }

    public void addToBuffer(int val1, int val2) {
        buffer.add(new Task(val1, val2));
    }

    public void addToFile() {
        FileOutputStream fos;
        DataOutputStream dos;
        try {
            fos = new FileOutputStream(filename);
            dos = new DataOutputStream(fos);
            Task t;
            if (!buffer.isEmpty()) {
                t = buffer.remove(0);
                t.writeWithDOS(dos);
            }
            fos.close();
            dos.close();
            Path filepath = Paths.get(System.getProperty("user.dir") + filename);
            Path targetPath = Paths.get(System.getProperty("user.dir") + "/Read" + filename + System.currentTimeMillis());
            Files.move(filepath, targetPath);
        } catch (IOException ioe) {
            System.err.println("File not found.");
        }
    }
}