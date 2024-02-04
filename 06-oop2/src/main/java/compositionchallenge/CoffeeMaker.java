package compositionchallenge;

public class CoffeeMaker extends Appliance {
    public void brewCoffee() {
        if (hasWorkToDo()) {
            System.out.println("Brewing a cup of espresso ...");
            setHasWorkToDo(false);
        }
    }
}
