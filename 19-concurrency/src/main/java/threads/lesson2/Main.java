package threads.lesson2;

public class Main {

    public static void main(String[] args) {

        System.out.println("Main thread running");
        try {
            System.out.println("Main thread is paused for 1 second");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread thread = new Thread(() -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("Thread " + threadName + " should take 10 dots to run");
            for (int i = 0; i < 10; i++) {
                System.out.print(".");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    System.out.println("\nWhooops! " + threadName + " was interrupted");
                    Thread.currentThread().interrupt();
                    return;
                }
            }
            System.out.println("\n" + threadName + " finished");
        });

        Thread installThread = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                try {
                    Thread.sleep(250);
                    System.out.println("Installation thread " + (i + 1) + " is completed");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Installation thead");


        Thread threadMonitor = new Thread(() -> {
            long now = System.currentTimeMillis();
            while (thread.isAlive()) {
                System.out.println(
                    "Main thread is waiting for " + thread.getName() + " to finish");
                try {
                    Thread.sleep(1000);
                    if (System.currentTimeMillis() - now > 8000) {
                        thread.interrupt();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        System.out.println(thread.getName() + " starting");
        thread.start();
        threadMonitor.start();

        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (!thread.isInterrupted()) {
            installThread.start();
        } else {
            System.out.println("Thread " + thread.getName() + " was interrupted" + installThread.getName() + " can't run.");
        }
    }
}
