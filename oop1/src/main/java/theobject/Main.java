package theobject;

public class Main extends Object {

    public static void main(String[] args) {
        Student max = new Student("Max", 21);
        System.out.println(max);

        PrimarySchoolStudent jimmy = new PrimarySchoolStudent("Jimmy", 8,
                "Carol");
        System.out.println(jimmy);
    }
}
