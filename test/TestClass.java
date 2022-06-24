import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;

class Tests {
    Filler f;
    Processor p;

    @BeforeEach
    void setup() {
        f = new Filler(new File(System.getProperty("user.dir") + "/testfile.txt"));
        p = new Processor(f.getTasksFile());
    }

    // test one line of summands
    @Test
    void test1() {
        f.addTask(1, 4);
        p.read();
    }

    @Test
    void test2() {
        f.addTask(5, 7);
        p.read();
    }

    // test two lines of summands
    @Test
    void testWritingResult() {
        f.addTask(45,12);
        p.read();
        f.addTask(23, 32);
        p.read();
    }
}
