package compositionchallenge;

public class Refrigerator extends Appliance {
    public void orderFood() {
        if (hasWorkToDo()) {
            System.out.println("Bread, cheese and ham have been ordered");
            setHasWorkToDo(false);
        }
    }
}
