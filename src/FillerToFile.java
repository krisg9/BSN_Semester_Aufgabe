import java.nio.file.*;

public class FillerToFile implements Runnable {
    private Filler f;
    private final int SLEEPTIME = 200;

    public FillerToFile(Filler f) {
        this.f = f;
    }


    @Override
    public void run() {
        while (true) {
            System.out.println("FillerToFile starting.....");
            try {
                f.addToFile();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("FillerToFile finished!");
            try {
                Thread.sleep(SLEEPTIME);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
