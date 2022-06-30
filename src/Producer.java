import java.io.DataOutputStream;
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
        // produces random task
        val1 = (int) (Math.random() * 1000) + 1;
        val2 = (int) (Math.random() * 1000) + 1;
    }


    @Override
    public void run() {
        while (true) {
            try {
                // connection to FillerToBuffer
                Socket socket = new Socket("localhost", PORT);
                OutputStream os = socket.getOutputStream();
                DataOutputStream dos = new DataOutputStream(os);
                LogHelper.printThreadLog("Producer sending Task......");
                dos.writeInt(this.val1);
                dos.writeInt(this.val2);
                os.close();
                dos.close();
                LogHelper.printThreadLog("Producer sent task!");
                // leave loop if task was sent successfully
                socket.close();
                break;
            } catch (IOException e) {
                // if not connected - sleep and try again
                try {
                    LogHelper.printThreadLog("Producer sleeping...zzzzz");
                    Thread.sleep(WAIT);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
    }
}
