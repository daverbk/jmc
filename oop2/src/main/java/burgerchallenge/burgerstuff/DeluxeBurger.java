package burgerchallenge.burgerstuff;

public class DeluxeBurger extends Burger {
    private Topping topping4;
    private Topping topping5;

    public DeluxeBurger(String type, double price) {
        super(type, price);
    }

    @Override
    public void addTopping(Topping topping) {
        if (this.topping == null) {
            this.topping = topping;
        } else if (topping2 == null) {
            topping2 = topping;
        } else if (topping3 == null) {
            topping3 = topping;
        } else if (topping4 == null) {
            topping4 = topping;
        } else if (topping5 == null) {
            topping5 = topping;
        } else {
            System.out.println("You've added the maximum possible count of toppings");
        }
    }

    @Override
    public String getToppings() {
        String toppings = super.getToppings();

        if (topping4 != null){
            toppings += topping4.getType() + "\n";
        }

        if (topping5 != null){
            toppings += topping5.getType();
        }

        return toppings;
    }
}
