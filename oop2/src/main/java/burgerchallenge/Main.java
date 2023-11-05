package burgerchallenge;

import burgerchallenge.burgerstuff.Burger;
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
        Meal secondMeal = new Meal(burger, sideDish, drink);

        // Add a topping
        Topping chickenTopping = new Topping("Chicken Topping", 2.99);
        secondMeal.addBurgerTopping(chickenTopping);
        printOrderData(secondMeal);
    }

    public static void printOrderData(Meal order) {
        order.list();
        order.printTotal();
    }
}
