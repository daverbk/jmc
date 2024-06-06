package immutables;

import external.domain.LivingPerson;

public class MainImmutable {
    public static void main(String[] args) {
        PersonImmutable jane = new PersonImmutable("Jane", "01/01/1930");
        PersonImmutable jim = new PersonImmutable("Jim", "02/02/1932");
        PersonImmutable joe = new PersonImmutable("Joe", "03/03/1934");

        PersonImmutable[] johnsKids = {jane, jim, joe};
        PersonImmutable john = new PersonImmutable("John", "05/05/1900", johnsKids);

        System.out.println(john);

        PersonImmutable johnCopy = new PersonImmutable(john);

        PersonImmutable[] kids = john.getKids();
        kids[0] = jim;
        kids[1] = new PersonImmutable("Ann", "04/04/1930");
        System.out.println(john);

        johnsKids[0] = new PersonImmutable("Ann", "04/04/1930");
        System.out.println(john);

        LivingPerson johnLiving = new LivingPerson(john.getName(), john.getKids());
        System.out.println(johnLiving);

        LivingPerson anne = new LivingPerson("Ann", null);
        johnLiving.addKid(anne);
        System.out.println(johnLiving);

        PersonOfInterest johnCopy2 = new PersonOfInterest(johnCopy);
        System.out.println(johnCopy2);

        kids = johnCopy2.getKids();
        kids[0] = anne;
        System.out.println(johnCopy2);
        System.out.println(john);
    }
}
