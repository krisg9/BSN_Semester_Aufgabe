import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class tests {
    final int WAIT = 2000;
    final int WAIT_LONGER = 10000;
    Filler f;
    Processor proc;
    FillerToBuffer ftb;
    FillerToFile ftf;
    Producer prod;
    final int PORT = 3333;
    Thread fToBuffer, fToFile, procThread;
    Thread[] prodThreads;

    @BeforeEach
    void setup() {
        f = new Filler();
        ftb = new FillerToBuffer(f, PORT);
        fToBuffer = new Thread(ftb);
        ftf = new FillerToFile(f);
        fToFile = new Thread(ftf);
        proc = new Processor();
        procThread = new Thread(proc);
    }

    // test one line of summands
    @Test
    void oneProducerOnlyTest() throws InterruptedException {
        fToBuffer.start();
        fToFile.start();
        procThread.start();
        (new Thread(new Producer(PORT))).start();
        // current test has to sleep a bit
        Thread.sleep(WAIT);
    }

    // 2 threads
    @Test
    void twoProducersTest() throws InterruptedException {
        fToBuffer.start();
        fToFile.start();
        procThread.start();
        (new Thread(new Producer(PORT))).start();
        (new Thread(new Producer(PORT))).start();
        Thread.sleep(WAIT);
    }

    // each thread gets a different random number from producer?
    @Test
    void severalProducersTest() throws InterruptedException {
        final int NUM_OF_THREADS = 5;
        System.out.println("================" + NUM_OF_THREADS + " PRODUCER THREADS================");
        // make producer threads
        prodThreads = new Thread[NUM_OF_THREADS];
        for (int i = 0; i < NUM_OF_THREADS; i++) {
            prodThreads[i] = new Thread(new Producer(PORT));
        }
        // filler and processor
        fToBuffer.start();
        fToFile.start();
        procThread.start();
        Thread.sleep(WAIT);
        // start producers
        for (int i = 0; i < NUM_OF_THREADS; i++) {
            prodThreads[i].start();
        }
    }

    @Test
    void moreProducersTest() throws InterruptedException {
        final int NUM_OF_THREADS = 10;
        System.out.println("================" + NUM_OF_THREADS + " PRODUCER THREADS================");
        // make producer threads
        for (int i = 0; i < NUM_OF_THREADS; i++) {
            prodThreads[i] = new Thread(new Producer(PORT));
        }
        fToBuffer.start();
        fToFile.start();
        procThread.start();
        prodThreads = new Thread[NUM_OF_THREADS];
        // start producer threads
        for (int i = 0; i < NUM_OF_THREADS; i++) {
            prodThreads[i].start();
        }
        Thread.sleep(WAIT_LONGER);
    }

    @Test
    void evenMoreProducers() throws InterruptedException {
        final int WAIT_LONGER_LONGER = 20000;
        final int NUM_OF_THREADS = 20;
        prodThreads = new Thread[NUM_OF_THREADS];
        // create producer threads
        for (int i = 0; i < prodThreads.length; i++) {
            prodThreads[i] = new Thread(new Producer(PORT));
        }
        System.out.println("================" + NUM_OF_THREADS + " PRODUCER THREADS================");
        // make producer threads
        fToBuffer.start();
        fToFile.start();
        procThread.start();
        // start producer threads
        for (int i = 0; i < NUM_OF_THREADS; i++) {
            prodThreads[i].start();
        }
        Thread.sleep(WAIT_LONGER_LONGER);
    }
}
