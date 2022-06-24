public class Producer {
    public static void main(String[] args) {
        Task t1 = new Task((int) (Math.random()*100 + 1), (int) (Math.random()*100 + 1));
        Task t2 = new Task((int) (Math.random()*100 + 1), (int) (Math.random()*100 + 1));
    }
}
