package example19_03;

public class Main {
    private static final Object lock = new Object();
    private static int num = 1;

    public static void main(String[] args) throws InterruptedException{
        Thread thread1 = new Thread(() -> {
            synchronized (lock) {
                while (num <= 10) {
                    if (num % 2 == 0) {
                        System.out.println(Thread.currentThread().getName() + ": " + num);
                        num++;
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException exception) {
                            exception.printStackTrace();
                        }
                    }
                    lock.notifyAll();
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (lock) {
                while (num <= 10) {
                    if (num % 2 != 0) {
                        System.out.println(Thread.currentThread().getName() + ": " + num);
                        num++;
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException exception) {
                            exception.printStackTrace();
                        }
                    }
                    lock.notifyAll();
                }
            }
        });

        thread1.setName("Even Thread");
        thread2.setName("Odd Thread");

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }
}
