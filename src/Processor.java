import javax.xml.crypto.Data;
import java.io.*;
/**
 * @author s0583313, Kristiyan Georgiev
 */
public class Processor {
    private final File file;

    public Processor(File file) {
        this.file = file;
    }

    public int read() {
        FileInputStream fis;
        DataInputStream dis;
        int val1, val2;
        try {
            fis = new FileInputStream(file);
            dis = new DataInputStream(fis);
            val1= dis.readInt(); // read space between nums
            dis.read();
            val2 = dis.readInt();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
        return val1 + val2;
    }

    public void writeResult() {
        FileOutputStream fos;
        DataOutputStream dos;
        try {
            fos = new FileOutputStream(file, true);
            dos = new DataOutputStream(fos);
            dos.writeInt(0);
        } catch (IOException e) {
            System.err.println("Could't write result.");
        }
    }
}
