package innerclasschallenge;

public class Store {
    public static void main(String[] args) {
        Meal regularMeal = new Meal(0.68);
        regularMeal.addToppings("Ketchup", "Mayo", "Cheddar", "Bacon");
        System.out.println(regularMeal);
    }
}
