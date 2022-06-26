import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * @author s0583313, Kristiyan Georgiev
 */
public class Processor implements Runnable {
    private Path toRead = Paths.get(System.getProperty("user.dir") + "/Read");

    public void read() {
        FileInputStream fis;
        DataInputStream dis;
        int val1, val2;
        try {
            List<Path> existingFiles = (Files.list(toRead)).toList();
            while (!existingFiles.isEmpty()) {
                String currFile = existingFiles.remove(0).toString();
                fis = new FileInputStream(currFile);
                dis = new DataInputStream(fis);
                val1 = dis.readInt();
                val2 = dis.readInt();
                fis.close();
                dis.close();
                Files.delete(Path.of(currFile));
                LogHelper.printThreadLog(val1 + " + " + val2 + " = " + (val1 + val2));
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    @Override
    public void run() {
        this.read();
    }
}
