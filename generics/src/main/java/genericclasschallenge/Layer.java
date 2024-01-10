package genericclasschallenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Layer<T extends Mappable> {
    private final List<T> elements;

    @SafeVarargs
    public Layer(T... elements) {
        this.elements = new ArrayList<>(Arrays.asList(elements));
    }

    @SafeVarargs
    public final void addMappables(T... mappables) {
        for (T mappable : mappables) {
            if (elements.contains(mappable)) {
                elements.add(mappable);
            }
        }
    }

    public void render() {
        for (T element : elements) {
            element.render();
        }
    }

    public List<T> getMappables() {
        return elements;
    }
}
