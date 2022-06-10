import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Filler {
    private FileOutputStream fileOutputStream;
    private String filename;
    DataOutputStream dos;

    public Filler(String filename, FileOutputStream fileOutputStream) {
        try {
            this.fileOutputStream = new FileOutputStream(this.filename);
            dos = new DataOutputStream(fileOutputStream);
        } catch (FileNotFoundException e) {
            System.err.println("File not found. Would you like to enter another filename?");
            System.exit(0);
        }
    }

    public void write(Task task) {
        try {
            dos.writeInt(task.getInt1());
            dos.writeChar(' ');
            dos.writeInt(task.getInt2());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}