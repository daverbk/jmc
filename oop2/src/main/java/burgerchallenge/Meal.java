package burgerchallenge;

import burgerchallenge.burgerstuff.Burger;
import burgerchallenge.burgerstuff.Topping;

public class Meal {
    private Burger burger;
    private SideDish sideDish;
    private Drink drink;

    public Meal() {
        this.burger = new Burger("Classic Burger", 7.99);
        this.sideDish = new SideDish("French Fries", 2.99);
        this.drink = new Drink("Classic Coke","Small");
    }

    public Meal(Burger burger, SideDish sideDish, Drink drink) {
        this.burger = burger;
        this.sideDish = sideDish;
        this.drink = drink;
    }

    public void list() {
        System.out.println("The order contains:");
        System.out.printf("-> %s for %.2f$ %n", burger.getType(), burger.getPrice());
        System.out.printf("\tToppings: %n\t%s%n",
                burger.getToppings().isEmpty() ? "None" : burger.getToppings());
        System.out.printf("-> %s for %.2f$ %n", drink.getType(), drink.getPrice());
        System.out.printf("-> %s for %.2f$ %n", sideDish.getType(), sideDish.getPrice());
    }

    public void printTotal() {
        double total = burger.getPrice() + drink.getPrice()
                + sideDish.getPrice();
        System.out.printf("The total is: %.2f $%n", total);
    }

    public void addBurgerTopping(Topping topping) {
        burger.addTopping(topping);
    }

    public void setDrinkSize(String size) {
        drink.setSize(size);
    }
}
