package burgerchallenge;

public class Drink extends Product {
    private String size;

    public Drink(String type, String size) {
        super(type);
        setPrice(calculatePrice(size));
        this.size = size;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        setPrice(calculatePrice(size));
        this.size = size;
    }

    private double calculatePrice(String size) {
        return switch (size.toUpperCase().charAt(0)) {
            case 'S' -> 2.99;
            case 'M' -> 3.99;
            case 'L' -> 5.99;
            default -> throw new IllegalArgumentException("Illegal drink size");
        };
    }
}

