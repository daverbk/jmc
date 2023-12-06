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
    int compareTo(ListItem listItem) {
        return listItem.compareTo(this);
    }
}
