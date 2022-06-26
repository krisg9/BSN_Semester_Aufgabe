import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Producer implements Runnable {
    private final int PORT;
    private int val1;
    private int val2;
    private final int WAIT = 400;

    public Producer(int port) {
        PORT = port;
        val1 = (int) (Math.random() * 1000) + 1;
        val2 = (int) (Math.random() * 1000) + 1;
    }


    @Override
    public void run() {
        while (true) {
            try {
                Socket socket = new Socket("localhost", PORT);
                OutputStream os = socket.getOutputStream();
                DataOutputStream dos = new DataOutputStream(os);
                dos.writeInt(this.val1);
                dos.writeInt(this.val2);
                os.close();
                dos.close();
                break;
            } catch (IOException e) {
                // if not connected - sleep
                try {
                    Thread.sleep(WAIT);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
    }
}
