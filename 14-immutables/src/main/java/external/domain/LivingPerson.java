package external.domain;

import immutables.PersonImmutable;

import java.util.Arrays;

public class LivingPerson extends PersonImmutable {

    public LivingPerson(String name, PersonImmutable[] kids) {
        super(name, null, kids == null ? new PersonImmutable[10] : Arrays.copyOf(kids, 10));
    }

    protected LivingPerson(PersonImmutable person) {
        super(person);
    }

    public void addKid(PersonImmutable personImmutable) {
        for (int i = 0; i < kids.length; i++) {
            if (kids[i] == null) {
                kids[i] = personImmutable;
                break;
            }
        }
    }
}
