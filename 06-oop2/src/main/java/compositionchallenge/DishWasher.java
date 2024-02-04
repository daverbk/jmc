package compositionchallenge;

public class DishWasher extends Appliance {
    public void doDishes() {
        if (hasWorkToDo()) {
            System.out.println("Washing the dishes ...");
            setHasWorkToDo(false);
        }
    }
}
