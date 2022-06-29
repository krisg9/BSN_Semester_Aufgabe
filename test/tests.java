import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class tests {
    final int WAIT = 2000;
    final int WAIT_LONGER = 10000;
    Filler f;
    Processor proc;
    FillerToBuffer ftb;
    FillerToFile ftf;
    Producer prod, prod1, prod2, prod3, prod4, prod5, prod6, prod7, prod8, prod9, prod10;
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
        prod = new Producer(PORT);
        prod1 = new Producer(PORT);
        prod2 = new Producer(PORT);
        prod3 = new Producer(PORT);
        prod4 = new Producer(PORT);
        prod5 = new Producer(PORT);
        prod6 = new Producer(PORT);
        prod7 = new Producer(PORT);
        prod8 = new Producer(PORT);
        prod9 = new Producer(PORT);
        prod10 = new Producer(PORT);
    }

    // test one line of summands
    @Test
    void oneProducerOnlyTest() throws InterruptedException {
        fToBuffer.start();
        fToFile.start();
        procThread.start();
        (new Thread(prod1)).start();
        // current test has to sleep a bit
        Thread.sleep(WAIT);
    }

    // 2 threads
    @Test
    void twoProducersTest() throws InterruptedException {
        fToBuffer.start();
        fToFile.start();
        procThread.start();
        Thread firstProd = new Thread(prod1);
        Thread secondProd = new Thread(prod2);
        firstProd.start();
        secondProd.start();
        Thread.sleep(WAIT);
    }

    // each thread gets a different random number from producer?
    @Test
    void severalProducersTest() throws InterruptedException {
        final int NUM_OF_THREADS = 5;
        System.out.println("================" + NUM_OF_THREADS + " PRODUCER THREADS================");
        // make producer threads
        Thread[] prodThreads = {new Thread(prod1),
                                new Thread(prod2),
                                new Thread(prod3),
                                new Thread(prod4),
                                new Thread(prod5)};
        for (int i = 0; i < NUM_OF_THREADS; i++) {
            prodThreads[i].start();
        }
        // filler and processor
        fToBuffer.start();
        fToFile.start();
        procThread.start();
        Thread.sleep(WAIT);
    }

    @Test
    void moreProducersTest() throws InterruptedException {
        final int NUM_OF_THREADS = 10;
        System.out.println("================" + NUM_OF_THREADS + " PRODUCER THREADS================");
        // make producer threads
        fToBuffer.start();
        fToFile.start();
        procThread.start();
        Thread[] prodThreads = {new Thread(prod1),
                new Thread(prod2),
                new Thread(prod3),
                new Thread(prod4),
                new Thread(prod5),
                new Thread(prod6),
                new Thread(prod7),
                new Thread(prod8),
                new Thread(prod9),
                new Thread(prod10)};
        for (int i = 0; i < NUM_OF_THREADS; i++) {
            prodThreads[i].start();
        }
        // filler and processor
        Thread.sleep(WAIT_LONGER);
    }

    @Test
    void evenMoreProducers() throws InterruptedException {
        final int WAIT_LONGER_LONGER = 20000;
        final int NUM_OF_THREADS = 20;
        prodThreads = new Thread[NUM_OF_THREADS];
        for (int i = 0; i < prodThreads.length; i++) {
            prodThreads[i] = new Thread(new Producer(PORT));
        }
        System.out.println("================" + NUM_OF_THREADS + " PRODUCER THREADS================");
        // make producer threads
        fToBuffer.start();
        fToFile.start();
        procThread.start();
        for (int i = 0; i < NUM_OF_THREADS; i++) {
            prodThreads[i].start();
        }
        // filler and processor
        Thread.sleep(WAIT_LONGER_LONGER);
    }
}
