package burgerchallenge.burgerstuff;

import burgerchallenge.Product;

public class Burger extends Product {
    protected Topping topping;
    protected Topping topping2;
    protected Topping topping3;

    public Burger(String type, double price) {
        super(type, price);
    }

    public void addTopping(Topping topping) {
        if (this.topping == null) {
            this.topping = topping;
            this.setPrice(getPrice() + topping.getPrice());
        } else if (topping2 == null) {
            topping2 = topping;
            this.setPrice(getPrice() + topping.getPrice());
        } else if (topping3 == null) {
            topping3 = topping;
            this.setPrice(getPrice() + topping.getPrice());
        } else {
            System.out.println("You've added the maximum possible count of toppings");
        }
    }

    public String getToppings() {
        String toppings = "";

        if (topping != null){
            toppings += topping.getType() + "\n";
        }

        if (topping2 != null){
            toppings += topping2.getType() + "\n";
        }

        if (topping3 != null){
            toppings += topping3.getType() + "\n";
        }

        return toppings;
    }
}
