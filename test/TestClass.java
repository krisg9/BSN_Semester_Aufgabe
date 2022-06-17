import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class Tests {

    String path;
    FileInputStream testFis;
    DataInputStream testDis;
    File file;
    Filler f;
    Processor p;

    @BeforeEach
    void setup() throws FileNotFoundException {
        path = System.getProperty("user.dir");
        file = new File(path + "/testfile.txt");
        f = new Filler(file);
        p = new Processor(file);
        testFis = new FileInputStream(file);
        testDis = new DataInputStream(testFis);
    }

    // clear file from earlier tests
    @AfterEach
    void breakdown() {
        file.delete();
        file = new File(path + "/testfiel.txt");
    }

    // test one line of summands
    @Test
    void test1() throws IOException {
        //System.out.println(path);
        f.write(1, 4);
        assertEquals(1, testDis.readInt());
        testDis.readByte();
        assertEquals(4, testDis.readInt());
    }

    // test two lines of summands
    @Test
    void test2() throws IOException {
        f.write(5, 7);
        assertEquals(1, testDis.readInt());
        testDis.readByte();
        assertEquals(4, testDis.readInt());
        testDis.readByte();
        assertEquals(5, testDis.readInt());
        testDis.readByte();
        assertEquals(7, testDis.readInt());
    }

    @Test
    void testWritingResult() {

    }
}
