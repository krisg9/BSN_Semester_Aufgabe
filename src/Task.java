import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Task {

    private int val1;
    private int val2;

    public Task(int val1, int val2) {
        this.val1 = val1;
        this.val2 = val2;
    }

    public void writeWithDOS(DataOutputStream dos) throws IOException {
        dos.writeInt(this.val1);
        dos.writeInt(this.val2);
    }

    /*
    @Override
    public String toString() {
        return "Task: " + val1 + " + " + val2 + " = " + (val1 + val2);
    }
     */
}
