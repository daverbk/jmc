package genericclasschallenge;

import java.util.ArrayList;
import java.util.List;

public class Layer<T extends Mappable> {
    private final List<T> elements;

    @SafeVarargs
    public Layer(T... elements) {
        this.elements = new ArrayList<>(List.of(elements));
    }

    @SafeVarargs
    public final void addElements(T... elements) {
        this.elements.addAll(List.of(elements));
    }

    public void renderLayer() {
        for (T element : elements) {
            element.render();
        }
    }
}
