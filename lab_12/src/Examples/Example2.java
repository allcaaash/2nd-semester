package Examples;

public class Example2 {
    public static void main(String[] args) throws InterruptedException{
        Thread thread = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                System.out.println(i);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        });

        thread.start();
        thread.join();
    }
}
