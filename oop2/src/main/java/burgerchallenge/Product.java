package burgerchallenge;

public class Product {
    private String type;
    private double price;

    public Product(String type) {
        this.type = type;
    }

    public Product(String type, double price) {
        this.type = type;
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    protected void setPrice(double price) {
        this.price = price;
    }
}
