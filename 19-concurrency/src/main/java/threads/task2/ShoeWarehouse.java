package threads.task2;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ShoeWarehouse {

    private final List<Order> orders = new LinkedList<>();
    public static Map<String, Integer> products = new HashMap<>();

    public synchronized void receiveOrder(Order order) {
        try {
            wait();
            if (products.getOrDefault(order.type(), null) != null
                && products.get(order.type()) >= order.quantity()) {
                orders.add(order);
                System.out.printf("The order #%s has been accepted\n", order.id());
            } else {
                System.out.printf("Order can't be accepted because of the %s product shortage\n",
                    order.type());
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        notifyAll();
    }

    public synchronized void fulfillOrder() {
        while (!orders.isEmpty()) {
            try {
                wait();
                String threadName = Thread.currentThread().getName();
                System.out.printf("Order #%s is processed by %s.", orders.get(0).id(), threadName);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        notifyAll();
    }
}
