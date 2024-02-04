package compositionchallenge;

public class Main {

    public static void main(String[] args) {

        CoffeeMaker cm = new CoffeeMaker();
        DishWasher dw = new DishWasher();
        Refrigerator refrigerator = new Refrigerator();
        SmartKitchen sk = new SmartKitchen(cm, dw, refrigerator);

        sk.setKitchenState(true, true, false);
        sk.doKitchenWork();
    }
}
