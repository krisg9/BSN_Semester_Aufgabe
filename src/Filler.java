import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Scanner;

public class Filler {
    private FileOutputStream fileOutputStream;
    private String filename;

    public Filler(String filename, FileOutputStream fileOutputStream) {
        try {
            this.fileOutputStream = new FileOutputStream(this.filename);
            DataOutputStream dos = new DataOutputStream(fileOutputStream);
        } catch (FileNotFoundException e) {
            System.err.println("File not found. Would you like to enter another filename?");
            Scanner scan = new Scanner(System.in);
            String inputFileName = scan.next();
            setFilename(inputFileName);
        }
    }

    public void write() {

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
