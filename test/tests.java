import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class tests {
    Filler f;
    Processor proc;
    FillerToBuffer ftb;
    FillerToFile ftf;
    Producer prod;
    final int PORT = 3333;
    Thread fToBuffer, fToFile, procThread, prodThread;

    @BeforeEach
    void setup() {
        f = new Filler();
        ftb = new FillerToBuffer(f,PORT);
        fToBuffer = new Thread(ftb);
        ftf = new FillerToFile(f);
        fToFile = new Thread(ftf);
        proc = new Processor();
        procThread = new Thread(proc);
        prod = new Producer(PORT);
        prodThread = new Thread(prod);
    }

    // test one line of summands
    @Test
    void test1() throws InterruptedException {
        fToBuffer.start();
        fToFile.start();
        procThread.start();
        prodThread.start();
        // current test has to sleep a bit
        Thread.sleep(1000);
    }

    @Test
    void test2() {
    }

    // test two lines of summands
    @Test
    void testWritingResult() {
    }
}
