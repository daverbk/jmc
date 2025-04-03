package threads.task2;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

class ShoeWarehouse {

    private final List<Order> orders;
    public final static String[] PRODUCTS_LIST = {
        "Nike Corsair",
        "Nike Air Max",
        "Nike Air Force 1"
    };

    public ShoeWarehouse() {
        this.orders = new LinkedList<>();
    }

    public synchronized void receiveOrder(Order order) {
        while (orders.size() > 20) {
            try {
                System.out.println("Too many orders, waiting for the warehouse to be freed");
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        orders.add(order);
        System.out.printf("The order #%s has been accepted\n", order.id());
        notifyAll();
    }

    public synchronized Order fulfillOrder() {
        while (orders.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        String threadName = Thread.currentThread().getName();
        var order = orders.remove(0);
        System.out.printf("Order #%s is processed by %s.\n", order.id(), threadName);
        notifyAll();
        return order;
    }
}


record Order(String id, String item, int quantity) {

}

public class Main {

    private static final Random random = new Random();

    public static void main(String[] args) {
        ShoeWarehouse warehouse = new ShoeWarehouse();

        Thread producer = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                warehouse.receiveOrder(
                    new Order(
                        UUID.randomUUID().toString(),
                        ShoeWarehouse.PRODUCTS_LIST[random.nextInt(0, 3)],
                        random.nextInt(1, 4)
                    )
                );
            }
        });
        producer.start();

        for (int i = 0; i < 2; i++) {
            Thread consumer = new Thread(() -> {
                for (int j = 0; j < 5; j++) {
                    warehouse.fulfillOrder();
                }
            });
            consumer.start();
        }
    }
}
