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
            LogHelper.printThreadLog("FillerToFile starting.....");
            try {
                f.addToFile();
                LogHelper.printThreadLog("FillerToFile finished!");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            try {
                // timeout until other tasks come in
                Thread.sleep(SLEEPTIME);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
