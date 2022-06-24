import java.io.*;
/**
 * @author s0583313, Kristiyan Georgiev
 */
public class Processor implements Runnable {
    private final File file;

    public Processor(File file) {
        this.file = file;
    }

    public void read() {
        FileInputStream fis;
        DataInputStream dis;
        int val1, val2;
        try {
            fis = new FileInputStream(file);
            dis = new DataInputStream(fis);
            val1= dis.readInt();
            val2 = dis.readInt();
            // fis.close();
            // dis.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
        // print task and answer to console
        LogHelper.printThreadLog(val1 + " + " + val2 + " = " + (val1 + val2));
    }

    public void run() {
        this.read();
    }
}
