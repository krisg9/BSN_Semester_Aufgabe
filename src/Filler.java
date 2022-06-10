import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author s0583313, Kristiyan Georgiev
 */
public class Filler {
    private final String filename;

    public Filler(String filename) {
        this.filename = filename;
    }

    public void write(int integer1, int integer2) {
        try {
            FileOutputStream fos = new FileOutputStream(filename);
            DataOutputStream dos = new DataOutputStream(fos);
            dos.writeInt(integer1);
            dos.writeChar(' ');
            dos.write(integer2);
        } catch (IOException e) {
            System.err.println("File not found.");
        }
    }
}