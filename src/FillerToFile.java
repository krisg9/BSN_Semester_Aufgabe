import java.nio.file.*;

public class FillerToFile implements Runnable {
    private Filler f;
    private final int SLEEPTIME = 200;

    public FillerToFile(Filler f) {
        this.f = f;
    }


    @Override
    public void run() {
        LogHelper.printThreadLog("FillerToFile starting.....");
        while (true) {
            try {
                f.addToFile();
                LogHelper.printThreadLog("FillerToFile finished!");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            // timeout until other tasks come in
            try {
                Thread.sleep(SLEEPTIME);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
