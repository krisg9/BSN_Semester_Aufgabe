import java.io.*;
/**
 * @author s0583313, Kristiyan Georgiev
 */
public class Processor {
    private int val1;
    private int val2;
    private final File file;

    public Processor(File file) {
        this.file = file;
    }

    public void read() {
        FileInputStream fis;
        DataInputStream dis;
        try {
            fis = new FileInputStream(file);
            dis = new DataInputStream(fis);
            val1 = dis.readInt();
            dis.readByte();
            val2 = dis.readInt();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void writeResult() {
        FileOutputStream fos;
        DataOutputStream dos;
        try {
            fos = new FileOutputStream(file, true);
            dos = new DataOutputStream(fos);
            dos.writeInt(val1 + val2);
        } catch (IOException e) {
            System.err.println("Could't write result.");
        }
    }
}
