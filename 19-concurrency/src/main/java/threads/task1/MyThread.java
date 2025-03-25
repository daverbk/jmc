package threads.task1;

import java.util.concurrent.TimeUnit;

public class MyThread extends Thread {

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            try {
                System.out.println("2");
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }
}
