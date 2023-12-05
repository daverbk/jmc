package abstractclasschallenge;

public abstract class OrderItem {
    private ProductForSale productForSale;
    private int quantity;

    public OrderItem(ProductForSale productForSale, int quantity) {
        this.productForSale = productForSale;
        this.quantity = quantity;
    }

    public ProductForSale getProductForSale() {
        return productForSale;
    }

    public int getQuantity() {
        return quantity;
    }
}
