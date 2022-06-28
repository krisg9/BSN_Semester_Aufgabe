import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author s0583313, Kristiyan Georgiev
 */
public class Processor implements Runnable {
    private Path toRead = Paths.get(System.getProperty("user.dir") + "/Read");

    public void read() {
        FileInputStream fis;
        DataInputStream dis;
        int val1, val2;
        while (true) {
            try {
                // ArrayList<Path> existingFiles = (ArrayList<Path>) Files.list(toRead).toList();
                Stream<Path> existingFilesAsStream = Files.list(toRead);
                List<Path> existingFiles = existingFilesAsStream.collect(Collectors.toList());
                while (!existingFiles.isEmpty()) {
                    String currFile = existingFiles.remove(0).toString();
                    fis = new FileInputStream(currFile);
                    dis = new DataInputStream(fis);
                    System.out.println("Processing.....");
                    val1 = dis.readInt();
                    val2 = dis.readInt();
                    fis.close();
                    dis.close();
                    System.out.println("Processor finished!");
                    Files.delete(Path.of(currFile));
                    LogHelper.printThreadLog(val1 + " + " + val2 + " = " + (val1 + val2));
                }
            } catch (IOException e) {
                System.err.println("Couldnt process.....");
            }
        }
    }

    @Override
    public void run() {
        this.read();
    }
}
