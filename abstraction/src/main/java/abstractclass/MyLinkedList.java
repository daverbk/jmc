package abstractclass;

public class MyLinkedList implements NodeList {
    private ListItem root;

    public MyLinkedList(ListItem root) {
        this.root = root;
    }

    public boolean addItem(ListItem listItem) {
        return root.setNext(listItem).compareTo(listItem) == 0;
    }

    public boolean removeItem(ListItem listItem) {
        return root.setNext(listItem).compareTo(listItem) == 0;
    }

    public void traverse(ListItem root) {

    }

    public ListItem getRoot() {
        return root;
    }
}
