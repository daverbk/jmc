package threads.lesson3;

import java.util.concurrent.TimeUnit;

public class CachedData {

    private volatile boolean flag = false;

    public void toggleFlag() {
        flag = !flag;
    }

    public boolean isReady() {
        return flag;
    }

    public static void main(String[] args) {
        CachedData example = new CachedData();

        Thread writerThread = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            example.toggleFlag();
            System.out.println("A. Flag set to " + example.isReady());
        });

        Thread readerThread = new Thread(() -> {
            while (!example.isReady()) {

            }
            System.out.println("B. Flag is " + example.isReady());
        });

        writerThread.start();
        readerThread.start();
    }
}
