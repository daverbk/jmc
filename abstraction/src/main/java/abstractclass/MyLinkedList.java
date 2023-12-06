package abstractclass;

public class MyLinkedList implements NodeList {
    private ListItem root;

    public MyLinkedList(ListItem root) {
        this.root = root;
    }

    public boolean addItem(ListItem item) {
        if (root == null) {
            root = item;
            return true;
        }

        if (item.compareTo(root) < 0) {
            ListItem previous = root.previous();
            previous.setNext(item);
            item.setNext(root);
            return true;
        }

        ListItem initialRoot = root;
        while (item.compareTo(root) > 0) {
            if (root.next() == null) {
                root.setNext(item);
                root = initialRoot;
                return true;
            }

            if (item.compareTo(root.next()) > 0) {
                item.setNext(root.next());
                root.setNext(item);
                root = initialRoot;
                return true;
            }

            root = root.next();
        }

        return false;
    }

    public boolean removeItem(ListItem item) {
        ListItem initialRoot = this.root;
        while (root.next() != null) {

            if (root.compareTo(item) == 0) {
                root.previous().setNext(root.next());
                root = initialRoot;
                return true;
            }

            root = root.next();
        }

        return false;
    }

    public void traverse(ListItem root) {
        if (root == null) {
            System.out.println("The list is empty");
            return;
        }

        ListItem initialRoot = this.root;
        while (root.next() != null) {
            System.out.println(root.next().getValue());
            root = root.next();
        }
        this.root = initialRoot;
    }

    public ListItem getRoot() {
        return root;
    }
}
