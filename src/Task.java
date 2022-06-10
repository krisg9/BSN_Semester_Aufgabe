import java.util.Scanner;

public class Task {
    private int int1;
    private int int2;
    static Scanner scanner = new Scanner(System.in);

    public Task(int int1, int int2) {
        this.int1 = int1;
        this.int2 = int2;
    }

    public void read() {
        System.out.println("Type the integers to be added: /n");
        int1 = scanner.nextInt();
        int2 = scanner.nextInt();
    }

    @Override
    public String toString() {
        return int1 + " " + int2;
    }
}
