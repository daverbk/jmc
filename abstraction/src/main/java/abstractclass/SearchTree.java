package abstractclass;

public class SearchTree implements NodeList {
    private ListItem root;

    public SearchTree(ListItem root) {
        this.root = root;
    }

    @Override
    public boolean addItem(ListItem item) {
        ListItem initialRoot = root;
        while (item.compareTo(root) < 0) {
            root = root.previous();
            if (root.previous() == null) {
                root.setPrevious(item);
                root = initialRoot;
                return true;
            }
        }

        while (item.compareTo(root) > 0) {
            root = root.next();
            if (root.next() == null) {
                root.setNext(item);
                root = initialRoot;
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean removeItem(ListItem item) {
        ListItem initialRoot = root;
        while (item.compareTo(root) < 0) {
            root = root.previous();
            if (root.previous().compareTo(item) == 0) {
                performRemoval(root.previous(), root);
                root = initialRoot;
                return true;
            }
        }

        while (item.compareTo(root) > 0) {
            root = root.next();
            if (root.next().compareTo(item) == 0) {
                performRemoval(root.next(), root);
                root = initialRoot;
                return true;
            }
        }

        return false;
    }

    @Override
    public void traverse(ListItem root) {
        if (root.previous() != null) {
            System.out.println(root.previous().getValue());
        }

        System.out.println(root.previous().getValue());

        if (root.next() != null) {
            System.out.println(root.next().getValue());
        }

        if (root.previous() != null) {
            traverse(root.previous());
        }

        if (root.next() != null) {
            traverse(root.next());
        }
    }

    @Override
    public ListItem getRoot() {
        return root;
    }

    private void performRemoval(ListItem item, ListItem parent) {
        
    }
}
