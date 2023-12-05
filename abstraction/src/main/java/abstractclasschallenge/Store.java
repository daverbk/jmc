package abstractclasschallenge;

import java.util.ArrayList;

public class Store {
    private static ArrayList<ProductForSale> productsForSale;
    private static ArrayList<OrderItem> orderItems;

    public static void main(String[] args) {
        productsForSale = new ArrayList<>();
    }

    public void addProduct(ProductForSale productForSale) {
        productsForSale.add(productForSale);
    }

    public void addOrderItem(OrderItem orderItem) {
        orderItems.add(orderItem);
    }

    public void displayProductDetails() {
        productsForSale.forEach(ProductForSale::showDetails);
    }

    public void printOrderItems() {
        double total = 0;
        for (OrderItem orderItem : orderItems) {
            orderItem.getProductForSale().printLineItem(
                    orderItem.getQuantity());
            total += orderItem.getProductForSale().getSalesPrice(
                    orderItem.getQuantity());
        }

        System.out.println("-".repeat(30));
        System.out.printf("Total: %10.2f", total);
    }
}
