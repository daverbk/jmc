package abstractclass;

import java.util.Comparator;

public class Node extends ListItem {
    public Node(Object value) {
        super(value);
    }

    @Override
    ListItem next() {
        return rightLink;
    }

    @Override
    ListItem setNext(ListItem next) {
        rightLink = next;
        return rightLink;
    }

    @Override
    ListItem previous() {
        return leftLink;
    }

    @Override
    ListItem setPrevious(ListItem previous) {
        leftLink = previous;
        return leftLink;
    }

    @Override
    public int compareTo(ListItem item) {
        if (item == null) {
            return -1;
        }
        return ((String) super.getValue()).compareTo((String) item.getValue());
    }
}
