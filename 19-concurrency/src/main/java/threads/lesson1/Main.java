package threads.lesson1;

import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        var currentThread = Thread.currentThread();
        System.out.println(currentThread.getClass().getName());
        System.out.println(currentThread);
        printThreadState(currentThread);

        currentThread.setName("Main guy");
        currentThread.setPriority(Thread.MAX_PRIORITY);
        printThreadState(currentThread);

        CustomThread customThread = new CustomThread();
        customThread.start();

        Runnable myRunnable = () -> {
            for (int i = 1; i <= 8; i++) {
                System.out.print(" 2 ");
                try {
                    TimeUnit.MILLISECONDS.sleep(250);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread myThread = new Thread(myRunnable);
        myThread.start();

        for (int i = 1; i <= 3; i++) {
            System.out.print(" 0 ");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void printThreadState(Thread thread) {
        System.out.println("---------");
        System.out.println("Thread id: " + thread.getId());
        System.out.println("Thread name: " + thread.getName());
        System.out.println("Thread priority: " + thread.getPriority());
        System.out.println("Thread state: " + thread.getState());
        System.out.println("Thread group " + thread.getThreadGroup());
        System.out.println("Thread is alive: " + thread.isAlive());
        System.out.println("---------");
    }
}
