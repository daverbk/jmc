package polymorphism;

public class Main {

    public static void main(String[] args) {
        Car ford = new Ford(8, "Mustang");
        System.out.println(ford.startEngine());

        Car mitsubishi = new Mitsubishi(4, "Lancer");
        System.out.println(mitsubishi.startEngine());
    }
}
