package abstractclasschallenge;

public abstract class ProductForSale {
    private String type;
    private double price;
    private String description;

    public ProductForSale(String type, double price, String description) {
        this.type = type;
        this.price = price;
        this.description = description;
    }

    public void printLineItem(int quantity) {
        System.out.printf("%d %s(s) %10.2f%n", quantity, type, getSalesPrice(quantity));
    }

    public double getSalesPrice(int quantity) {
        return quantity * price;
    }

    public abstract String showDetails();

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }
}
