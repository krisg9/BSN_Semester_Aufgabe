import java.io.*;
import java.nio.file.Paths;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        File file = new File("/home/kristiyan/IdeaProjects/BSN_Semester_Aufgabe/testfile.txt");
        Filler f = new Filler(file);
        String path = System.getProperty("user.dir");
        System.out.println(path);
        f.write(1,4);
        f.write(5, 3);
        f.write(8, 12341);
        f.write(123523, 61235421);
        Processor p = new Processor(file);
        p.writeResult();
        try {
            FileReader fr = new FileReader(file);
            Scanner scan = new Scanner(fr);
            while (scan.hasNextLine()) {
                System.out.println(scan.nextLine());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
