package abstractclasschallenge;

import java.util.ArrayList;

public class Store {
    private static ArrayList<ProductForSale> productsForSale = new ArrayList<>();

    public static void main(String[] args) {
        productsForSale.add(new ArtItem("Oil Painting", 1350,
                "Impressionist work by ABF painted in 2010"));

        productsForSale.add(new ArtItem("Sculpture", 2000,
                "Bronze work by JKF, produced in 1950"));

        productsForSale.add(new Furniture("Desk", 500,
                "Mahogany Desk"));

        productsForSale.add(new Furniture("Lamp", 200,
                "Tiffany Lamp with Hummingbirds"));

        listProducts();

        System.out.println("\nOrder 1");
        var order1 = new ArrayList<OrderItem>();
        addItemToOrder(order1, 1, 2);
        addItemToOrder(order1, 0, 1);
        printOrder(order1);

        System.out.println("\nOrder 2");
        var order2 = new ArrayList<OrderItem>();
        addItemToOrder(order2, 3, 5);
        addItemToOrder(order2, 0, 1);
        addItemToOrder(order2, 2, 1);
        printOrder(order2);
    }

    public static void addProduct(ProductForSale productForSale) {
        productsForSale.add(productForSale);
    }


    public static void displayProductDetails() {
        productsForSale.forEach(ProductForSale::showDetails);
    }

    public static void listProducts() {
        for (var item : productsForSale) {
            System.out.println("-".repeat(30));
            item.showDetails();
        }
    }

    public static void addItemToOrder(ArrayList<OrderItem> order, int orderIndex,
                                      int quantity) {
        order.add(new OrderItem(productsForSale.get(orderIndex), quantity));
    }

    public static void printOrder(ArrayList<OrderItem> orderItems) {
        double total = 0;
        for (OrderItem item : orderItems) {
            item.product().printPricedItem(item.quantity());
            total += item.product().getSalesPrice(item.quantity());
        }

        System.out.println("-".repeat(90));
        System.out.printf("Total: %6.2f %n", total);
    }
}
