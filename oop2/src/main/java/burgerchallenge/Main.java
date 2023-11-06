package burgerchallenge;

import burgerchallenge.burgerstuff.Burger;
import burgerchallenge.burgerstuff.DeluxeBurger;
import burgerchallenge.burgerstuff.Topping;

public class Main {
    public static void main(String[] args) {

        // Default meal
        Meal defaultMeal = new Meal();
        printOrderData(defaultMeal);

        // Create a meal with a burger and a drink and side item with up to 3 toppings
        Burger burger = new Burger("Cheese Burger", 9.99);
        Drink drink = new Drink("Diet Coke", "Large");
        SideDish sideDish = new SideDish("Salad", 3.99);
        Meal meal2 = new Meal(burger, sideDish, drink);

        // Add a topping
        Topping chickenTopping = new Topping("Chicken Topping", 2.99);
        meal2.addBurgerTopping(chickenTopping);
        printOrderData(meal2);

        // Create a deluxe burger
        Burger deluxeBurger = new DeluxeBurger("Big Burger", 19.99);
        Meal meal3 = new Meal(deluxeBurger, sideDish, drink);
        meal3.addBurgerTopping(chickenTopping);
        printOrderData(meal3);
    }

    public static void printOrderData(Meal order) {
        order.list();
        order.printTotal();
    }
}
