import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * @author s0583313, Kristiyan Georgiev
 */
public class Processor implements Runnable {
    private Path toRead = Paths.get(System.getProperty("user.dir") + "/Read");

    public void read() throws InterruptedException {
        FileInputStream fis;
        DataInputStream dis;
        int val1, val2;
        while (true) {
            try {
                // ArrayList<Path> existingFiles = (ArrayList<Path>) Files.list(toRead).toList(); couldnt remove a file which was done ?
                // Stream<Path> existingFilesAsStream = Files.list(toRead);
                ArrayList<Path> existingFiles = ((ArrayList<Path>) (Files.list(toRead)).collect(Collectors.toList())); // convert Files.list(toRead) to Stream
                while (!existingFiles.isEmpty()) { // as long as the dir is not empty
                    String currFile = existingFiles.remove(0).toString();
                    fis = new FileInputStream(currFile);
                    dis = new DataInputStream(fis);
                    LogHelper.printThreadLog("Processing.....");
                    val1 = dis.readInt();
                    val2 = dis.readInt();
                    fis.close();
                    dis.close();
                    LogHelper.printThreadLog("Processor finished!");
                    Files.delete(Path.of(currFile)); // remove file of task which was already calculated
                    LogHelper.printTaskLog(val1 + " + " + val2 + " = " + (val1 + val2)); // print out
                    Thread.sleep(400);
                }
            } catch (IOException e) {
                // System.err.println("Couldnt process.....");
            }
        }
    }

    @Override
    public void run() {
        try {
            this.read();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
