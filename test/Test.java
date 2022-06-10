import java.io.*;

public class Test {
    public static void main(String[] args) {
        Filler f = new Filler("testfile.txt");
        f.write(1,4);
        f.write(5, 3);
        f.write(8, 12341);
        f.write(123523, 61235421);
        Processor p = new Processor("testfile.txt");
        p.writeResult();
    }
}
