import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

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
        //dos.write();
    }

    public void setFilename(String filename) {
        if (filename == null) {
            throw new NullPointerException("File cannot be null.");
        }
        if (filename.equals("")) {
            throw new IllegalArgumentException("Filename cannot be empty.");
        }
        this.filename = filename;
    }
}