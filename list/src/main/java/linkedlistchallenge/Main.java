package linkedlistchallenge;

import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        LinkedList<Destination> list = new LinkedList<>();
        list.add(new Destination("Sidney", 0d));
        list.add(new Destination("Melbourne", 877d));
        list.add(new Destination("Adelaide", 1374d));
        list.add(new Destination("Alice Springs", 2771d));
        list.add(new Destination("Perth", 3923d));
        list.add(new Destination("Darwin", 3927d));
        new Destinations(list).run();
    }
}
