package abstractclasschallenge;

public class Pen extends ProductForSale {

    public Pen(double price, String description) {
        super("Pen", price, description);
    }

    @Override
    public String showDetails() {
        return "The best pen you can get ...";
    }
}
