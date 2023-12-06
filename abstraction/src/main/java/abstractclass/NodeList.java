package abstractclass;

public interface NodeList {
    ListItem getRoot();

    boolean addItem(ListItem listItem);

    boolean removeItem(ListItem listItem);

    void traverse(ListItem root);
}
