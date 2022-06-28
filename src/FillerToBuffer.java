import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class FillerToBuffer implements Runnable {
    private Filler f;
    private final int PORT;

    public FillerToBuffer(Filler f, int port) {
        this.f = f;
        this.PORT = port;
    }

    @Override
    public void run() {
        try {
            ServerSocket serverSocket = null;
            serverSocket = new ServerSocket(PORT);
            while (true) {
                // wait for a producer to connect
                Socket s = serverSocket.accept();
                InputStream is = s.getInputStream();
                System.out.println("FillerToBuffer is accepting Task....");
                DataInputStream dis = new DataInputStream(is);
                int val1 = dis.readInt();
                int val2 = dis.readInt();
                // writing task to Filler's buffer (ArrayList)
                f.addToBuffer(val1, val2);
                is.close();
                dis.close();
                System.out.println("FillerToBuffer: Task arrived!");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
