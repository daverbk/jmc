package threads.task2;

import java.util.UUID;

public class Main {

    public static void main(String[] args) {
        ShoeWarehouse warehouse = new ShoeWarehouse();
        ShoeWarehouse.products.put("Nike Corsair", 10);

        Thread producer = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                Order order = new Order(UUID.randomUUID().toString(), "Nike Corsair", 1);
                warehouse.receiveOrder(order);
            }
        });

        
    }
}
