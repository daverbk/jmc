package threads.task1;

import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        var eventThread = new MyThread();
        var oddThread = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                try {
                    System.out.println("1");
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }
            }
        });

        eventThread.start();
        oddThread.start();

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        eventThread.interrupt();
        oddThread.interrupt();
    }
}

