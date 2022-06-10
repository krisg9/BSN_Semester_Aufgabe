/**
 * @author s0583313, Kristiyan Georgiev
 */

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Filler {
    private final String filename;

    public Filler(String filename) {
        this.filename = filename;
    }

    public void write(int integer1, int integer2) {
        FileOutputStream fos;
        DataOutputStream dos;
        try {
            fos = new FileOutputStream(filename, true);
            dos = new DataOutputStream(fos);
            dos.writeInt(integer1);
            dos.writeBytes(" ");
            dos.writeInt(integer2);
            dos.writeBytes("\n");
        } catch (IOException e) {
            System.err.println("File not found.");
        }
    }
}