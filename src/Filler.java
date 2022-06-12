/**
 * @author s0583313, Kristiyan Georgiev
 */

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Filler {
    private final File file;

    public Filler(File file) {
        this.file = file;
    }

    public void write(int integer1, int integer2) {
        FileOutputStream fos;
        DataOutputStream dos;
        try {
            fos = new FileOutputStream(file, true);
            dos = new DataOutputStream(fos);
            dos.writeBytes(String.valueOf(integer1));
            dos.writeBytes(" ");
            dos.writeBytes(String.valueOf(integer2));
            dos.writeBytes("\n");
        } catch (IOException e) {
            System.err.println("File not found.");
        }
    }
}