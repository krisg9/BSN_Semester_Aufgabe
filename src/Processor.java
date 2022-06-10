import java.io.*;

public class Processor {
    private int val1;
    private int val2;
    private final String filename;

    public Processor(String filename) {
        this.filename = filename;
    }

    public void read() {
        FileInputStream fis;
        DataInputStream dis;
        try {
            fis = new FileInputStream(filename);
            dis = new DataInputStream(fis);
            val1 =dis.readInt();
            dis.read();
            val2 = dis.readInt();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void writeResult() {
        FileOutputStream fos;
        DataOutputStream dos;
        try {
            fos = new FileOutputStream("testfile.txt", true);
            dos = new DataOutputStream(fos);
            dos.writeInt(val1 + val2);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
